import java.util.ArrayList;

public class Simulation {

	private static IDatabaseService db = new DatabaseService();

	public void startSimulation() {
		db.getShipPosition();

		ArrayList<Ship> shipList = db.readDatabase();
		String[][] seaGrid = Functions.createGrid();
		boolean run = true;
		
		while(run) {
			
			for (Ship ship : shipList) {
				
				seaGrid = ship.moveShip(seaGrid);
			}

			for (int i = 0; i < seaGrid.length; i++) {
				for (int j = 0; j < seaGrid.length; j++) {
					System.out.print(seaGrid[i][j]);
				}
				System.out.println();

			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e);
			}

			System.out.println(
					"-----------------------------------------------------------------------------------------------------------------------------");
//			Functions.clearScreen();
		}
	}

}

