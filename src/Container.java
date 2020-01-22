
public class Container extends Ship {


	public Container() {

	}

	public Container(int shipId, int shipLogId, String name, int maxSpeed, int cruisingSpeed, int currentSpeed,
			String bearing, String cargo, String currentCoordinates, String startCoordinates,
			String destinationCoordinates, String route, int nauticMilage, boolean docked,
			int MAX_CARGO_WEIGHT, int cargoWeight) {
		super(shipId, shipLogId, name, maxSpeed, cruisingSpeed, currentSpeed, bearing, cargo, currentCoordinates,
				startCoordinates, destinationCoordinates, route, nauticMilage, docked, MAX_CARGO_WEIGHT,
				cargoWeight);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void unloadAndLoad() {
		System.out.println("Unloading containers...");
		this.cargoWeight = 0;
		System.out.println("Loading containers...");
		this.cargoWeight = this.MAX_CARGO_WEIGHT;

	}

}
