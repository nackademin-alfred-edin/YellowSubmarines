import java.util.ArrayList;

public abstract class Ship {

	public int shipId;
	public int shipLogId;
	public String name;
	public int maxSpeed;
	public int cruisingSpeed;
	public int currentSpeed;
	public String bearing;
	public String cargo;
	public String currentCoordinates;
	public String startCoordinates;
	public String destinationCoordinates;
	public String route;
	public int nauticMilage;
	public boolean docked;
	public int MAX_CARGO_WEIGHT;
	public int cargoWeight;

	public Ship() {
	}

	public Ship(int shipId, int shipLogId, String name, int maxSpeed, int cruisingSpeed, int currentSpeed,
			String bearing, String cargo, String currentCoordinates, String startCoordinates,
			String destinationCoordinates, String route, int nauticMilage, boolean docked,
			int MAX_CARGO_WEIGHT, int cargoWeight) {
		super();
		this.MAX_CARGO_WEIGHT = MAX_CARGO_WEIGHT;
		this.shipId = shipId;
		this.shipLogId = shipLogId;
		this.name = name;
		this.maxSpeed = maxSpeed;
		this.cruisingSpeed = cruisingSpeed;
		this.currentSpeed = currentSpeed;
		this.bearing = bearing;
		this.cargo = cargo;
		this.currentCoordinates = currentCoordinates;
		this.startCoordinates = startCoordinates;
		this.destinationCoordinates = destinationCoordinates;
		this.route = route;
		this.nauticMilage = nauticMilage;
		this.docked = docked;
		this.cargoWeight = cargoWeight;
	}


	public void dock() {
		System.out.println("Docking...");
		this.docked = true;

	}

	public void undock() {
		System.out.println("Undocking...");
		this.docked = false;
	}


	public void updateRoute() {

		// Set ship Start coordinates to current harbor.
		this.startCoordinates = this.currentCoordinates;

		// Set ship Destination coordinates to the new first index in route.
		String[] route = Functions.splitString(this.route);
		route = Functions.removeFirstIndex(route);
		this.destinationCoordinates = route[0];
		this.route = Functions.joinSplittedArray(route);
	}

	public String[][] moveShip(String[][] seaGrid) {

		int movingDistance = (this.currentSpeed / 10);
		int[] currentCoordinates = Functions.convertCoord(this.currentCoordinates);
		int[] destinationCoordinates = Functions.convertCoord(this.destinationCoordinates);

		// Bearing: S
		if (currentCoordinates[0] < destinationCoordinates[0] && currentCoordinates[1] == destinationCoordinates[1]) {
			this.goSouth(movingDistance, currentCoordinates, destinationCoordinates);

		} // Bearing: N
		else if (currentCoordinates[0] > destinationCoordinates[0]
				&& currentCoordinates[1] == destinationCoordinates[1]) {
			this.goNorth(movingDistance, currentCoordinates, destinationCoordinates);

		} // Bearing: E
		else if (currentCoordinates[0] == destinationCoordinates[1]
				&& currentCoordinates[0] < destinationCoordinates[0]) {
			this.goEast(movingDistance, currentCoordinates, destinationCoordinates);

		} // Bearing: W
		else if (currentCoordinates[1] == destinationCoordinates[1]
				&& currentCoordinates[0] > destinationCoordinates[0]) {
			this.goWest(movingDistance, currentCoordinates, destinationCoordinates);

		} // Bearing: SE
		else if (currentCoordinates[1] < destinationCoordinates[1]
				&& currentCoordinates[0] < destinationCoordinates[0]) {
			this.goSouthEast(movingDistance, currentCoordinates, destinationCoordinates);

		} // Bearing: NW
		else if (currentCoordinates[1] > destinationCoordinates[1]
				&& currentCoordinates[0] > destinationCoordinates[0]) {
			this.goNorthWest(movingDistance, currentCoordinates, destinationCoordinates);

		} // Bearing: SW
		else if (currentCoordinates[1] < destinationCoordinates[1]
				&& currentCoordinates[0] > destinationCoordinates[0]) {
			this.goSouthWest(movingDistance, currentCoordinates, destinationCoordinates);

		} // Bearing: NE
		else if (currentCoordinates[1] > destinationCoordinates[1]
				&& currentCoordinates[0] < destinationCoordinates[0]) {
			this.goNorthEast(movingDistance, currentCoordinates, destinationCoordinates);
		}
		
		int[] coord = Functions.convertCoord(this.currentCoordinates);
		seaGrid[coord[0]][coord[1]] = "X";
		
		return seaGrid;

	}

	public void goSouth(int movingDistance, int[] currentCoordinates,
			ArrayList<Integer> destinationCoordinates) {

		for (int i = 0; i < movingDistance; i++) {

			currentCoordinates[0] = currentCoordinates[0] + 1;
			
			this.currentCoordinates = Functions.convertCoordToString(currentCoordinates);
			this.bearing = "S";
			

			if ((currentCoordinates.get(0) == destinationCoordinates.get(0))) {

				this.destinationCoordinates = "";

				// Update object
				this.currentCoordinates = Functions.convertCoordToString(currentCoordinates);
				this.dock();
				this.unloadAndLoad();
				this.updateRoute();
				this.undock();

				// update database
				break;
			}
		}
	}

	public void goNorth(int movingDistance, ArrayList<Integer> currentCoordinates,
			ArrayList<Integer> destinationCoordinates) {

		for (int i = 0; i > movingDistance; i++) {

			currentCoordinates.set(0, currentCoordinates.get(0) - 1);
			this.currentCoordinates = Functions.convertCoordToString(currentCoordinates);
			this.bearing = "N";

			if ((currentCoordinates.get(0) == destinationCoordinates.get(0))) {

				// Update object
				this.currentCoordinates = Functions.convertCoordToString(currentCoordinates);
				this.dock();
				this.unloadAndLoad();
				this.updateRoute();
				this.undock();

				break;
			}
		}
	}

	public void goEast(int movingDistance, ArrayList<Integer> currentCoordinates,

			ArrayList<Integer> destinationCoordinates) {

		for (int i = 0; i > movingDistance; i++) {

			currentCoordinates.set(1, currentCoordinates.get(1) + 1);
			this.currentCoordinates = Functions.convertCoordToString(currentCoordinates);
			this.bearing = "E";

			if ((currentCoordinates.get(1) == destinationCoordinates.get(1))) {

				// Update object
				this.currentCoordinates = Functions.convertCoordToString(currentCoordinates);
				this.dock();
				this.unloadAndLoad();
				this.updateRoute();
				this.undock();
				break;
			}
		}
	}

	public void goWest(int movingDistance, ArrayList<Integer> currentCoordinates,
			ArrayList<Integer> destinationCoordinates) {

		for (int i = 0; i > movingDistance; i++) {

			currentCoordinates.set(1, currentCoordinates.get(1) - 1);
			this.currentCoordinates = Functions.convertCoordToString(currentCoordinates);
			this.bearing = "W";

			if ((currentCoordinates.get(1) == destinationCoordinates.get(1))) {

				// Update object
				this.currentCoordinates = Functions.convertCoordToString(currentCoordinates);
				this.dock();
				this.unloadAndLoad();
				this.updateRoute();
				this.undock();
				break;
			}
		}

	}
	
	public void goSouthEast(int movingDistance, ArrayList<Integer> currentCoordinates,
			ArrayList<Integer> destinationCoordinates) {

		for (int i = 0; i > movingDistance; i++) {

			currentCoordinates.set(0, currentCoordinates.get(0) + 1);
			currentCoordinates.set(1, currentCoordinates.get(1) + 1);
			this.currentCoordinates = Functions.convertCoordToString(currentCoordinates);
			this.bearing = "SE";

			if ((currentCoordinates.get(1) == destinationCoordinates.get(1))) {

				// Update object
				this.currentCoordinates = Functions.convertCoordToString(currentCoordinates);
				this.dock();
				this.unloadAndLoad();
				this.updateRoute();
				this.undock();
				break;
			}
		}

	}
	
	public void goNorthWest(int movingDistance, ArrayList<Integer> currentCoordinates,
			ArrayList<Integer> destinationCoordinates) {

		for (int i = 0; i > movingDistance; i++) {

			currentCoordinates.set(0, currentCoordinates.get(0) - 1);
			currentCoordinates.set(1, currentCoordinates.get(1) - 1);
			this.currentCoordinates = Functions.convertCoordToString(currentCoordinates);
			this.bearing = "NW";

			if ((currentCoordinates.get(1) == destinationCoordinates.get(1))) {

				// Update object
				this.currentCoordinates = Functions.convertCoordToString(currentCoordinates);
				this.dock();
				this.unloadAndLoad();
				this.updateRoute();
				this.undock();
				break;
			}
		}
	}
		
	public void goNorthEast(int movingDistance, ArrayList<Integer> currentCoordinates,
			ArrayList<Integer> destinationCoordinates) {

		for (int i = 0; i > movingDistance; i++) {

			currentCoordinates.set(0, currentCoordinates.get(0) - 1);
			currentCoordinates.set(1, currentCoordinates.get(1) + 1);
			this.currentCoordinates = Functions.convertCoordToString(currentCoordinates);
			this.bearing = "NE";

			if ((currentCoordinates.get(1) == destinationCoordinates.get(1))) {

				// Update object
				this.currentCoordinates = Functions.convertCoordToString(currentCoordinates);
				this.dock();
				this.unloadAndLoad();
				this.updateRoute();
				this.undock();
				break;
			}
		}
}

	public void goSouthWest(int movingDistance, ArrayList<Integer> currentCoordinates,
			ArrayList<Integer> destinationCoordinates) {

		for (int i = 0; i > movingDistance; i++) {

			currentCoordinates.set(0, currentCoordinates.get(0) + 1);
			currentCoordinates.set(1, currentCoordinates.get(1) - 1);
			this.currentCoordinates = Functions.convertCoordToString(currentCoordinates);
			this.bearing = "SW";

			if ((currentCoordinates.get(1) == destinationCoordinates.get(1))) {

				// Update object
				this.currentCoordinates = Functions.convertCoordToString(currentCoordinates);
				this.dock();
				this.unloadAndLoad();
				this.updateRoute();
				this.undock();
				break;
			}
		}
	}
	
	public abstract void unloadAndLoad();


}
