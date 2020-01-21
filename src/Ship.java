
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
	public String[] route;
	public int natuticMilage;
	public boolean docked;

	public Ship() {
	}

	public Ship(int shipId, int shipLogId, String name, int maxSpeed, int cruisingSpeed, int currentSpeed,
			String bearing,
			String cargo,
			String currentCoordinates, String startCoordinates, String destinationCoordinates, String[] route,
			int natuticMilage,
			boolean docked) {
		super();
		this.shipId = shipId;
		this.shipLogId = shipLogId;
		this.name = name;
		this.maxSpeed = maxSpeed;
		this.cruisingSpeed = cruisingSpeed;
		this.currentSpeed = currentSpeed;
		this.bearing = bearing;
		this.currentCoordinates = currentCoordinates;
		this.startCoordinates = startCoordinates;
		this.destinationCoordinates = destinationCoordinates;
		this.route = route;
		this.natuticMilage = natuticMilage;
		this.docked = docked;
		this.cargo = cargo;
	}
	public abstract void dock();
	public abstract void undock();
	public abstract void moveShip();
}
