
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

	public abstract void unloadAndLoad();

}
