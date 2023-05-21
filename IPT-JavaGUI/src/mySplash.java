import javax.swing.*;
import java.awt.*;

public class mySplash extends JWindow {

	public mySplash() {
		JLabel label = new JLabel(new ImageIcon("src/Splash.png"));
		getContentPane().add(label, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		dispose();
	}
}