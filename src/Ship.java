public abstract class Ship {


	private int shipId;
	private int shipLogId;
	private int maxSpeed;
	private int cruisingSpeed;
	private String name;
	private int currentSpeed;
	private String bearing;
	private String cargo;
	private String currentCoordinates;
	private String startCoordinates;
	private String destinationCoordinates;
	private String route;
	private int nauticMilage;
	private boolean docked;
	private int maxCargoWeight;
	private int cargoWeight;
	public int[] previousCoordinates;

	public Ship() {

	}

	public Ship(int shipId, int shipLogId, int maxSpeed, int cruisingSpeed, String name, int currentSpeed,
			String bearing, String cargo, String currentCoordinates, String startCoordinates,
			String destinationCoordinates, String route, int nauticMilage, boolean docked, int maxCargoWeight,
			int cargoWeight, int[] previousCoordinates) {
		super();
		this.shipId = shipId;
		this.shipLogId = shipLogId;
		this.maxSpeed = maxSpeed;
		this.cruisingSpeed = cruisingSpeed;
		this.name = name;
		this.currentSpeed = currentSpeed;
		this.bearing = bearing;
		this.cargo = cargo;
		this.currentCoordinates = currentCoordinates;
		this.startCoordinates = startCoordinates;
		this.destinationCoordinates = destinationCoordinates;
		this.route = route;
		this.nauticMilage = nauticMilage;
		this.docked = docked;
		this.setMaxCargoWeight(maxCargoWeight);
		this.cargoWeight = cargoWeight;
		this.previousCoordinates = previousCoordinates;
	}


	public int[] getPreviousCoordinates() {
		return previousCoordinates;
	}

	public void setPreviousCoordinates(int[] previousCoordinates) {
		this.previousCoordinates = previousCoordinates;
	}

	public int getShipId() {
		return shipId;
	}

	public void setShipId(int shipId) {
		this.shipId = shipId;
	}

	public int getShipLogId() {
		return shipLogId;
	}

	public void setShipLogId(int shipLogId) {
		this.shipLogId = shipLogId;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getCruisingSpeed() {
		return cruisingSpeed;
	}

	public void setCruisingSpeed(int cruisingSpeed) {
		this.cruisingSpeed = cruisingSpeed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

	public String getBearing() {
		return bearing;
	}

	public void setBearing(String bearing) {
		this.bearing = bearing;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCurrentCoordinates() {
		return currentCoordinates;
	}

	public void setCurrentCoordinates(String currentCoordinates) {
		this.currentCoordinates = currentCoordinates;
	}

	public String getStartCoordinates() {
		return startCoordinates;
	}

	public void setStartCoordinates(String startCoordinates) {
		this.startCoordinates = startCoordinates;
	}

	public String getDestinationCoordinates() {
		return destinationCoordinates;
	}

	public void setDestinationCoordinates(String destinationCoordinates) {
		this.destinationCoordinates = destinationCoordinates;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public int getNauticMilage() {
		return nauticMilage;
	}

	public void setNauticMilage(int nauticMilage) {
		this.nauticMilage = nauticMilage;
	}

	public int getMaxCargoWeight() {
		return maxCargoWeight;
	}

	public void setMaxCargoWeight(int maxCargoWeight) {
		this.maxCargoWeight = maxCargoWeight;
	}

	public boolean isDocked() {
		return docked;
	}

	public void setDocked(boolean docked) {
		this.docked = docked;
	}

	public int getCargoWeight() {
		return cargoWeight;
	}

	public void setCargoWeight(int cargoWeight) {
		this.cargoWeight = cargoWeight;
	}


	public void dock() {
		System.out.println(this.name + " is docking...   " + this.currentCoordinates);
		this.currentSpeed = 0;
		this.docked = true;

	}

	public void undock() {
		System.out.println(this.name + " is undocking...");
		this.docked = false;
		this.currentSpeed = this.cruisingSpeed;
	}


	public void updateRoute() {

		try {
			// Set ship Start coordinates to current harbor.
			this.startCoordinates = this.currentCoordinates;

			// Set ship Destination coordinates to the new first index in route.
			String[] route = Functions.splitString(this.route);
			route = Functions.removeFirstIndex(route);

			this.destinationCoordinates = route[0];
			this.route = Functions.joinSplittedArray(route);
		} catch (ArrayIndexOutOfBoundsException e) {

			this.destinationCoordinates = this.currentCoordinates;
		}
	}

	public String moveShip(String[][] seaGrid) {

		int movingDistance = (this.currentSpeed / 10);
		// this.setPreviousCoordinates(Functions.convertCoord(this.currentCoordinates));
		this.previousCoordinates = Functions.convertCoord(this.currentCoordinates);
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
		else if (currentCoordinates[0] == destinationCoordinates[0]
				&& currentCoordinates[1] < destinationCoordinates[1]) {
			this.goEast(movingDistance, currentCoordinates, destinationCoordinates);

		} // Bearing: W
		else if (currentCoordinates[0] == destinationCoordinates[0]
				&& currentCoordinates[1] > destinationCoordinates[1]) {
			this.goWest(movingDistance, currentCoordinates, destinationCoordinates);

		} // Bearing: SE
		else if (currentCoordinates[0] < destinationCoordinates[0]
				&& currentCoordinates[1] < destinationCoordinates[1]) {
			this.goSouthEast(movingDistance, currentCoordinates, destinationCoordinates);

		} // Bearing: NW
		else if (currentCoordinates[0] > destinationCoordinates[0]
				&& currentCoordinates[1] > destinationCoordinates[1]) {
			this.goNorthWest(movingDistance, currentCoordinates, destinationCoordinates);

		} // Bearing: SW
		else if (currentCoordinates[0] < destinationCoordinates[0]
				&& currentCoordinates[1] > destinationCoordinates[1]) {
			this.goSouthWest(movingDistance, currentCoordinates, destinationCoordinates);

		} // Bearing: NE
		else if (currentCoordinates[0] > destinationCoordinates[0]
				&& currentCoordinates[1] < destinationCoordinates[1]) {
			this.goNorthEast(movingDistance, currentCoordinates, destinationCoordinates);
		} else {
			System.out.println(this.shipId + " - " + this.name + " has finished it's route.");
			return this.shipId + " - " + this.name + " has finished it's route.";
		}

		int[] coord = Functions.convertCoord(this.currentCoordinates);
		seaGrid[coord[0]][coord[1]] = Integer.toString(this.shipId);

		return "--";
	}

	public void goSouth(int movingDistance, int[] currentCoordinates,
			int[] destinationCoordinates) {

		
		for (int i = 0; i < movingDistance; i++) {
			
			if (currentCoordinates[0] < 99) {
				currentCoordinates[0] = (currentCoordinates[0]) + 1;
				this.currentCoordinates = Functions.convertCoordToString(currentCoordinates);
				this.bearing = "S";
			}

			if ((currentCoordinates[0] == destinationCoordinates[0])) {

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

	public void goNorth(int movingDistance, int[] currentCoordinates,
			int[] destinationCoordinates) {


		for (int i = 0; i < movingDistance; i++) {

			if (currentCoordinates[0] > 0) {
				currentCoordinates[0] = currentCoordinates[0] - 1;

				this.currentCoordinates = Functions.convertCoordToString(currentCoordinates);
				this.bearing = "N";
			}

			if ((currentCoordinates[0] == destinationCoordinates[0])) {

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

	public void goEast(int movingDistance, int[] currentCoordinates,

			int[] destinationCoordinates) {

		for (int i = 0; i < movingDistance; i++) {

			if (currentCoordinates[1] < 99) {
			currentCoordinates[1] = currentCoordinates[1] + 1;
			this.currentCoordinates = Functions.convertCoordToString(currentCoordinates);
			this.bearing = "E";
			}

			if ((currentCoordinates[1] == destinationCoordinates[1])) {

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

	public void goWest(int movingDistance,int[] currentCoordinates,
			int[] destinationCoordinates) {

		for (int i = 0; i < movingDistance; i++) {

			if (currentCoordinates[1] > 0) {
			currentCoordinates[1] = currentCoordinates[1] - 1;
				this.setCurrentCoordinates(Functions.convertCoordToString(currentCoordinates));
				this.setBearing("W");
			}

			if ((currentCoordinates[1] == destinationCoordinates[1])) {

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
	
	public void goSouthEast(int movingDistance, int[] currentCoordinates, int[] destinationCoordinates) {

		for (int i = 0; i < movingDistance; i++) {

			if (currentCoordinates[0] < 99 && currentCoordinates[1] < 99) {
				currentCoordinates[0] = currentCoordinates[0] + 1;
				currentCoordinates[1] = currentCoordinates[1] + 1;
				this.currentCoordinates = Functions.convertCoordToString(currentCoordinates);
				this.bearing = "SE";
			}

			if ((currentCoordinates[1] == destinationCoordinates[1])
					&& (currentCoordinates[0] == destinationCoordinates[0])) {

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
	
	
	public void goNorthWest(int movingDistance, int[] currentCoordinates, int[] destinationCoordinates) {

		for (int i = 0; i < movingDistance; i++) {

			if (currentCoordinates[0] > 0 && currentCoordinates[1] > 0) {
				currentCoordinates[0] = currentCoordinates[0] - 1;
				currentCoordinates[1] = currentCoordinates[1] - 1;
				this.currentCoordinates = Functions.convertCoordToString(currentCoordinates);
				this.bearing = "NW";
			}

			if ((currentCoordinates[1] == destinationCoordinates[1])
					&& (currentCoordinates[0] == destinationCoordinates[0])) {

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
		
	public void goNorthEast(int movingDistance, int [] currentCoordinates,
			int[] destinationCoordinates) {

		for (int i = 0; i < movingDistance; i++) {

			if (currentCoordinates[0] > 0 && currentCoordinates[1] < 99) {
				currentCoordinates[0] = currentCoordinates[0] - 1;
				currentCoordinates[1] = currentCoordinates[1] + 1;
				this.currentCoordinates = Functions.convertCoordToString(currentCoordinates);
				this.bearing = "NE";
			}

			if ((currentCoordinates[1] == destinationCoordinates[1])
					&& (currentCoordinates[0] == destinationCoordinates[0])) {

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

	public void goSouthWest(int movingDistance, int[] currentCoordinates, int[] destinationCoordinates) {

		for (int i = 0; i < movingDistance; i++) {

			if (currentCoordinates[0] < 99 && currentCoordinates[1] > 0) {
				currentCoordinates[0] = currentCoordinates[0] + 1;
				currentCoordinates[1] = currentCoordinates[1] - 1;
				this.currentCoordinates = Functions.convertCoordToString(currentCoordinates);
				this.bearing = "SW";
			}

			if ((currentCoordinates[1] == destinationCoordinates[1])
					&& (currentCoordinates[0] == destinationCoordinates[0])) {

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
