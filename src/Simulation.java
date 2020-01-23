import java.util.ArrayList;

public class Simulation {

	private static IDatabaseService db = new DatabaseService();

	public void startSimulation() {
		db.getShipPosition();
		ArrayList<Ship> shipList = db.readDatabase();
		String[][] seaGrid = Functions.createGrid();
//		ArrayList<Integer> coordinates;
		FleetGUI fleetGUI = new FleetGUI();
		fleetGUI.setSize(1000, 1000);
		fleetGUI.setVisible(true);

		FleetInfoGUI fleetInfoGui = new FleetInfoGUI();
		fleetInfoGui.setSize(500, 500);
		fleetInfoGui.setVisible(true);

		boolean run = true;

		while(run) {

			for (Ship ship : shipList) {

				if (ship.getRoute().length() > 0) {
					fleetInfoGui.setInfo(ship.moveShip(seaGrid));
					db.updateCurrentCoordinatesAndBearing(ship.getShipId(), ship.getShipLogId(),
							ship.getCurrentCoordinates(), ship.getBearing());
					fleetGUI.restoreColor(ship.getPreviousCoordinates());
					fleetGUI.changeColor(ship.getShipId(), Functions.convertCoord(ship.getCurrentCoordinates()));
					db.updateCurrentRoute(ship.getShipId(), ship.getShipLogId(), ship.getCurrentRoute());

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

