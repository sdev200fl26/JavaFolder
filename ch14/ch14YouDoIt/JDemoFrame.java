// Bill Ruben
// p.550

import javax.swing.*;
public class JDemoFrame
{
    public static void main(String[] args) 
    {
       JFrame aFrame = new JFrame("This is a frame");
       final int width = 300;
       final int height = 250;
       aFrame.setSize(width, height);
       aFrame.setVisible(true); 
    }
}