import java.util.ArrayList;

public class Simulation {

	private static IDatabaseService db = new DatabaseService();

	public void startSimulation() {

		// Reads all data from data base and creates the environment.
		db.getShipPosition();
		ArrayList<Ship> shipList = db.readDatabase();
		String[][] seaGrid = Functions.createGrid();

		// GUI - The sea grid.
		FleetGUI fleetGUI = new FleetGUI();
		fleetGUI.setSize(1000, 1000);
		fleetGUI.setVisible(true);

		// GUI - Text area that prints messages to user.
		FleetInfoGUI fleetInfoGui = new FleetInfoGUI();
		fleetInfoGui.setSize(500, 500);
		fleetInfoGui.setVisible(true);

		boolean run = true;
		while(run) {

			for (Ship ship : shipList) {
				if (ship.getRoute().length() > 0) {
					fleetInfoGui.setInfo(ship.moveShip(seaGrid));

					// Updates database.
					db.updateCurrentCoordinatesAndBearingAndNauticalMilage(ship.getShipId(), ship.getShipLogId(),
							ship.getCurrentCoordinates(), ship.getBearing());
					db.updateCurrentRoute(ship.getShipId(), ship.getShipLogId(), ship.getCurrentRoute());

					// Updates GUI colors.
					fleetGUI.restoreColor(ship.getPreviousCoordinates());
					fleetGUI.changeColor(ship.getShipId(), Functions.convertCoord(ship.getCurrentCoordinates()));

				}
			}

			// Waits 1 second before .
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}

