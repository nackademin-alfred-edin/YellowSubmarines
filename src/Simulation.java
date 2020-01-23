import java.util.ArrayList;

public class Simulation {

	private static IDatabaseService db = new DatabaseService();

	public void startSimulation() {
		db.getShipPosition();
		ArrayList<Ship> shipList = db.readDatabase();
		String[][] seaGrid = Functions.createGrid();
		ArrayList<Integer> coordinates;
		FleetGUI f = new FleetGUI();
		f.setSize(1000, 1000);
		f.setVisible(true);

		boolean run = true;

		while(run) {

			for (Ship ship : shipList) {

				if (ship.getRoute().length() > 0) {

					seaGrid = ship.moveShip(seaGrid);
					f.restoreColor(ship.previousCoordinates);
					f.changeColor(ship.getShipId(), Functions.convertCoord(ship.getCurrentCoordinates()));
				}
			}

//			for (int i = 0; i < seaGrid.length; i++) {
//				for (int j = 0; j < seaGrid.length; j++) {
//					System.out.print(seaGrid[i][j]);
//				}
//				System.out.println();
//
//			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e);
			}

//			System.out.println(
//					"-----------------------------------------------------------------------------------------------------------------------------");
			// Functions.clearScreen();
		}
	}

}

