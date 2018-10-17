package tk.arktech;

public class Calculator {


    private CurrencyCollection kolekcja;

    public Calculator(CurrencyCollection kolekcja) {
        this.kolekcja = kolekcja;
    }


    double GetResult(double kwota, String from, String to)
    {
        Currency cFrom = kolekcja.getByCode(from);
        Currency cTo = kolekcja.getByCode(to);

        return ((kwota/cFrom.getPrzelicznik())/cFrom.getSredni_kurs()) * cTo.getPrzelicznik() * cTo.getSredni_kurs();

    }
}
