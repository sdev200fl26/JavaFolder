// Bill Ruben
// p.577

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JResortCalculator extends JFrame implements ItemListener {
    final int base_price = 200;
    final int weekend_premium = 100;
    final int breakfast_premium = 20;
    final int golf_premium = 75;
    int totalPrice = base_price;
    JCheckBox weekendBox = new JCheckBox("Weekend premium $" + weekend_premium, false);
    JCheckBox breakfastBox = new JCheckBox("Breakfast $" + breakfast_premium, false);
    JCheckBox golfBox = new JCheckBox("Golf $" + golf_premium, false);
    JLabel resortLabel = new JLabel("Resort Price Calculator");
    JLabel priceLabel = new JLabel("The price for your stay is");
    JTextField totPrice = new JTextField(4);
    JLabel optionExplainLabel = new JLabel("Base price for a room is $" + base_price + ".");
    JLabel optionExplainLabel2 = new JLabel("Check the options you want.");

    public JResortCalculator() {
        super("Resort Price Estimator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(resortLabel);
        add(optionExplainLabel);
        add(optionExplainLabel2);
        add(weekendBox);
        add(breakfastBox);
        add(golfBox);
        add(priceLabel);
        add(totPrice);
        totPrice.setText("$" + totalPrice);
        weekendBox.addItemListener(this);
        breakfastBox.addItemListener(this);
        golfBox.addItemListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent event) {
        Object source = event.getSource();
        int select = event.getStateChange();
        if (source == weekendBox)
            if (select == ItemEvent.SELECTED)
                totalPrice += weekend_premium;
            else
                totalPrice -= weekend_premium;
        else if (source == breakfastBox) {
            if (select == ItemEvent.SELECTED)
                totalPrice += breakfast_premium;
            else
                totalPrice -= breakfast_premium;
        } else // if(source == golfBox) by default
        if (select == ItemEvent.SELECTED)
            totalPrice += golf_premium;
        else
            totalPrice -= golf_premium;
        totPrice.setText("$" + totalPrice);
    }

    public static void main(String[] args) {
        JResortCalculator aFrame = new JResortCalculator();
        final int width = 300;
        final int height = 200;
        aFrame.setSize(width, height);
        aFrame.setVisible(true);
    }

}
