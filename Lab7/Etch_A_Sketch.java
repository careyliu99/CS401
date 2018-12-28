import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Etch_A_Sketch implements MouseListener, MouseMotionListener, ActionListener  // NOTE multiple interfaces
{
	JFrame window;
	Container contentPane;
	int mouseX,mouseY,oldX,oldY;
	JButton colorChanger;
	Color currDrawingColor = Color.BLACK; // ADD A BUTTON THAT WHEN CLICKED, CHANGES THE CURR COLOR
	Color[] myColors = {Color.BLACK, Color.BLUE, Color.LIGHT_GRAY, Color.CYAN}; // my 4 colors
	int index = 0; // starts at index 0, which is color black

	public Etch_A_Sketch()
	{
		JFrame window = new JFrame("Classic Etch a Sketch");
		contentPane = window.getContentPane();
		contentPane.setLayout( new FlowLayout() );
		colorChanger = new JButton("Click to change line color.");
		colorChanger.setFont(new Font("TimesRoman", Font.ITALIC + Font.BOLD, 32));
		colorChanger.addActionListener(this); 
		contentPane.add(colorChanger); 
		contentPane.addMouseListener(this);        // "this" is the class that implements that listener
		contentPane.addMouseMotionListener(this);  // "this" is the class that implements that listener
		window.setSize(640,480);
		window.setVisible(true);
		

	}
	// ..............................................................
	// IMPLEMENTING MOUSELISTENER REQUIRES YOU TO WRITE (OVER-RIDE) THESE METHODS 

	//when you press & release with NO MOVEMENT while pressed
	public void mouseClicked( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		
	}
	
	// when you press 
	public void mousePressed( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();

		//repaint();
	}

	//when you let release after dragging
	public void mouseReleased( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		//repaint();
	}

	// the mouse just moved off of the JFrame
	public void mouseExited( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		//repaint();
	}
	
	// the mouse just moved onto the JFrame
	public void mouseEntered( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		//repaint();
	}
	// ...............................................................
	// IMPLEMENTING MOUSEMOTIONLISTENER REQUIRES YOU WRITE (OVER-RIDE) THESE METHODS 

	// mouse is moving while pressed
	public void mouseDragged( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		if (oldX ==0 )
		{
			oldX=mouseX;
			oldY=mouseY;
			return;
		}
		
		// draw  dot (actually small line segment) between old (x,y) and current (x,y)
		Graphics g = contentPane.getGraphics(); // use g to draw onto the pane
		g.setColor( currDrawingColor );
		g.drawLine( oldX,oldY, mouseX, mouseY );
		oldX = mouseX;
		oldY = mouseY;
		
		//repaint();
	}
	
	// moved mouse but not pressed
	public void mouseMoved( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		
		//repaint();
	}
	public void actionPerformed(ActionEvent e) // do the actual changing of colors in this method
	{
		Component buttonClicked = (Component) e.getSource();
		if (buttonClicked == colorChanger) // looks to see if the right button was clicked
		{
			index++;
			index = index % myColors.length; // simple way to make sure you're within the bounds of the array 4%4=0
			currDrawingColor = myColors[index];
		}	
	}

	// ..............................................................

	public static void main( String[] args)
	{
		new Etch_A_Sketch();
	
	}
	// a helper utility
	
}//EOF