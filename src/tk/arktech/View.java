package tk.arktech;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class View {
    private JPanel panel1;
    private JTextField kwotaTextField;
    private JComboBox<Currency> fromComboBox;
    private JButton konwertujButton;
    private JLabel kwotaWynikowaLabel;
    private JComboBox<Currency> toComboBox;

    private Calculator calc;

    public View(Calculator calc) {
        this.calc = calc;

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
                kwotaWynikowaLabel.setText(Double.toString(calc.GetResult(Integer.parseInt(kwotaTextField.getText()),
                        ((Currency) fromComboBox.getSelectedItem()).getKod_waluty(),
                        ((Currency) toComboBox.getSelectedItem()).getKod_waluty())));
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
