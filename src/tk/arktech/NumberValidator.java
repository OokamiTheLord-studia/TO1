package tk.arktech;

import javax.swing.*;
import java.math.BigDecimal;

public class NumberValidator extends InputVerifier {

    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText();
        try {
            Double value = Double.parseDouble(text);
            System.out.println(value);
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Błędny format kwoty");
        }
        return false;
    }


}
