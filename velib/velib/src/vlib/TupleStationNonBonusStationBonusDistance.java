package vlib;

import pojoVelib.StationVelib;

public class TupleStationNonBonusStationBonusDistance implements Comparable<TupleStationNonBonusStationBonusDistance> {
	public StationVelib getStationNonBonus() {
		return stationNonBonus;
	}

	public void setStationNonBonus(StationVelib stationNonBonus) {
		this.stationNonBonus = stationNonBonus;
	}

	public StationVelib getStationBonus() {
		return stationBonus;
	}

	public void setStationBonus(StationVelib stationBonus) {
		this.stationBonus = stationBonus;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	private StationVelib stationNonBonus;
	private StationVelib stationBonus;
	private Double distance;
	
	public TupleStationNonBonusStationBonusDistance(StationVelib stationNonBonus, StationVelib stationBonus, Double distance) {
		super();
		this.stationNonBonus = stationNonBonus;
		this.stationBonus = stationBonus;
		this.distance = distance;
	}

	@Override
	public int compareTo(TupleStationNonBonusStationBonusDistance t) {
		
		// Tri par distances croissantes
		//return this.getDistance().compareTo(t.getDistance());
		
		// Tri par nom station bonus croissant puis sur nom station non bonus croissant
		int compare = this.getStationBonus().getFields().getName().compareTo(t.getStationBonus().getFields().getName());
		if (compare==0) {
			return this.getStationNonBonus().getFields().getName().compareTo(t.getStationNonBonus().getFields().getName());
		}
		else {
			return compare;
		}
	}
	
}
