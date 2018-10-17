package tk.arktech;

import java.util.Iterator;
import java.util.List;

public class CurrencyCollection {
    private List<Currency> kolekcja;

    public List<Currency> getKolekcja() {
        return kolekcja;
    }

    public Currency getByCode(String kod_waluty)
    {
        Iterator<Currency> iterator = kolekcja.iterator();
        while(iterator.hasNext())
        {
            Currency currency = iterator.next();
            if(currency.getKod_waluty().equals(kod_waluty))
            {
                return currency;
            }
        }
        return null;
    }


}
