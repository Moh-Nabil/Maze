import java.awt.*;

public class GUI extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GUI () {
		setLayout(new FlowLayout());
	    setTitle("Maze");  // "super" Frame sets title
	    setSize(500, 500);        // "super" Frame sets initial window size
	    setVisible(true);         // "super" Frame shows
	    
	    Label lbl = new Label("el3ab ya 7amada");
	    lbl.setFont(new Font("Lucida",Font.PLAIN,24));
	    add(lbl);
	    
	}
	public static void main(String[] args) {
		new GUI();
	}
}
