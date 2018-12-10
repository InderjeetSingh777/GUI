import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.util.*;
import java.awt.event.*; 
class Topping extends JPanel  implements ItemListener
{
	public ArrayList<String> selection;
	Topping()
	{
		selection=new ArrayList<String>();
		Border border = BorderFactory.createLineBorder(Color.RED, 2);
		setBorder(border);
		GridBagLayout layout=new GridBagLayout(); 
		setLayout(layout);
		Box verticalBox = Box.createVerticalBox();
		setPreferredSize(new Dimension(600,450));
		add(verticalBox);
		JLabel heading=new JLabel("Each Topping : $ 1.50",JLabel.CENTER);
		heading.setForeground(Color.RED);
		heading.setFont(new Font("Serif", Font.BOLD, 30));
		verticalBox.add(heading);
		JCheckBox box1=new JCheckBox("Tomato");
		box1.setFont(new Font("Serif", Font.BOLD, 30));
		verticalBox.add(box1);
		box1.addItemListener(this);
		JCheckBox box2=new JCheckBox("GreenPepper");
		box2.setFont(new Font("Serif", Font.BOLD, 30));
		verticalBox.add(box2);
		box2.addItemListener(this);
		JCheckBox box3=new JCheckBox("Black Olives");
		box3.setFont(new Font("Serif", Font.BOLD, 30));
		verticalBox.add(box3);
		box3.addItemListener(this);
		JCheckBox box4=new JCheckBox("Mushrooms");
		box4.setFont(new Font("Serif", Font.BOLD, 30));
		verticalBox.add(box4);
		box4.addItemListener(this);
		JCheckBox box5=new JCheckBox("Extra Cheese");
		box5.setFont(new Font("Serif", Font.BOLD, 30));
		verticalBox.add(box5);
		box5.addItemListener(this);
		JCheckBox box6=new JCheckBox("Pepproni");
		box6.setFont(new Font("Serif", Font.BOLD, 30));
		verticalBox.add(box6);
		box6.addItemListener(this);
		JCheckBox box7=new JCheckBox("Sausage");
		box7.setFont(new Font("Serif", Font.BOLD, 30));
		verticalBox.add(box7);
		box7.addItemListener(this);
	}
	public void itemStateChanged(ItemEvent e)
	{
		JCheckBox box=(JCheckBox)e.getItem();
		if(box.isSelected())
			selection.add(box.getActionCommand());
		else if(!box.isSelected()&& selection.contains(box.getActionCommand()))
			selection.remove(box.getActionCommand());
		Iterator itr= selection.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}
} 
class Feature extends JPanel implements ItemListener
{
	String data="";
	 Feature(String []Data)
	{
		
		Border border = BorderFactory.createLineBorder(Color.RED, 3);
		Border margin = new EmptyBorder(30,30,30,30);
		setBorder(new CompoundBorder(border, margin));
		Box verticalBox = Box.createVerticalBox();
		setPreferredSize(new Dimension(400,300));
		add(verticalBox);
		JLabel heading=new JLabel(Data[0],JLabel.CENTER);
		heading.setForeground(Color.RED);
		heading.setFont(new Font("Serif", Font.BOLD, 30));
		verticalBox.add(heading);
		JRadioButton jb1=new JRadioButton(Data[1]);
		jb1.setFont(new Font("Serif", Font.BOLD, 30));
		jb1.addItemListener(this);
        verticalBox.add(jb1);
		JRadioButton jb2=new JRadioButton(Data[2]);
		jb2.setFont(new Font("Serif", Font.BOLD, 30));
		jb2.addItemListener(this);
		verticalBox.add(jb2);
		JRadioButton jb3=new JRadioButton(Data[3]);
		jb3.setFont(new Font("Serif", Font.BOLD, 30));
		verticalBox.add(jb3);
		jb3.addItemListener(this);
		ButtonGroup bg=new ButtonGroup();
		bg.add(jb1);
		bg.add(jb2);
		bg.add(jb3);
		
		
	}
	 public void itemStateChanged(ItemEvent e)
		{
		 JRadioButton button=(JRadioButton)(e.getItem());
		 if(button.isSelected())
			 data=button.getActionCommand();
		 System.out.println(data);
		}
}
public class Pizza {
 
	
	Pizza()
	{
		JFrame frame=new JFrame("Pizza Shop");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setLayout(new FlowLayout());
		JTextArea box= new JTextArea(20,70);
		JLabel heading=new JLabel("Welcome to Home Style Pizza Shop",JLabel.CENTER);
		frame.add(heading);
		heading.setForeground(Color.RED);
		heading.setFont(new Font("Serif", Font.BOLD, 120));
		String [] dataOfSize= {"Pizza Size","Small : $6.50","Medium : $8.50","Large : $10.00"};
		String [] dataOfType= {"Pizza Type","Thin Crust","Medium Crust","Pan"};
		Topping topping=new Topping();
		frame.add(topping);
		
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout());
		Feature size=new Feature(dataOfSize);
		panel.add(size,BorderLayout.WEST);
		Feature type=new Feature(dataOfType);
        panel.add(type,BorderLayout.EAST);
        frame.add(panel);
		JPanel smallPanel=new JPanel();
		JButton button =new JButton("Process Selection");
		button.setPreferredSize(new Dimension(400,50));
		smallPanel.add(button);
        panel.add(smallPanel, BorderLayout.SOUTH);
        frame.add(box,BorderLayout.CENTER);
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		box.setEditable(true);
        		box.setText("");
        		box.append("Pizza type:" + type.data+"\n");
        		box.append("Pizza size :" + size.data + "\n");
        		double cost=0;
        		String pizza=type.data;
        		if(pizza==dataOfType[0])
        			cost=6.5;
        		else if(pizza==dataOfType[0])
        			cost=8.5;
        		else
        			cost=10;
        		box.append("Toppings : ");
        		
        		int length=topping.selection.size();
        		Iterator itr= topping.selection.iterator();
        		while(itr.hasNext())
        		{
        			box.append(itr.next()+" , ");
        			//System.out.println(itr.next());
        		}
        		box.append("\n");
        		cost=cost+ (1.5*length);
        		box.append("Amount Due : $"+ cost);
        		Font f1=box.getFont();

        		  // create a new, smaller font from the current font
        	    Font f2 = new Font(f1.getFontName(), f1.getStyle(), f1.getSize()+5);

        		  // set the new font in the editing area
        		box.setFont(f2);
        		box.setEditable(false);
        		
        		
        		
        	}
        });
        
		 
	}
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				new Pizza();
			}
		}
				
	);
		}
		catch(Exception e)
		{
			
		}
		

	}

}
