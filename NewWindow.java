import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
 
//create class and extend with JFrame
public class NewWindow extends JFrame 
{
	//declare variable
	private JPanel contentPane;

	public NewWindow() //constructor
	{
		//set frame title
		setTitle("New Frame");
		//set default close operation
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//set bounds of the frame
		setBounds(100, 100, 450, 300);
		
		//create object of JPanel
		contentPane = new JPanel();
		//set border
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//set ContentPane
		setContentPane(contentPane);
		//set null
		contentPane.setLayout(null);
		
		//label in the frame
		JLabel lblWelcome = new JLabel("Welcome this is New Frame");
		//set fore ground color to the label
		lblWelcome.setForeground(Color.RED);
		//set font to the label
	lblWelcome.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		//set bounds of the label
		lblWelcome.setBounds(75, 100, 294, 32);
		//add label to the contentPane 
		contentPane.add(lblWelcome);
	}
}