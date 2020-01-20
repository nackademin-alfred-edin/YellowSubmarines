import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	public void readDatabase() {
		try {
			Statement myStmt = getConnection().createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from ship where ShipID =" + 1);

			while (myRs.next()) {

				System.out.println(myRs.getString(1));
				System.out.println(myRs.getString(2));
				System.out.println(myRs.getString(3));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
