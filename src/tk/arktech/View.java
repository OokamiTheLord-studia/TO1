package tk.arktech;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Iterator;

public class View {
    private JPanel panel1;
    private JTextField kwotaTextField;
    private JComboBox<Currency> fromComboBox;
    private JButton konwertujButton;
    private JLabel kwotaWynikowaLabel;
    private JComboBox<Currency> toComboBox;
     private DecimalFormat df;

    private Calculator calc;

    public View(Calculator calc) {
        this.calc = calc;

        df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.DOWN);


        kwotaTextField.setInputVerifier(new NumberValidator());


        //fromComboBox = new JComboBox<Currency>();
        Iterator<Currency> iterator = calc.getKolekcja().getKolekcja().iterator();
        while(iterator.hasNext()) {
            Currency c = iterator.next();
            fromComboBox.addItem(c);
            toComboBox.addItem(c);
        }
        konwertujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(kwotaTextField.isValid()) {


                    kwotaWynikowaLabel.setText(df.format((calc.GetResult( Double.parseDouble(kwotaTextField.getText()),
                            ((Currency) fromComboBox.getSelectedItem()).getKod_waluty(),
                            ((Currency) toComboBox.getSelectedItem()).getKod_waluty()))).replaceAll(",", "."));
                }
            }
        });


    }



    public static void display(Calculator calc) {
        JFrame frame = new JFrame("View");
        frame.setContentPane(new View(calc).panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
