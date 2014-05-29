import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel text1;

	public GUI() {
		super("Hello.");
		setLayout(new FlowLayout());
		
		text1 = new JLabel("Sentence");
		text1.setToolTipText("Magic");
		add(text1);
	
	}
	public static void main(String[]  args){
	    ImageIcon icon = new ImageIcon ("wall.png");
	    Image image = icon.getImage(); // transform it 
	    Image newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	    icon = new ImageIcon(newimg);  // transform it back

	    JPanel grid = new JPanel();
	    grid.setLayout(new GridLayout(10, 10));
	    for (int i = 0; i < 10; i++) {
	        for (int n = 0; n < 10; n++) {
	            grid.add(new JLabel(icon));
	        }	
	    }
	    JFrame frame = new JFrame("Map");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //frame.setPreferredSize(new Dimension(640, 400));
	    frame.add(grid);
	    frame.pack();
	    frame.setVisible(true);

	    
		/*GUI Frame = new GUI();
		Frame.setSize(300,400);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.setVisible(true);*/
	
	
	}
}
