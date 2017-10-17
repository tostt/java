package vlib;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import pojoVelib.StationVelib;

// fichier JSON: https://www.data.gouv.fr/fr/datasets/stations-velib-disponibilites-en-temps-reel-prs/
// Paris.json : https://developer.jcdecaux.com/#/opendata/vls?page=static

public class Main {

	public static void main(String[] args) {

		try {

			//String path = "Paris.json";
			String path = "stations-velib-disponibilites-en-temps-reel.json";
			InputStream inputStream = new FileInputStream(path);
			String json = getJsonFromFile(inputStream);

			Gson gson = new Gson();

			Collection<StationVelib> stations = gson.fromJson(json, new TypeToken<Collection<StationVelib>>() {
			}.getType());
			Collection<StationVelib> stationsBonus = new HashSet<>();
			Collection<StationVelib> stationsNonBonus = new HashSet<>();

			stations.stream().forEach(s -> {
				if (s.getFields().getBonus().equals("True")) {
					stationsBonus.add(s);
				} else {
					stationsNonBonus.add(s);
				}
			});

			List<TupleStationNonBonusStationBonusDistance> lstTuples = new ArrayList<>();
			
			// Boucle sur stations non bonus
			for (StationVelib s1 : stationsNonBonus) {

				double dNearest = 100000; // = 100 km
				StationVelib sNearest = null;

				// Boucle pour chercher la station bonus la plus proche
				for (StationVelib s2 : stationsBonus) {
					double lat1 = Double.valueOf(s1.getFields().getPosition()[0]);
					double lat2 = Double.valueOf(s2.getFields().getPosition()[0]);
					double lon1 = Double.valueOf(s1.getFields().getPosition()[1]);
					double lon2 = Double.valueOf(s2.getFields().getPosition()[1]);
					double el1 = 0.0d;
					double el2 = 0.0d;
					double d = Distance.distance(lat1, lat2, lon1, lon2, el1, el2);
					if (d < dNearest) {
						dNearest = d;
						sNearest = s2;
					}
				}
				lstTuples.add(new TupleStationNonBonusStationBonusDistance(s1, sNearest, dNearest));
			}

			Collections.sort(lstTuples);
			
			System.out.println("Station / Station Bonus la plus proche / Distance (m)");
			for (TupleStationNonBonusStationBonusDistance t : lstTuples) {
				System.out.println(
						padRight(t.getStationNonBonus().getFields().getName(), 50) + " " + padRight(t.getStationBonus().getFields().getName(), 50) + " " + t.getDistance());
			}

			System.out.println("Nombre total stations           : " + stations.size());
			System.out.println("Nombre total stations non bonus : " + stationsNonBonus.size());
			System.out.println("Nombre total stations bonus     : " + stationsBonus.size());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static String getJsonFromFile(InputStream is) throws IOException {
		BufferedReader streamReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		StringBuilder responseStrBuilder = new StringBuilder();
		String inputStr;
		while ((inputStr = streamReader.readLine()) != null)
			responseStrBuilder.append(inputStr);
		streamReader.close();
		return responseStrBuilder.toString();
	}

	// http://www.rgagnon.com/javadetails/java-0448.html
	public static String padRight(String s, int n) {
		return String.format("%1$-" + n + "s", s);
	}
}
