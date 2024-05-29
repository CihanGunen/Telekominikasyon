import java.util.ArrayList;

public class FaturasizHat extends Hat {
    private int bakiye;

    public FaturasizHat(String numara, int bakiye) {
        super(numara);
        this.bakiye = bakiye;
    }

    public int getBakiye() {
        return bakiye;
    }

    public void setBakiye(int bakiye) {
        this.bakiye = bakiye;
    }

    public void bakiyeYukle(int tutar) {
        this.bakiye += tutar;
    }

    @Override
    public void AramaYap(String arananNumara, int konusmaSuresi) {
        double aramaUcreti = konusmaSuresi * 0.05;
        if (bakiye >= aramaUcreti) {
            bakiye -= aramaUcreti;
            yapilanAramalar.add(new Konusma(getTelefonNumarasi(), arananNumara, konusmaSuresi));
        } else {
            int gercekKonusmaSuresi = (int) (bakiye / 0.05);
            if (gercekKonusmaSuresi > 0) {
                bakiye = 0;
                yapilanAramalar.add(new Konusma(getTelefonNumarasi(), arananNumara, gercekKonusmaSuresi));
            }
        }
    }

    @Override
    public void GelenArama(String arayanNumara, int konusmaSuresi) {
        gelenAramalar.add(new Konusma(arayanNumara, getTelefonNumarasi(), konusmaSuresi));
    }

    @Override
    public String toString() {
        return "FaturasizHat{" +
                "numara=" + getTelefonNumarasi() +
                ", bakiye=" + bakiye +
                '}';
    }
}
