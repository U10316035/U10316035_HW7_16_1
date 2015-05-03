/*U10316035
 *Lin Tz Hau
 */
 
 //program to display 4 cards and refresh them in random
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

public class poker extends JFrame implements ActionListener{
	//create a button
	static JButton button = new JButton("ReFresh");
	//array to store cards
	ImageIcon[] poker = new  ImageIcon[52]; 
	//array to store 4 cards
	int card[] = new int[4];
	//4 labels to display cards
	JLabel card1;
	JLabel card2 ;
	JLabel card3 ;
	JLabel card4;
	
	public poker(){
		//store all 52 images to poker array
		for(int i=0; i <= 51; i++ ){
			poker[i] = createImage("prettycard/"+ (i+1) +".jpg");
		}	
		//shuffle the cards
		shuffle();
		//layout pictures
		piclayout();
		//add button listener
		button.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		/*if button pushed 
		 *shuffle the cards
		 *and set picture to 4 labels
		 */
		if(e.getSource() == button){
			shuffle();
			card1.setIcon(poker[card[0]]);
			card2.setIcon(poker[card[1]]);
			card3.setIcon(poker[card[2]]);
			card4.setIcon(poker[card[3]]);
			
		}  
	 }
	
	public void piclayout(){
		//grid layout by 1*4
		getContentPane().setLayout(new GridLayout(1,4));
		//assign one picture to label card1
		card1 = new JLabel(poker[card[0]]);
		getContentPane().add(card1);
		//assign one picture to label card2
		card2 = new JLabel(poker[card[1]]);
		getContentPane().add(card2);
		//assign one picture to label card3
		card3 = new JLabel(poker[card[2]]);
		getContentPane().add(card3);
		//assign one picture to label card4
		card4 = new JLabel(poker[card[3]]);
		getContentPane().add(card4);
			
	}
	//method to create image and return it
	protected ImageIcon createImage(String filename){
	    java.net.URL picture = getClass().getResource(filename);//get resource from url
	    if(picture != null)
	        return new ImageIcon(picture);

		return null;
	}
	
	//shuffle card method
	public void shuffle(){   
		//array to store random number to 52 cards to shuffle
		int[] deck = new int[52];
		String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
		String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9","10", "Jack", "Queen", "King"};
		    
		 
		// Initialize cards
		for (int i = 0; i < deck.length; i++)
		    deck[i] = i;
		    
		// Shuffle the cards
		for (int i = 0; i < deck.length; i++) {
		    // Generate an index randomly
		    int index = (int)(Math.random() * deck.length);
		    int temp = deck[i];
		    deck[i] = deck[index]; 
		    deck[index] = temp;
		}

		// Display the first four cards
		for (int i = 0; i <= 3; i++){
			for(int j = 0;j < 52;j++)
				if(deck[j] == i)
					card[i] = deck[i];
		}	
	}
	
	public static void main(String[] args) {
		//creat new frame
		poker frame = new poker();
		//set location center
		frame.setLocationRelativeTo(null);
		//set title
		frame.setTitle("Pick Four Cards");
		//set size of frame
		frame.setSize(600, 350);
		frame.setVisible(true);
		//exit when closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//refuse to resize
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		//add button
		frame.getContentPane().add(button);
		//set button's location and size
		button.setBounds(frame.getWidth()/2-50, frame.getHeight()-75, 100, 25);
	}
}
