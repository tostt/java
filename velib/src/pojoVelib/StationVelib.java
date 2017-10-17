package pojoVelib;

public class StationVelib {
	private String datasetid;
	private String recordid;
	private Geometry geometry;
	private Fields fields;

	public String getDatasetid() {
		return datasetid;
	}

	public void setDatasetid(String datasetid) {
		this.datasetid = datasetid;
	}

	public String getRecordid() {
		return recordid;
	}

	public void setRecordid(String recordid) {
		this.recordid = recordid;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public Fields getFields() {
		return fields;
	}

	public void setFields(Fields fields) {
		this.fields = fields;
	}

	@Override
	public String toString() {
		return "ClassPojo [datasetid = " + datasetid + ", recordid = " + recordid + ", geometry = " + geometry
				+ ", fields = " + fields + "]";
	}
}
