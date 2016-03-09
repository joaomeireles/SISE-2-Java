package pt.tecnico.sise.jp.curiosity.core;

public enum MarsObjectType {

	UNKNOWN("?"), SPACE(" "), WALL("X"), ENERGY("!");
	
	public String type;
	
	private MarsObjectType(String type){
		this.type = type;
	}
	
}
