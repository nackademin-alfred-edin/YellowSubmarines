import java.util.ArrayList;

public class Simulation {

	private static IDatabaseService db = new DatabaseService();

	public void startSimulation() {
		db.getShipPosition();

		ArrayList<Ship> shipList = db.readDatabase();
		String[][] seaGrid = Functions.createGrid();
		ArrayList<Integer> coordinates;

		for (Ship ship : shipList) {

			coordinates = Functions.convertCoord(ship.currentCoordinates);
			seaGrid[coordinates.get(0)][coordinates.get(1)] = "x";
		}

			
		for (int i = 0; i < seaGrid.length; i++) {
			for (int j = 0; j < seaGrid.length; j++) {
				System.out.print(seaGrid[i][j]);
			}
			System.out.println();

		}

	}

}
