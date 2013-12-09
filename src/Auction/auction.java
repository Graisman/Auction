/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Auction;

/**
 *
 * @author Alice
 */
import java.util.Scanner;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JFrame;

/**
 * The primary class for this project. The auction class is able to add users,
 * add items, and simulate bidding up to a maximum bid.
 * @author Jesse Chen
 */
public class auction extends JFrame{
    public ArrayList<item> items = new ArrayList<item>();
    public ArrayList<user> users = new ArrayList<user>();
    public boolean bidding = true;
//    private Container contents;
//    private JLabel title;
    private Scanner keyboard = new Scanner(System.in);
    
    /**
     * Default constructor
     */
    public auction(){
//        //Giving a new title to the app window
//        super("Auction Program");
//        
//        contents = getContentPane();
//        contents.setLayout(new FlowLayout());
//        
//        //Define components
//        title = new JLabel("This is an Example GUI");
//        
//        title.setForeground(Color.BLACK);
//        //title.setBackground(Color.BLUE);
//        //title.setOpaque(true);
//        
//        //add all components to the window container
//        contents.add(title);
//        
//        setSize(600, 480);
//        
//        setVisible(true);
    }
    
    /**
     * Creates a new user for this program.
     */
    public void addUser(user u){
        users.add(u);
    }
    
    /**
     * Adds a new item to the auction.
     * @param i New item
     */
    public void addItem(item i){
        items.add(i);
    }
    
    /**
     * Simulates bidding with keyboard input.
     * @param u Index of the user in the users array list that is bidding
     * @param i Index of the item in the items array list that will be bid on
     * @return A string describing the status of the bid/item
     */
    public String bid(int u, int i){
        System.out.print("Please enter your bid for " + items.get(i).getName() + " or \"-1\" to quit: ");
        double bid = keyboard.nextDouble();
        
        if(bid == -1){
            bidding = false;
            return "";
        }
        else if(bid >= items.get(i).getMaxPrice()){
            items.get(i).setPrice(items.get(i).getMaxPrice());
            items.get(i).setHighestBidder(users.get(u));
            bidding = false;
            return items.get(i).getHighestBidder() + " has won " + items.get(i).getName() + "!\n";
        }
        else if(bid > items.get(i).getPrice()){
            items.get(i).setPrice(bid);
            items.get(i).setHighestBidder(users.get(u));
            bidding = true;
            return users.get(u).getName() + " is the current highest bidder!\n";
        }
        else{
            bidding = true;
            return "Please enter a value greater than $" + String.format("%.2f", items.get(i).getPrice()) + "!\n";
        }
    }
}
