/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sample;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author michael.remington
 */
public class ShellGUIApp extends JFrame{
    
    private Container contents;
    private JLabel title;
    private JLabel image;
    private JButton btn;
    private JComboBox drop;
    private JTextArea text;
    
    private String[] list;
    
    private String output = "";
    
    
    
    public ShellGUIApp(){
        //giving a new title to the app window
        super("A Shell GUI Application");
        
        
        
        contents = getContentPane();
        //contents.setLayout(new BorderLayout());
        contents.setLayout(new FlowLayout());
        
        //define components
        title = new JLabel("This is an Example GUI");
        title.setVerticalAlignment(SwingConstants.TOP);
        //title.setForeground(Color.WHITE);
       // title.setBackground(Color.BLUE);
       // title.setOpaque(true);
        
        image = new JLabel(new ImageIcon("src/gui/Penguins.jpg"));
        image.setSize(200, 200);
        
        btn = new JButton("Enter");
        
        
        list = new String[3];
        list[0] = "Car";
        list[1] = "Bike";
        list[2] = "Plane";
       
        drop = new JComboBox(list);
        
        ItemListenerHandler listen = new ItemListenerHandler();
        drop.addItemListener(listen);
       
        
        
        
        
        text = new JTextArea(output, 10,40);
        
        
        //add all components to the window container
//        contents.add(title, BorderLayout.NORTH);
//        contents.add(btn, BorderLayout.SOUTH);
//        contents.add(image, BorderLayout.CENTER);
//        contents.add(drop, BorderLayout.WEST);
        contents.add(title);
        contents.add(btn);
        contents.add(drop);
        contents.add(text);
        contents.add(image);
       
        
        setSize(600,480);
        
        setVisible(true);
        
        
    }//end Gui Constructor
    
    private class ItemListenerHandler implements ItemListener{
            public void itemStateChanged(ItemEvent ie){
                int index = drop.getSelectedIndex();
                if(drop.getSelectedIndex() == 0){
                    output = "What kind of Car to you drive?";
                }
            }
    }
   
    public static void main(String [] agrs){
        ShellGUIApp  basicGui = new ShellGUIApp();
        basicGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
