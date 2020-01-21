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
				Cargo cargo = new Cargo();
				cargo.shipId = myRs.getInt(1);
				cargo.name = myRs.getString(2);
				cargo.maxSpeed = myRs.getInt(3);
				cargo.cruisingSpeed = myRs.getInt(4);
				cargo.cargo = myRs.getString(5);
				cargo.shipLogId = myRs.getInt(6);
				cargo.typeOfCargo = myRs.getString(7);
				cargo.cargoWeight = myRs.getInt(8);
				cargo.currentCoordinates = myRs.getString(9);
				cargo.destinationCoordinates = myRs.getString(10);
				cargo.startCoordinates = myRs.getString(11);
				cargo.currentSpeed = myRs.getInt(12);
				cargo.natuticMilage = myRs.getInt(13);
				cargo.bearing = myRs.getString(14);

				shipList.add(cargo);

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
				System.out.println(myRs.getString(1) + " | " + myRs.getString(2) + " | " + myRs.getString(2));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
