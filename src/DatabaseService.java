import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseService implements IDatabaseService {

	private static Connection conn;

	private static Connection getConnection() {

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fleet", "root",
					ArmadaCongifReader.usingBufferedReader());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	@Override
	public void updateDatabase() {
	}

	@Override
	public ArrayList<Ship> readDatabase() {

		ArrayList<Ship> shipList = new ArrayList<Ship>();

		try {
			Statement myStmt = getConnection().createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from uvships");

			while (myRs.next()) {
				if (myRs.getString(6) == "Container") {

					Ship containerCargo = new Container();
					containerCargo.shipId = myRs.getInt(1);
					containerCargo.name = myRs.getString(2);
					containerCargo.MAX_CARGO_WEIGHT = myRs.getInt(3);
					containerCargo.maxSpeed = myRs.getInt(4);
					containerCargo.cruisingSpeed = myRs.getInt(5);
					containerCargo.cargo = myRs.getString(6);
					containerCargo.shipLogId = myRs.getInt(7);
					containerCargo.currentCoordinates = myRs.getString(8);
					containerCargo.destinationCoordinates = myRs.getString(9);
					containerCargo.startCoordinates = myRs.getString(10);
					containerCargo.currentSpeed = myRs.getInt(11);
					containerCargo.nauticMilage = myRs.getInt(12);
					containerCargo.bearing = myRs.getString(13);
					containerCargo.route = myRs.getString(14);
					shipList.add(containerCargo);
				} else {
					
					Ship oilCargo = new Oil();
					oilCargo.shipId = myRs.getInt(1);
					oilCargo.name = myRs.getString(2);
					oilCargo.MAX_CARGO_WEIGHT = myRs.getInt(3);
					oilCargo.maxSpeed = myRs.getInt(4);
					oilCargo.cruisingSpeed = myRs.getInt(5);
					oilCargo.cargo = myRs.getString(6);
					oilCargo.shipLogId = myRs.getInt(7);
					oilCargo.currentCoordinates = myRs.getString(8);
					oilCargo.destinationCoordinates = myRs.getString(9);
					oilCargo.startCoordinates = myRs.getString(10);
					oilCargo.currentSpeed = myRs.getInt(11);
					oilCargo.nauticMilage = myRs.getInt(12);
					oilCargo.bearing = myRs.getString(13);
					oilCargo.route = myRs.getString(14);
					shipList.add(oilCargo);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shipList;
	}

	@Override
	public void getShipPosition() {

		try {
			Statement myStmt = getConnection().createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from uvshipposition");
			System.out.println("Ship Name | Bearing | Current Coordinatets\n");
			while (myRs.next()) {
				System.out.println(myRs.getString("ShipName") + " | " + myRs.getString("Bearing") + " | "
						+ myRs.getString("CurrentCoordinates"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateCurrentCoordinatesAndBearing(int shipID, int shipLogID, String coordinates, String bearing) {
		try {
			Statement myStmt = getConnection().createStatement();
			myStmt.executeQuery(
					"call uspUpdateCurrentCoordinates(" + shipID + "," + shipLogID + ",'" + coordinates + ",'" + bearing
							+ "')");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateRouteDestionationStartCoordinates(int shipID, int shipLogID, String route, String destination,
			String start) {

		try {
			Statement myStmt = getConnection().createStatement();
			myStmt.executeQuery(
					"call uspUpdateRouteCoordinates(" + shipID + "," + shipLogID + ",'" + route + "','" + destination
							+ "', '" + start + "')");

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
}
