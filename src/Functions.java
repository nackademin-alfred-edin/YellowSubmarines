import java.util.ArrayList;
import java.util.Random;

public class Functions {

	public static void main(String[] args) {

		createRandomRoute();
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
		seaGrid[0][0] = "A";
		seaGrid[0][99] = "B";
		seaGrid[99][0] = "C";
		seaGrid[99][99] = "D";
		seaGrid[49][49] = "E";

		return seaGrid;
	}

	public static ArrayList<Integer> convertCord(String x) {
		// Converts string coordinates to array list with integers.

		ArrayList<Integer> coord = new ArrayList<Integer>(2);
		String[] stringCoord = new String[2];

		stringCoord = x.split(",");

		for (int i = 0; i < 2; i++) {
			coord.add(Integer.parseInt(stringCoord[i]));
		}
		return coord;
	}

	public static String convertCordToString(ArrayList<Integer> intCoord) {
		// Converts int array list values to a string.
		String stringCoord = "";

		stringCoord = (intCoord.get(0) + "," + intCoord.get(1));

		return stringCoord;
	}

}
