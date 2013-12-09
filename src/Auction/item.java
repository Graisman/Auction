/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Auction;

/**
 *
 * @author Alice
 */
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * An item that is to be auctioned. Stores the name of the item, the image file 
 * of the item, the item's current price, and the item's 
 * maximum price.
 * @author Jesse Chen
 */
public class item {
    private String name;
    private Image img;
    private double price;
    private double maxPrice;
    private user highest;
    
    /**
     * Constructor
     * @param n Name of the item
     * @param i The image file for this item
     * @param p Starting bid
     * @param m Maximum bid
     */
    public item(String n, String i, double p, double m, user u){
        setName(n);
        setImage(i);
        setPrice(p);
        setMaxPrice(m);
    }
    
    /**
     * Sets the name of the item
     * @param n Name of the item
     */
    public void setName(String n){
        name = n;
    }
    
    /**
     * Sets the image file for this item
     * @param i The image file for this item
     */
    public void setImage(String i){
        try
        {
            img = ImageIO.read(new File(i));
        }
        catch(Exception e)
        {
            System.out.println("setImage(String i) constructor error");
        }
    }
    
    /**
     * Sets the price for the item
     * @param p New price for the item
     */
    public void setPrice(double p){
        price = p;
    }
    
    /**
     * Sets the maximum price for the item
     * @param m Maximum price for the item
     */
    public void setMaxPrice(double m){
        maxPrice = m;
    }
    
    /**
     * Sets the highest bidder for the item
     * @param u User with the highest bid
     */
    public void setHighestBidder(user u){
        highest = u;
    }
    
    /**
     * Gets the name of the item
     * @return The name of the item
     */
    public String getName(){
        return name;
    }
    
    /**
     * Gets the image of the item
     * @return The image of the item
     */
    public Image getImage(){
        return img;
    }
    
    /**
     * Gets the current price of the item
     * @return The current price of the item
     */
    public double getPrice(){
        return price;
    }
    
    /**
     * Gets the maximum price of the item
     * @return The maximum price of the item
     */
    public double getMaxPrice(){
        return maxPrice;
    }
    
    /**
     * Gets the current highest bidder of the item
     * @return The user with the highest bid on the item
     */
    public user getHighestBidder(){
        return highest;
    }
    
    /**
     * Prints the name, current bid, and maximum bid of the item
     * @return The name, current bid, and maximum bid of the item
     */
    public String toString(){
        return name + "; Current bid: $" + String.format("%.2f", price) + "; Maximum bid: $" + String.format("%.2f", maxPrice);
    }
}
