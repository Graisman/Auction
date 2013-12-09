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

/**
 * A unique user that can make multiple bids for multiple items (WIP)
 * @author Jesse Chen
 */
public class user {
    private String name;
    private Scanner keyboard = new Scanner(System.in);
    
    public user(){
        setName();
    }
    
    public void setName(){
        System.out.print("Enter your name: ");
        name = keyboard.next();
    }
    
    public String getName(){
        return name;
    }

    public String toString(){
        return getName();
    }
}
