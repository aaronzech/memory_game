import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.*;

public class Display extends JFrame implements ActionListener
{
	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	JFrame frame = new JFrame("Memory Game");
	JPanel panel = new JPanel(new GridLayout(2,2));
	JPanel mainPanel = new JPanel(new BorderLayout());
	JPanel topPanel = new JPanel(new GridLayout(1,2));
	JLabel scoreLabel = new JLabel("Score: 0");
	JLabel tryLabel = new JLabel("Tries: 0");
	
	private JMenuItem item1 = new JMenuItem("Reset");
	
	// Button Images
	ImageIcon cardBack = new ImageIcon(this.getClass().getResource("/cardBack.png")); // Back 
	ImageIcon matched = new ImageIcon(this.getClass().getResource("/matched.jpg")); // Back 
	
	 //Buttons
    JButton button = new JButton("1",cardBack);
    JButton button1 = new JButton("2",cardBack);
    JButton button2 = new JButton("3",cardBack);
    JButton button3 = new JButton("4",cardBack);
    JButton button4 = new JButton("5",cardBack);
    JButton button5 = new JButton("6",cardBack);
    JButton button6 = new JButton("7",cardBack);
    JButton button7 = new JButton("8",cardBack);
 
    
    //Popup Window

    
    // Button List
    ArrayList<JButton> buttonList = new ArrayList<JButton>();
    // CardList
    ArrayList<Card> cardList = new ArrayList<Card>();
    
    //matching strings
    String m1= "Dog";
    String m2= "Frog";
    String m3= "Bat";
    String m4= "Cat";
    
    //cards
    Card card = new Card(m1);
    Card card1 = new Card(m1);
    Card card2 = new Card(m2);
    Card card3 = new Card(m2);
    Card card4 = new Card(m3);
    Card card5 = new Card(m3);
    Card card6 = new Card(m4);
    Card card7 = new Card(m4);
    
    String guess1 = null;
	String guess2=null;
	int count = 0;
	int score = 0;
	int tries = 0;
	
	JButton firstGuess=null, secondGuess=null;
	boolean thirdGuess=false;
	
	public Display()
	{
		super("Memory Game");
		super.setSize(WIDTH,HEIGHT);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLayout(new GridLayout(1,1));
		
		// Building Functions
		addComponents();
		addListeners();
	}

// Add Button Listeners
public void addListeners()
{
	// Listener
	button.addActionListener(this);
	button1.addActionListener(this);
	button2.addActionListener(this);
	button3.addActionListener(this);
	button4.addActionListener(this);
	button5.addActionListener(this);
	button6.addActionListener(this);
	button7.addActionListener(this);
	item1.addActionListener(this);
}
     
// Add GUI components
public void addComponents()
{
	// Menu Bar items
	JMenuBar menubar = new JMenuBar();
	JMenu menu1 = new JMenu ("File");
	menubar.add(menu1);
	super.setJMenuBar(menubar);
	menu1.add(item1);
	
	
	
	//panel.add(label);
	  // Random Number picker 1-6
    Random diceRoller = new Random();
    int roll = diceRoller.nextInt(6) + 1;

	// Add to Panel
    // Shuffle the panel to change order of things. 
    // This is not ideal but works
    if(roll<=3)
    {
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button); 
    }
    else if(roll==4)
    {
    	 panel.add(button7);
    	 panel.add(button);
    	 panel.add(button5);
    	 panel.add(button3);
    	 panel.add(button4);
    	 panel.add(button2);
    	 panel.add(button6);
    	 panel.add(button1);
    }
    else 
    {
        panel.add(button4);
        panel.add(button2);
        panel.add(button);
        panel.add(button3);
        panel.add(button1);
        panel.add(button5);
        panel.add(button7);
        panel.add(button6);  
    }

    // Add to list
    buttonList.add(button);
    buttonList.add(button1);
    buttonList.add(button2);
    buttonList.add(button3);
    buttonList.add(button4);
    buttonList.add(button5);
    buttonList.add(button6);
    buttonList.add(button7);
   
    // Add cards
    cardList.add(card);
    cardList.add(card1);
    cardList.add(card2);
    cardList.add(card3);
    cardList.add(card4);
    cardList.add(card5);
    cardList.add(card6);
    cardList.add(card7);
    
    //Top BPanel
    topPanel.add(scoreLabel);
    topPanel.add(tryLabel);
    
    mainPanel.add(topPanel, BorderLayout.NORTH);
   // mainPanel.add(label, BorderLayout.NORTH);
    mainPanel.add(panel, BorderLayout.CENTER);
    // Add to Frame
    add(mainPanel);
    // Set button text
    setText();
    
    }

// Button Actions
public void actionPerformed(ActionEvent e) 
{
	// Gets the type of object that was click. IE a button or a menu item
	Object source = e.getSource();
	
	// If the object that was clicked was a button do this
	if(source instanceof JButton)
	{
		flipCard((JButton) e.getSource());
		wasMatched((JButton) e.getSource());
	}
	// If the object that was clicked wasn't a button do this
	else
	{
		reset();
	}
}

public JButton flipCard(JButton b) 
{
	b.setIcon(null);
	if(b.equals(button))
	{
		// Show card
		button.setText(card.cardValue);
	}
	else if (b.equals(button1))
	{
		// Show card
		button1.setText(card1.cardValue);
	}
	else if (b.equals(button2))
	{
		// Show card
		button2.setText(card2.cardValue);
	}
		
	else if (b.equals(button3))
	{
		// Show card
		button3.setText(card3.cardValue);
	}
	else if (b.equals(button4))
	{
		// show card
		button4.setText(card4.cardValue);
	}
	else if (b.equals(button5))
	{
		// show card
		button5.setText(card5.cardValue);
	}
	else if (b.equals(button6))
	{
		// show card
		button6.setText(card6.cardValue);
	}
	else if (b.equals(button7))
	{
		// show card
		button7.setText(card7.cardValue);
	}
	return b;
}

public void wasMatched(JButton b)
{
	
	// FIRST Guess
	if(count==0)
	{
		firstGuess = b;
		guess1 = firstGuess.getText();
		System.out.println("Guess 1 = " + guess1);
		
		count++;
		tries++;
		tryLabel.setText("Tries: " + tries);
		
		
		// hide second guess if first one is different
		if (thirdGuess==true)
		{
			secondGuess.setIcon(cardBack); // helps not fully
			thirdGuess=false;
		
		}
	}
	
	// Second Guess
	if(count==1)
	{
	
		// Second Guess and button is different then the first one
		if(b!=firstGuess)
		{
			secondGuess=b;
			
			guess2 = secondGuess.getText();
			System.out.println("Guess 2 = "  + guess2);
			
			// Match Found
			if(guess1.equals(guess2))
			{
				b.setIcon(cardBack);
				firstGuess.setIcon(cardBack);
				secondGuess.setIcon(cardBack);
				
				b.setEnabled(false);
				
				firstGuess.setEnabled(false);
				count++;
				
				// Card Text
				b.setText("");
				
				score++;
				scoreLabel.setText("Score: " + score);
				
				if(score==4)
				{
					JOptionPane.showMessageDialog(null, "Winner \n Press reset to play again");
					saveScore();
				}
			}
			else count++;
		}
	}
	
	// second guess didn't match the first reset guesses
	if(count==2)
	{
		firstGuess.setIcon(cardBack); // helps fix the issue
		
		firstGuess=null;
		//secondGuess=null;
		count = 0;
		thirdGuess=true;
	}	
}

// Sets the cardBack image
public void flipCardsBack()
{
	for(JButton i : buttonList)
	{
		i.setIcon(cardBack);
	}
}

// Puts the revealed text on the cards
public void setText()
{
	//shuttle list
	Collections.shuffle(cardList);
	for(Card i:cardList)
	{
		System.out.println(i.cardValue);
	}
	
	for(Card i : cardList)
	{

		// Set Card Text
		for(JButton j: buttonList)
		{
			j.setText("");
			
		}
		
	}
}

// Menu button reset
public void reset()
{
	for(JButton j: buttonList)
	{
		// Enables buttons
		j.setEnabled(true);
		// Changes card image
		j.setIcon(cardBack);
		// Sets text to blank
		j.setText("");
		
	}
	shuffleCards();
	score = 0;
	scoreLabel.setText("Score: 0");
	tries = 0;
	tryLabel.setText("Tries: 0");
	
	
	EventQueue.invokeLater(new Runnable()
	{
		public void run()
		{
			//try - catch block
			try 
			{
				//Create object of NewWindow
				NewWindow frame1 = new NewWindow();
				//set frame visible true
				//frame1.setVisible(true);
				
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	});
	


}
	
public void shuffleCards() // Shuffles the order of the matched cards
{
	  // Random Number picker 1-6
    Random diceRoller = new Random();
    int roll = diceRoller.nextInt(6) + 1;
	
    if(roll==1)
    {
    	card.setRevealed(m2);
		card1.setRevealed(m2);
		card2.setRevealed(m1);
		card3.setRevealed(m1);
		card4.setRevealed(m4);
		card5.setRevealed(m4);
		card6.setRevealed(m3);
		card7.setRevealed(m3);
    }
    if(roll==2)
    {
    	card.setRevealed(m4);
		card1.setRevealed(m2);
		card2.setRevealed(m3);
		card3.setRevealed(m1);
		card4.setRevealed(m2);
		card5.setRevealed(m1);
		card6.setRevealed(m4);
		card7.setRevealed(m3);
    }
    if(roll==3)
    {
    	card.setRevealed(m1);
		card1.setRevealed(m1);
		card2.setRevealed(m3);
		card3.setRevealed(m4);
		card4.setRevealed(m3);
		card5.setRevealed(m2);
		card6.setRevealed(m2);
		card7.setRevealed(m4);
    }    
    if(roll==4)
    {
    	card.setRevealed(m4);
		card1.setRevealed(m2);
		card2.setRevealed(m1);
		card3.setRevealed(m1);
		card4.setRevealed(m3);
		card5.setRevealed(m4);
		card6.setRevealed(m3);
		card7.setRevealed(m2);
    }
    if(roll==5)
    {
    	card.setRevealed(m3);
		card1.setRevealed(m3);
		card2.setRevealed(m1);
		card3.setRevealed(m1);
		card4.setRevealed(m1);
		card5.setRevealed(m4);
		card6.setRevealed(m4);
		card7.setRevealed(m2);
    }
    if(roll==6)
    {
    	card.setRevealed(m2);
		card1.setRevealed(m4);
		card2.setRevealed(m3);
		card3.setRevealed(m2);
		card4.setRevealed(m1);
		card5.setRevealed(m1);
		card6.setRevealed(m4);
		card7.setRevealed(m3);
    }    
}
	

public void saveScore()
{
	File log = new File("highScores.txt");

			try{
			    if(!log.exists()){
			        System.out.println("We had to make a new file.");
			        log.createNewFile();
			    }

			    FileWriter fileWriter = new FileWriter(log, true);
			    
			    
			    // Get Current Time
			    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			    
			    // Write data to file
			    bufferedWriter.write("Score: "+ score + " , "+ timestamp);
			    bufferedWriter.newLine();
			    bufferedWriter.close();

			    System.out.println("Done");
			} catch(IOException e) {
			    System.out.println("COULD NOT LOG!!");
			}
}
}




