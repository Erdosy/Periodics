package shapeGroupPeriodics;

import java.sql.Date;


public class Machine {
	private String serial;
	private Date lastUpdated;
	@SuppressWarnings("rawtypes")
	private KeyValueMap shapeGroupCounters;
	
	@SuppressWarnings("rawtypes")
	public Machine(String serial, Date lastUpdated) {
		this.serial = serial;
		this.lastUpdated = lastUpdated;
		shapeGroupCounters = new KeyValueMap();
	}
	
	@SuppressWarnings("unchecked")
	public void setNewCounter(Integer key, Integer value) {
		shapeGroupCounters.put(key, value);
	}
	
	/**
	 * Creates a string representation of machine
	 * @return String representation of machine in comma separated format
	 */
	@SuppressWarnings("unchecked")
	public String toString() {
		String stringRepresentation = serial + ";";
		stringRepresentation += lastUpdated + ";";
		
		for(int i = 0; i < Parser.selectedShapeGroups.length; i++) {
			stringRepresentation += shapeGroupCounters.get(Parser.selectedShapeGroups[i]) + ";";
		}
		stringRepresentation += "\n";
		return stringRepresentation;
	}
	
}
