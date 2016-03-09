package pt.tecnico.sise.jp.curiosity.core;

import java.util.Arrays;
import java.util.Random;

import pt.tecnico.sise.jp.curiosity.RobotAction;
import pt.tecnico.sise.jp.curiosity.RobotController;
import pt.tecnico.sise.jp.curiosity.Simulator;
import pt.tecnico.sise.jp.curiosity.Simulator.Map;
import pt.tecnico.sise.jp.curiosity.Simulator.Speed;

public class Curiosity {

	private static RobotState robot;
	private static MarsObjects[][] map;
	private static MarsWall wall = new MarsWall();
	private static MarsUnknown unknown = new MarsUnknown();
	private static MarsSpace space = new MarsSpace();

	public static void configLandingSite(int landingLine, int landingColumn, int numLines, int numColumns) {
		// Initialize the robot state
		// You are supposed to use/save initial information to be used in the
		// controlRobot method.
		robot = new RobotState(landingColumn, landingLine, RobotController.getEnergy());
		map = new MarsObjects[numLines][numColumns];
		for (MarsObjects[] each : map) {
			Arrays.fill(each, unknown);
		}
		map[landingLine][landingColumn] = space;
		printMap(map);
	}

	private static void printMap(MarsObjects[][] map) {
		System.out.println("--- CURIOSITY MAP ---");
		for (MarsObjects[] eachRow : map) {
			for (MarsObjects eachElement : eachRow) {
				System.out.print(eachElement.getObjecttype().type);
			}
			System.out.print("\n");
		}
	}

	public static RobotAction controlRobot() {
		// This is a dummy algorithm that does not save any info.
		// You are supposed to improve this
		if (RobotController.senseSpace()) {
			return RobotAction.MOVE;
		} else {
			Random rnd = new Random();
			int n = rnd.nextInt(2);
			if (n == 0) {
				return RobotAction.TURN_LEFT;
			} else {
				return RobotAction.TURN_RIGHT;
			}
		}
	}

	public static int[] checkAround(String side) {

		switch (side) {
		case ("Left"):
			switch (robot.getDirection()) {
			case NORTH:
				return new int[] { robot.getRobotPositionX() + 1, robot.getRobotPositionY() };
			case WEST:
				return new int[] { robot.getRobotPositionX(), robot.getRobotPositionY() - 1 };
			case SOUTH:
				return new int[] { robot.getRobotPositionX() - 1, robot.getRobotPositionY() };
			case EAST:
				return new int[] { robot.getRobotPositionX() - 1, robot.getRobotPositionY() };
			default:
				return new int[] { robot.getRobotPositionX() + 1, robot.getRobotPositionY() };
			}
		}

	}

	public static void transmitState(String filename) {
		// Write the discovered map to a file with the provided filename.
		// For now you can just write it to the console.
		// Writing to a file is not that different and will be easy to adapt.
		System.out.println("Writing to filename " + filename);
	}

	public static void main(String[] args) {
		// You can try Map.WORLD01 Map.WORLD02 Map.WORLD03 Map.WORLD04
		// Map.WORLD05
		// and speeds Speed.SLOW Speed.NORMAL Speed.FAST
		Simulator.run(Map.WORLD02, Speed.NORMAL);
	}

}
