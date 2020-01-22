import java.util.ArrayList;

public interface IDatabaseService {

	// CRUD

	// void createShip();

	void updateDatabase();

	ArrayList<Ship> readDatabase();
	

	void getShipPosition();

	// void deleteDatabase

	void updateCurrentCoordinate(int shipID, int shipLogID, String coordinates);

}
