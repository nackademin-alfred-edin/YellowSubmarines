
public class Cargo extends Ship {

	public String typeOfCargo;
	public int cargoWeight;

	public Cargo(int shipId, int shipLogId, String name, int maxSpeed, int cruisingSpeed, int currentSpeed,
			String bearing, String cargo, String currentCoordinates, String startCoordinates,
			String destinationCoordinates, String[] route, int natuticMilage, boolean docked) {
		super(shipId, shipLogId, name, maxSpeed, cruisingSpeed, currentSpeed, bearing, cargo, currentCoordinates,
				startCoordinates, destinationCoordinates, route, natuticMilage, docked);
	}

	public Cargo() {

	}

	public void loadCargo() {

	}

	public void unloadCargo() {

	}

	@Override
	public void dock() {
		System.out.println("docking..");

	}

	@Override
	public void undock() {
		System.out.println("undocking");

	}

	@Override
	public void moveShip() {
		// TODO Auto-generated method stub

	}

}
