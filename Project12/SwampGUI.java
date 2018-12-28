import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SwampGUI
{	
	static int rows;
	static int cols;
	static String pathString;
	static String globalFile;
	static int[] dropInPt = new int[2];
	static int[][] swamp;
	JFrame window;
	Container content;
	JPanel boardPanel;
	JButton swampButton;
	JButton insertButton;
	JLabel swampTitle;
	JLabel pathTitle;
	JTextArea path;
	JTextArea swampBoard;
	JTextField swampInput;
	JPanel insertPanel;
	JPanel myPanel;
	public SwampGUI()
	{
		window = new JFrame("Carey's Swamp");
		content = window.getContentPane();
    	content.setLayout(new BorderLayout(10,10));
		ButtonListener listener = new ButtonListener();
		swampButton = new JButton("Click here to solve the swamp");
		swampButton.addActionListener(listener);
		path = new JTextArea("Path: ",1,4);
		path.setFont(new Font("Verdana", Font.BOLD, 12));
		insertButton = new JButton("Click here to insert the swamp");
		insertButton.addActionListener(listener);
		swampInput = new JTextField();
		swampInput.setFont(new Font("Verdana", Font.PLAIN, 12));
		swampInput.setText("input swamp board here");
		swampInput.setHorizontalAlignment(JTextField.CENTER);
		insertPanel = new JPanel();
		insertPanel.setLayout(new GridLayout(2,1));
		insertPanel.add(insertButton);
		insertPanel.add(swampInput);
		swampTitle = new JLabel("Carey's Swamp", SwingConstants.CENTER);
		swampTitle.setFont(new Font("Verdana", Font.BOLD, 12));
		boardPanel = new JPanel();
		boardPanel.setLayout(new GridBagLayout());
		myPanel = new JPanel();
		myPanel.setLayout(new BorderLayout(0,0));
		myPanel.add(swampTitle, BorderLayout.PAGE_START);
		myPanel.add(boardPanel, BorderLayout.CENTER);
		myPanel.add(path, BorderLayout.PAGE_END);
		content.add(swampButton, BorderLayout.LINE_END);
		content.add(insertPanel, BorderLayout.LINE_START);
		content.add(myPanel, BorderLayout.CENTER);
		window.setSize( 1000,480);
		window.setVisible( true );
	}
	public void swampInputer(String fileName) throws Exception
	{
		Scanner infile = new Scanner( new File(fileName) );
		globalFile = fileName;
        rows = infile.nextInt();
        cols = rows;
		dropInPt[0] = infile.nextInt(); 
		dropInPt[1] = infile.nextInt();
		String boardContents = "";
        for(int r = 0; r < rows ; r++)
		{
           for(int c = 0; c < cols; c++)
		   {
			   boardContents += infile.next() + ", ";
		   }
		   if(r < rows-1)
			   boardContents += "\n";
		}
		infile.close();
		swampBoard = new JTextArea(boardContents, rows, cols);
		swampBoard.setFont(new Font("verdana", Font.BOLD, 20));
		boardPanel.removeAll();
		boardPanel.revalidate();
		boardPanel.repaint();
		boardPanel.add(swampBoard);
		window.setVisible( true );
	}
	public void swampSolve(String fileName)
	{
		int[] dropInPt = new int[2];
		try
		{	
			swamp = loadSwamp( globalFile, dropInPt );
			int row=dropInPt[0], col = dropInPt[1];		
			pathString = "";
			depthFirstSearch( swamp, row, col, pathString );
		}
		catch(Exception e)
		{
			path.setText("Put a file in first");
			return;
		}
	}
	private static int[][] loadSwamp( String infileName, int[] dropInPt  ) throws Exception
	{
		
		Scanner keyboard = new Scanner(new File(infileName));
		int rows = keyboard.nextInt();
		int columns = rows;
		dropInPt[0] = keyboard.nextInt();
		dropInPt[1] = keyboard.nextInt();
		int[][] swamp = new int[rows][columns]; 
		for(int r = 0; r < rows ; r++)
		{
			 for(int c = 0; c < columns; c++)
			 {
			 	swamp[r][c] = keyboard.nextInt();
			 }
		}
		keyboard.close();
		return swamp;
	} // end loadSwamp

	public void depthFirstSearch( int[][] swamp, int r, int c, String pathString )
	{
		pathString += "["+r+","+c+"]";
		if(((r==0)||(r==swamp.length-1)) || ((c==0)||(c==swamp.length-1)))
		{
			path.append(pathString+"\n");
			return;
		}
		if(swamp[r-1][c] == 1)
		{
			swamp[r][c] = 0;
			depthFirstSearch(swamp, r-1, c, pathString);
			swamp[r-1][c] = 1;
		}
		if (swamp[r-1][c+1] == 1)
		{
			swamp[r][c] = 0;
			depthFirstSearch( swamp, r-1, c+1, pathString );
			swamp[r-1][c+1] = 1;
		}
		if (swamp[r][c+1] == 1)
		{
			swamp[r][c] = 0;
			depthFirstSearch( swamp, r, c+1, pathString );
			swamp[r][c+1] = 1;
		}
		if (swamp[r+1][c+1] == 1)
		{
			swamp[r][c] = 0;
			depthFirstSearch( swamp, r+1, c+1, pathString );
			swamp[r+1][c+1] = 1;
		}
		if (swamp[r+1][c] == 1)
		{
			swamp[r][c] = 0;
			depthFirstSearch( swamp, r+1, c, pathString );
			swamp[r+1][c] = 1;
		}
		if (swamp[r+1][c-1] == 1)
		{
			swamp[r][c] = 0;
			depthFirstSearch( swamp, r+1, c-1, pathString );
			swamp[r+1][c-1] = 1;
		}
		if (swamp[r][c-1] == 1)
		{
			swamp[r][c] = 0;
			depthFirstSearch( swamp, r, c-1, pathString );
			swamp[r][c-1] = 1;
		}
		if (swamp[r-1][c-1] == 1)
		{
			swamp[r][c] = 0;
			depthFirstSearch( swamp, r-1, c-1, pathString );
			swamp[r-1][c-1] = 1;
		}
	} // end DFS
	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Component whichButton = (Component) e.getSource();
			if (whichButton == insertButton)
			{
				try
				{
					swampInputer(swampInput.getText());
				}
				catch(Exception w)
				{
					swampInput.setText("Please re-enter filename");
				}
			}
			if (whichButton == swampButton)
			{
				path.setText("");
				swampSolve(swampInput.getText());
			}
		}
	}
	public static void main(String [] args)
	{
		new SwampGUI();
	}
}