package pt.tecnico.sise.jp.curiosity.core;

public class RobotState {

	public enum Direction{
		
//		NORTH("North",{0,1}),SOUTH("South",{0,-1}),WEST("West",{-1,0}),EAST("East",{);
		NORTH("North"),SOUTH("South"),WEST("West"),EAST("East");
		private String direction;

		private Direction(String direction){
			this.setDirection(direction);

		}

	}
	
	private int robotPositionX;
	private int robotPositionY;
	
	private Direction direction;
	private int energyLevel;
	
	public RobotState(int robotPositionX, int robotPositionY, int energyLevel){
		this.setRobotPositionX(robotPositionX);
		this.setRobotPositionY(robotPositionY);
		this.setEnergyLevel(energyLevel);
		this.setDirection(Direction.NORTH);
	}

	public int getRobotPositionX() {
		return this.robotPositionX;
	}

	public void setRobotPositionX(int robotPositionX) {
		this.robotPositionX = robotPositionX;
	}

	public int getRobotPositionY() {
		return robotPositionY;
	}

	public void setRobotPositionY(int robotPositionY) {
		this.robotPositionY = robotPositionY;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
}
