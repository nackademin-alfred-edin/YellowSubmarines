import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FleetInfoGUI extends JFrame {

	private JLabel infoFleet;

	public FleetInfoGUI() {
		super("Fleet Info");
		setLayout(new GridLayout(20, 20));

		infoFleet = new JLabel();
		add(infoFleet);
	}

	public void setInfo(String info) {
		infoFleet.setText(info);
	}

}
