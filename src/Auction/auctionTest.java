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
 * Tests the auction class with out a GUI. Creates a new item, adds it to the 
 * array of items in the auction class, and simulates bidding until a maximum 
 * bid is reached.
 * @author Jesse Chen
 */
public class auctionTest {
    public static void main(String[]args){
        auction test = new auction();
        Scanner keyboard = new Scanner(System.in);
        
        user xx = new user();
        test.addUser(xx);
        user two = new user();
        test.addUser(two);
        
        item computer = new item("Computer", "src/newpackage/desktop-computer.jpg", 100, 500, null);
        test.addItem(computer);
        item itouch = new item("iTouch", "src/newpackage/itouch.jpg", 50, 200, null);
        test.addItem(itouch);
        
        System.out.print("Who is bidding? ");
        String who = keyboard.next();
        int u = 0;
        for(u = 0; u < test.users.size(); u++){
            if(who.equals(test.users.get(u).getName())){
                break;
            }
            else if(u == test.users.size() - 1){
                System.out.print("Please reenter username: ");
                who = keyboard.next();
                u = -1;
            }
        }
        
        
        System.out.print("Which item would you like to bid on?\n\"Computer\" or \"iTouch\"? ");
        String whichItem = keyboard.next();
        

        for(int i = 0; i < test.items.size(); i++){
            if(whichItem.equals(test.items.get(i).getName())){
                System.out.println(test.items.get(i));

                while(test.bidding == true){
                    System.out.println(test.bid(u, i));

                    if(test.items.get(i).getPrice() == test.items.get(i).getMaxPrice()){
                        break;
                    }
                }
                break;
            }
            else if(i == test.items.size() - 1){
                System.out.print("Please reenter item name: ");
                whichItem = keyboard.next();
                i = -1;
            }
        } 
    }
}