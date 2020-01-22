import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Functions {

	public static void main(String[] args) {

		createRandomRoute();
	}

	public static String[] removeFirstIndex(String[] route) {

		String[] stripedRoute = Arrays.copyOfRange(route, 1, route.length);

		return stripedRoute;
	}

	public static String[] splitString(String route) {
		String[] array = route.split("-");
		return array;
	}

	public static String joinSplittedArray(String[] route) {
		String routeString = String.join("-", route);
		return routeString;
	}

	public static void moveShip(Ship ship, String[][] seaGrid) {

		int movingDistance = (ship.currentSpeed / 10);
		ArrayList<Integer> currentCoordinates = convertCoord(ship.currentCoordinates);
		ArrayList<Integer> destinationCoordinates = convertCoord(ship.destinationCoordinates);


		// Bearing: S e.g. [0,0] -> [99,0]
		if (currentCoordinates.get(0) < destinationCoordinates.get(0)
				&& currentCoordinates.get(1) == destinationCoordinates.get(1)) {

			for (int i = 0; i < movingDistance; i++) {
				if ((currentCoordinates.get(0) == destinationCoordinates.get(0))) {

					ship.destinationCoordinates = "";
					ship.unloadAndLoad();

					// Update
					ship.currentCoordinates = convertCoordToString(currentCoordinates);
					ship.dock();

					ship.updateRoute(ship);

					// update database
					
					ship.undock();

					break;
				} else
					currentCoordinates.set(0, currentCoordinates.get(0) + 1);
				ship.currentCoordinates = convertCoordToString(currentCoordinates);
			}



		} // Bearing: N e.g. [99,0] -> [0,0]
		else if (currentCoordinates.get(0) > destinationCoordinates.get(0)
				&& currentCoordinates.get(1) == destinationCoordinates.get(1)) {

			for (int i = 0; i > movingDistance; i++) {
				if ((currentCoordinates.get(0) == destinationCoordinates.get(0))) {

					// Update
					ship.currentCoordinates = convertCoordToString(currentCoordinates);
					break;
				}

				else
					currentCoordinates.set(0, currentCoordinates.get(0) - 1);
			}

		} // Bearing: E e.g. [0,0] -> [0,99]
		else if (currentCoordinates.get(1) == destinationCoordinates.get(1)
				&& currentCoordinates.get(0) < destinationCoordinates.get(0)) {

			for (int i = 0; i > movingDistance; i++) {
				if ((currentCoordinates.get(1) == destinationCoordinates.get(1)))
					// Update

					break;
				else
					currentCoordinates.set(1, currentCoordinates.get(1) + 1);
			}

		} // Bearing: W e.g. [0,99] -> [0,0]
		else if (currentCoordinates.get(1) == destinationCoordinates.get(1)
				&& currentCoordinates.get(0) > destinationCoordinates.get(0)) {

			for (int i = 0; i > movingDistance; i++) {
				if ((currentCoordinates.get(1) == destinationCoordinates.get(1)))
					// Update

					break;
				else
					currentCoordinates.set(1, currentCoordinates.get(1) - 1);
			}


		} // Bearing: SE e.g. [0,0] -> [99,99]
		else if (currentCoordinates.get(1) < destinationCoordinates.get(1)
				&& currentCoordinates.get(0) < destinationCoordinates.get(0)) {

		} // Bearing: NW e.g. [99,99] -> [0,0]
		else if (currentCoordinates.get(1) > destinationCoordinates.get(1)
				&& currentCoordinates.get(0) > destinationCoordinates.get(0)) {

		} // Bearing: SW e.g. [0,99] -> [99,0]
		else if (currentCoordinates.get(1) < destinationCoordinates.get(1)
				&& currentCoordinates.get(0) > destinationCoordinates.get(0)) {

		} // Bearing: NE e.g. [99,0] -> [0,99]
		else if (currentCoordinates.get(1) > destinationCoordinates.get(1)
				&& currentCoordinates.get(0) < destinationCoordinates.get(0)) {
		}

	}


	public static ArrayList<String> createRandomRoute() {

		Random r = new Random();
		int randomNumber;
		int numberOfStops = r.nextInt(5);
		numberOfStops += 1;

		ArrayList<String> route = new ArrayList<String>(numberOfStops);

		String a = "0,0";
		String b = "0,99";
		String c = "99,0";
		String d = "99,99";
		String e = "49,49";
		String[] arr = { a, b, c, d, e };
		String[] route1 = new String[5];

		for (int i = 0; i < numberOfStops; i++) {

			randomNumber = r.nextInt(4);
			randomNumber += 1;
			route1[i] = arr[randomNumber];
			route.add(arr[i]);
		}

		for (int i = 0; i < numberOfStops; i++) {

			System.out.println(route1[i]);
		}

		return route;
	}

	public static String[][] createGrid() {
		// Creates a grid and sets the harbours.

		String[][] seaGrid = new String[100][100];

		for (int i = 0; i < seaGrid.length; i++) {
			for (int j = 0; j < seaGrid.length; j++) {
				seaGrid[i][j] = "[ ]";
			}
		}

		seaGrid[0][0] = "A";
		seaGrid[0][99] = "B";
		seaGrid[99][0] = "C";
		seaGrid[99][99] = "D";
		seaGrid[49][49] = "E";

		return seaGrid;
	}

	public static ArrayList<Integer> convertCoord(String stringCoordinates) {
		// Converts string coordinates to array list with integers.

		ArrayList<Integer> coord = new ArrayList<Integer>(2);
		String[] stringCoord = new String[2];

		stringCoord = stringCoordinates.split(",");

		for (int i = 0; i < 2; i++) {
			coord.add(Integer.parseInt(stringCoord[i]));
		}
		return coord;
	}

	public static String convertCoordToString(ArrayList<Integer> intCoord) {
		// Converts int array list values to a string.
		String stringCoord = "";

		stringCoord = (intCoord.get(0) + "," + intCoord.get(1));

		return stringCoord;
	}

}
