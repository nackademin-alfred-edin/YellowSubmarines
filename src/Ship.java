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

	public void moveShip() {

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

	public void goSouth(int movingDistance, ArrayList<Integer> currentCoordinates,
			ArrayList<Integer> destinationCoordinates) {
		
		for (int i = 0; i < movingDistance; i++) {
			if ((currentCoordinates.get(0) == destinationCoordinates.get(0))) {

				this.destinationCoordinates = "";

				// Update
				this.currentCoordinates = Functions.convertCoordToString(currentCoordinates);
				this.dock();
				this.unloadAndLoad();
				this.updateRoute();
				this.undock();

				// update database
				
				break;
			} else
				currentCoordinates.set(0, currentCoordinates.get(0) + 1);
			this.currentCoordinates = Functions.convertCoordToString(currentCoordinates);
		}
	}

	public abstract void unloadAndLoad();

}
