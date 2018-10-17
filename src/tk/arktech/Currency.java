package tk.arktech;

public class Currency {
    private String kod_waluty;
    private String nazwa;
    private int przelicznik;
    private double sredni_kurs;

    public Currency(String kod_waluty, String nazwa, int przelicznik, double sredni_kurs) {
        this.kod_waluty = kod_waluty;
        this.nazwa = nazwa;
        this.przelicznik = przelicznik;
        this.sredni_kurs = sredni_kurs;
    }

    public String getKod_waluty() {
        return kod_waluty;
    }

    public void setKod_waluty(String kod_waluty) {
        this.kod_waluty = kod_waluty;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getPrzelicznik() {
        return przelicznik;
    }

    public void setPrzelicznik(int przelicznik) {
        this.przelicznik = przelicznik;
    }

    public double getSredni_kurs() {
        return sredni_kurs;
    }

    public void setSredni_kurs(double sredni_kurs) {
        this.sredni_kurs = sredni_kurs;
    }
}
