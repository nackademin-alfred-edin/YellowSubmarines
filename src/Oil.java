
public class Oil extends Ship {


	public Oil() {

	}

	public Oil(int shipId, int shipLogId, String name, int maxSpeed, int cruisingSpeed, int currentSpeed,
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
		
		if (this.getCargoWeight() == 0) {
			System.out.println("Loading ship");
			this.setCargoWeight(this.getMAX_CARGO_WEIGHT());
		} else {
			System.out.println("Unloading ship");
			this.setCargoWeight(0);
		}
	}
}
