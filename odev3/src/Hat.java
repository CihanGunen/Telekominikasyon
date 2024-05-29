import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Hat {
    private String telefonNumarasi;
    protected List<Konusma> yapilanAramalar;
    protected List<Konusma> gelenAramalar;

    public Hat(String telefonNumarasi) {
        this.telefonNumarasi = telefonNumarasi;
        this.yapilanAramalar = new ArrayList<>();
        this.gelenAramalar = new ArrayList<>();
    }

    public abstract void AramaYap(String arananNumara, int sure);
    public abstract void GelenArama(String arayanNumara, int sure);

    public String getTelefonNumarasi() {
        return telefonNumarasi;
    }

    public void setTelefonNumarasi(String telefonNumarasi) {
        this.telefonNumarasi = telefonNumarasi;
    }

    public List<Konusma> getYapilanAramalar() {
        return yapilanAramalar;
    }

    public List<Konusma> getGelenAramalar() {
        return gelenAramalar;
    }

    @Override
    public String toString() {
        return "Telefon Numarası: " + telefonNumarasi;
    }

    // En uzun konuşma metodunu yazalım
    public Konusma EnUzunKonusma() {
        Konusma enUzun = null;
        for (Konusma konusma : yapilanAramalar) {
            if (enUzun == null || konusma.getAramaSuresi() > enUzun.getAramaSuresi()) {
                enUzun = konusma;
            }
        }
        for (Konusma konusma : gelenAramalar) {
            if (enUzun == null || konusma.getAramaSuresi() > enUzun.getAramaSuresi()) {
                enUzun = konusma;
            }
        }
        return enUzun;
    }

    // Arama sıklığına göre sıralama metodu (Map kullanmadan)
    public ArrayList<String> AramaSikliginaGoreSirala() {
        ArrayList<String> tumAramalar = new ArrayList<>();

        // Yapılan ve gelen aramaları aynı listeye ekle
        for (Konusma konusma : yapilanAramalar) {
            tumAramalar.add(konusma.getArananNumara());
        }
        for (Konusma konusma : gelenAramalar) {
            tumAramalar.add(konusma.getArayanNumara());
        }

        ArrayList<String> benzersizNumaralar = new ArrayList<>();
        ArrayList<Integer> aramaSikliklari = new ArrayList<>();

        // Benzersiz numaraları ve arama sıklıklarını say
        for (String numara : tumAramalar) {
            if (benzersizNumaralar.contains(numara)) {
                int index = benzersizNumaralar.indexOf(numara);
                aramaSikliklari.set(index, aramaSikliklari.get(index) + 1);
            } else {
                benzersizNumaralar.add(numara);
                aramaSikliklari.add(1);
            }
        }

        // Sıralı numaraları oluşturmak için sıralama işlemi
        ArrayList<String> siraliNumaralar = new ArrayList<>();
        while (!benzersizNumaralar.isEmpty()) {
            int maxIndex = 0;
            for (int i = 1; i < benzersizNumaralar.size(); i++) {
                if (aramaSikliklari.get(i) > aramaSikliklari.get(maxIndex) ||
                        (aramaSikliklari.get(i) == aramaSikliklari.get(maxIndex) &&
                                benzersizNumaralar.get(i).compareTo(benzersizNumaralar.get(maxIndex)) > 0)) {
                    maxIndex = i;
                }
            }
            siraliNumaralar.add(benzersizNumaralar.get(maxIndex));
            benzersizNumaralar.remove(maxIndex);
            aramaSikliklari.remove(maxIndex);
        }

        return siraliNumaralar;
    }
}
