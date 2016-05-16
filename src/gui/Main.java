package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public Main() {

	StarterFrame frame = new StarterFrame();

	// Center the window
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	Dimension frameSize = frame.getSize();
	if (frameSize.height > screenSize.height) {
		frameSize.height = screenSize.height;
	}
	if (frameSize.width > screenSize.width) {
		frameSize.width = screenSize.width;
	}
	frame.setLocation((screenSize.width - frameSize.width) / 2,
			  (screenSize.height - frameSize.height) / 2);

	frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException exception) {
                    exception.printStackTrace();
   		}
   		new Main();
            }
   	});
    }
}