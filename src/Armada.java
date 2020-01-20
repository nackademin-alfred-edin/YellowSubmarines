import java.util.Scanner;

public class Armada {

	public static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {
		
<<<<<<< HEAD
		String ShipName;
		String Propulsion;
		String Carrying;
		String newName;
		double WeightInTons;
		String password = "Password!!!";

		int shipID;

		System.out.print("Name on boat: ");
		ShipName = myScanner.nextLine();
		System.out.print("Motor / Sail: ");
		Propulsion = myScanner.nextLine();
		System.out.print("People / Cargo: ");
		Carrying = myScanner.nextLine();
		System.out.print("Weight in tons: ");
		WeightInTons = myScanner.nextDouble();

		insertIntoDatabase(password, ShipName, Propulsion, Carrying, WeightInTons);

		System.out.print("Enter Ship ID: ");
		shipID = myScanner.nextInt();

		printSelectedRow(password, shipID);

		System.out.print("\nEnter Ship ID: ");
		shipID = myScanner.nextInt();

		newName = myScanner.nextLine();
		System.out.print("\nEnter new name: ");
		newName = myScanner.nextLine();

		updateShipName(password, shipID, newName);
		printSelectedRow(password, shipID);

		myScanner.close();
=======
		IDatabaseService db = new DatabaseService();
		db.readDatabase();
>>>>>>> develop
	}
<<<<<<< HEAD

	public static void updateShipName(String password, int shipID, String newName) {

		try {
<<<<<<< HEAD

			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fleet?serverTimezone=UTC",
					"root", password);
=======
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fleet?serverTimezone=UTC",
					"root", ArmadaCongifReader.usingBufferedReader());
>>>>>>> develop

			Statement myStmt = myConn.createStatement();
			String myQuerry = "update ship set ShipName='" + newName + "' where ShipID = " + shipID;
			String updString = "update comments set MYUSER='Olle' where id=4";
			myStmt.executeUpdate(myQuerry);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public static void printSelectedRow(String password, int shipID) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fleet?serverTimezone=UTC",
<<<<<<< HEAD
					"root", password);

=======
					"root", ArmadaCongifReader.usingBufferedReader());
>>>>>>> develop

			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("Select * from ship where ShipID =" + shipID);


			while (myRs.next()) {

				System.out.println(myRs.getString("ShipID"));
				System.out.println(myRs.getString("ShipName"));
				System.out.println(myRs.getString("Propulsion"));
				System.out.println(myRs.getString("Carrying"));
				System.out.println(myRs.getString("WeightInTons"));
				System.out.println();
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void insertIntoDatabase(String password, String ShipName, String Propulsion, String Carrying,
			double WeightInTons) {
		try {
<<<<<<< HEAD
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fleet?serverTimezone=UTC",
					"root", password);
=======
>>>>>>> develop

			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fleet?serverTimezone=UTC",
					"root", ArmadaCongifReader.usingBufferedReader());
			
			String query = " insert into ship (ShipName, Propulsion, Carrying, WeightInTons)"
					+ " values (?, ?, ?, ?)";

			PreparedStatement preparedStmt = myConn.prepareStatement(query);
			preparedStmt.setString(1, ShipName);
			preparedStmt.setString(2, Propulsion);
			preparedStmt.setString(3, Carrying);
			preparedStmt.setDouble(4, WeightInTons);

			preparedStmt.execute();
			myConn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
	}

=======
>>>>>>> e9b9ea95e146ad3c4c260f854c89cf65678128c4
}

//		String ShipName;
//		String Propulsion;
//		String Carrying;
//		String newName;
//		double WeightInTons;
//
//		int shipID;
//
//		System.out.print("Name on boat: ");
//		ShipName = myScanner.nextLine();
//		System.out.print("Motor / Sail: ");
//		Propulsion = myScanner.nextLine();
//		System.out.print("People / Cargo: ");
//		Carrying = myScanner.nextLine();
//		System.out.print("Weight in tons: ");
//		WeightInTons = myScanner.nextDouble();
//
//		// insertIntoDatabase(ShipName, Propulsion, Carrying, WeightInTons);
//
//		System.out.print("Enter Ship ID: ");
//		shipID = myScanner.nextInt();
//
//		printSelectedRow(shipID);
//
//		System.out.print("\nEnter Ship ID: ");
//		shipID = myScanner.nextInt();
//
//		newName = myScanner.nextLine();
//		System.out.print("\nEnter new name: ");
//		newName = myScanner.nextLine();
//
//		updateShipName(shipID, newName);
//		printSelectedRow(shipID);
//
//		myScanner.close();
//	}
//
//	public static void updateShipName(int shipID, String newName) {
//
//		try {
//			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fleet", "root",
//					ArmadaCongifReader.usingBufferedReader());
//
//			Statement myStmt = myConn.createStatement();
//			String myQuerry = "update ship set ShipName='" + newName + "' where ShipID = " + shipID;
//			String updString = "update comments set MYUSER='Olle' where id=4";
//			myStmt.executeUpdate(myQuerry);
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//
//	public static void printSelectedRow(int shipID) {
//
//		try {
//			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fleet", "root",
//					ArmadaCongifReader.usingBufferedReader());
//
//			Statement myStmt = myConn.createStatement();
//			ResultSet myRs = myStmt.executeQuery("select * from ship where ShipID =" + shipID);
//
//
//			while (myRs.next()) {
//
//				System.out.println(myRs.getString(1));
//				System.out.println(myRs.getString(2));
//				System.out.println(myRs.getString(3));
//
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void insertIntoDatabase(String ShipName, String Propulsion, String Carrying, double WeightInTons) {
//		try {
//			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fleet", "root",
//					ArmadaCongifReader.usingBufferedReader());
//
//			String query = " insert into ship (ShipName, Propulsion, Carrying, WeightInTons)"
//					+ " values (?, ?, ?, ?)";
//
//			PreparedStatement preparedStmt = myConn.prepareStatement(query);
//			preparedStmt.setString(1, ShipName);
//			preparedStmt.setString(2, Propulsion);
//			preparedStmt.setString(3, Carrying);
//			preparedStmt.setDouble(4, WeightInTons);
//
//			preparedStmt.execute();
//			myConn.close();
//
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//
//			e.printStackTrace();
//		}
//	}
//
//}
