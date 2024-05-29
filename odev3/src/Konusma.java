import java.util.Date;

public class Konusma implements Comparable<Konusma> {
    private String arayanNumara;
    private String arananNumara;
    private int aramaSuresi;
    private Date konusmaTarihi;

    // Constructor: Arayan numara, aranan numara, arama süresi ve konuşma tarihini alır
    public Konusma(String arayanNumara, String arananNumara, int aramaSuresi, Date konusmaTarihi) {
        this.arayanNumara = arayanNumara;
        this.arananNumara = arananNumara;
        this.aramaSuresi = aramaSuresi;
        this.konusmaTarihi = konusmaTarihi;
    }

    // Constructor: Konuşma tarihi olmadan çağrıldığında mevcut tarihi kullanır
    public Konusma(String arayanNumara, String arananNumara, int aramaSuresi) {
        this(arayanNumara, arananNumara, aramaSuresi, new Date());
    }

    // toString metodu: Arayan, aranan telefon numaralarını ve arama süresini döndürür
    @Override
    public String toString() {
        return "Arayan: " + arayanNumara + ", Aranan: " + arananNumara + ", Süre: " + aramaSuresi + " saniye, Tarih: " + konusmaTarihi;
    }

    // compareTo metodu: Arama süresine göre karşılaştırma yapar
    @Override
    public int compareTo(Konusma other) {
        return Integer.compare(this.aramaSuresi, other.aramaSuresi);
    }

    // Getter ve Setter metodları
    public String getArayanNumara() {
        return arayanNumara;
    }

    public void setArayanNumara(String arayanNumara) {
        this.arayanNumara = arayanNumara;
    }

    public String getArananNumara() {
        return arananNumara;
    }

    public void setArananNumara(String arananNumara) {
        this.arananNumara = arananNumara;
    }

    public int getAramaSuresi() {
        return aramaSuresi;
    }

    public void setAramaSuresi(int aramaSuresi) {
        this.aramaSuresi = aramaSuresi;
    }

    public Date getKonusmaTarihi() {
        return konusmaTarihi;
    }

    public void setKonusmaTarihi(Date konusmaTarihi) {
        this.konusmaTarihi = konusmaTarihi;
    }

}
