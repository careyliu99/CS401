// Demonstrates JPanel, GridLayout and a few additional useful graphical features.
// adapted from an example by john ramirez (cs prof univ pgh)
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*; // needed for ArrayList etc.
import java.io.*;

public class SimpleCalc
{
	JFrame window;  // the main window which contains everything
	Container content ;
	JButton[] digits = new JButton[12]; 
	JButton[] ops = new JButton[4];
	JTextField expression;
	JButton equals;
	JTextField result;
	
	public SimpleCalc()
	{
		window = new JFrame( "Simple Calc");
		content = window.getContentPane();
		content.setLayout(new GridLayout(2,1));
		ButtonListener listener = new ButtonListener();
		
		// top panel holds expression field, equals sign and result field  
		// [4+3/2-(5/3.5)+3]  =   [3.456]
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(1,3));
		
		expression = new JTextField();
		expression.setFont(new Font("verdana", Font.BOLD, 16));
		expression.setText("");
		
		equals = new JButton("=");
		equals.setFont(new Font("verdana", Font.BOLD, 20 ));
		equals.addActionListener( listener ); 
		
		result = new JTextField();
		result.setFont(new Font("verdana", Font.BOLD, 16));
		result.setText("");
		
		topPanel.add(expression);
		topPanel.add(equals);
		topPanel.add(result);
						
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(1,2));
	
		JPanel  digitsPanel = new JPanel();
		digitsPanel.setLayout(new GridLayout(4,3));	
		
		for (int i=0 ; i<10 ; i++ )
		{
			digits[i] = new JButton( ""+i );
			digitsPanel.add( digits[i] );
			digits[i].addActionListener( listener ); 
		}
		digits[10] = new JButton( "C" );
		digitsPanel.add( digits[10] );
		digits[10].addActionListener( listener ); 

		digits[11] = new JButton( "CE" );
		digitsPanel.add( digits[11] );
		digits[11].addActionListener( listener ); 		
	
		JPanel opsPanel = new JPanel();
		opsPanel.setLayout(new GridLayout(4,1));
		String[] opCodes = { "+", "-", "*", "/" };
		for (int i=0 ; i<4 ; i++ )
		{
			ops[i] = new JButton( opCodes[i] );
			opsPanel.add( ops[i] );
			ops[i].addActionListener( listener ); 
		}
		bottomPanel.add( digitsPanel );
		bottomPanel.add( opsPanel );
		
		content.add( topPanel );
		content.add( bottomPanel );
	
		window.setSize( 640,480);
		window.setVisible( true );
	}
	
	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Component whichButton = (Component) e.getSource();
			
			for (int i=0; i<10 ; i++ )
				if (whichButton == digits[i])
					expression.setText( expression.getText() + i ); 
			String[] operators = {"+", "-", "*", "/"};
			for (int i=0; i < 4; i++)
			{
				if (whichButton == ops[i])
				{
					expression.setText(expression.getText() + operators[i]); 
				}
			} // end for

			if(whichButton == digits[10])
			{
				expression.setText(null); // for loop above tests to see if i<10
			}
			
			if (whichButton == digits[11]) // CE button
			{
				expression.setText(expression.getText().substring(0 , expression.getText().length() - 1));

			}
			if (whichButton == equals)
			{ 	// tokenizer
				String expr = expression.getText();
				//System.out.println( "expr: " + expr );
				ArrayList<String> operatorList = new ArrayList<String>();
				ArrayList<String> operandList = new ArrayList<String>();
				StringTokenizer st = new StringTokenizer( expr,"+-*/", true );
				while (st.hasMoreTokens())
				{
					String token = st.nextToken();
					if ("+-/*".contains(token))
					{
						operatorList.add(token);
					}
					else
					{
						operandList.add(token);
					}
				} // end while

				//PUT EVERYTHING HERE

				//String abd="asdasda";
				//result.setText(abd);
				
				ArrayList<Double> opArray = new ArrayList<Double>();
				int count = 0;
				int opPrecedence = 0;
				for(int j = 0; j < operandList.size(); j++)
				{
					opArray.add(Double.parseDouble(operandList.get(j)));
				}
		
				for(int j = 0; j < operatorList.size(); j++)
				{
					if(operatorList.get(j).equals("/") || operatorList.get(j).equals("*"))
					{
						opPrecedence++;
					}
				}
				int i = 0;
				while (operatorList.contains("/") || operatorList.contains("*"))
				{
					int subtract=0;
					if ( operatorList.size()!=0 && operatorList.get(i).equals("/"))
					{
						double result = opArray.get(i)/opArray.get(i+1); // double instead of int for exact answers
						opArray.set(i, result);
						opArray.remove(i+1);
						operatorList.remove(i);
						subtract++;
					}
					if(!operatorList.contains("/") && !operatorList.contains("*"))
							break;
					if (operatorList.size()!=0 && operatorList.get(i).equals("*"))
					{
						double result = opArray.get(i)*opArray.get(i+1);
						opArray.set(i, result);
						opArray.remove(i+1);
						operatorList.remove(i);
						subtract++;
					}
					i++;
					i-=subtract;

				} // end while loop

				i = 0;
				
				while (operatorList.size()>0)
				{
					int adjust=0;
					if(operatorList.size()!=0 && operatorList.get(i).equals("+"))
					{
						double result = opArray.get(i)+opArray.get(i+1);
						opArray.set(i, result);
						opArray.remove(i+1);
						operatorList.remove(i);
						adjust++;
					}
					if(operatorList.size()==0)
							break;
					if(operatorList.size()!=0 && operatorList.get(i).equals("-"))
					{
						double result = opArray.get(i)-opArray.get(i+1);
						opArray.set(i, result);
						opArray.remove(i+1);
						operatorList.remove(i);
						adjust++;
					}
					i++;
					i-=adjust;
				} // end while loop
				result.setText(Double.toString(opArray.get(0)));
			} // end if	
			/*if (operatorList.size()!= 0 && operandList.size() != 1)
			{
				expression.setText("INVALID EXPRESSION");
			}*/
			

		}
	} // end class 

	public static void main(String [] args)
	{
		new SimpleCalc();
	}
}

