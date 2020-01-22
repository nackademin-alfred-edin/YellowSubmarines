
public class Simulation {

	private static IDatabaseService db = new DatabaseService();

	public void startSimulation() {

		db.readDatabase();
		db.updateCurrentCoordinate(1, 1, "88,88");

	}

}
