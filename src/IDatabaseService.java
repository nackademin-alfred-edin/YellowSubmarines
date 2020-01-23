import java.util.ArrayList;

public interface IDatabaseService {

	// CRUD

	// void createShip();

	void updateDatabase();

	ArrayList<Ship> readDatabase();
	

	void getShipPosition();

	// void deleteDatabase

	void updateCurrentCoordinatesAndBearingAndNauticalMilage(int shipID, int shipLogID, String coordinates,
			String bearing);

	void updateRouteDestionationStartCoordinates(int shipID, int shipLogID, String route, String destination,
			String start);

	void updateCurrentRoute(int shipID, int shipLogID, String currentRoute);
}
