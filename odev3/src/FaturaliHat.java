import java.util.Date;

public class FaturaliHat extends Hat {
    private int bedavaSure; // dakika cinsinden
    private int faturaTutari; // sabit fatura tutarı
    private int kullanilanSure; // dakika cinsinden

    public FaturaliHat(String numara, int bedavaSure, int faturaTutari) {
        super(numara);
        this.bedavaSure = bedavaSure;
        this.faturaTutari = faturaTutari;
        this.kullanilanSure = 0;
    }

    public int getBedavaSure() {
        return bedavaSure;
    }

    public void setBedavaSure(int bedavaSure) {
        this.bedavaSure = bedavaSure;
    }

    public int getFaturaTutari() {
        return faturaTutari;
    }

    public void setFaturaTutari(int faturaTutari) {
        this.faturaTutari = faturaTutari;
    }

    @Override
    public void AramaYap(String arananNumara, int konusmaSuresi) {
        int dakikaCinsinden = konusmaSuresi / 60;
        if (kullanilanSure + dakikaCinsinden > bedavaSure) {
            int asimSure = kullanilanSure + dakikaCinsinden - bedavaSure;
            faturaTutari += asimSure * 2;
        }
        kullanilanSure += dakikaCinsinden;
        yapilanAramalar.add(new Konusma(getTelefonNumarasi(), arananNumara, konusmaSuresi, new Date()));
    }

    @Override
    public void GelenArama(String arayanNumara, int konusmaSuresi) {
        gelenAramalar.add(new Konusma(arayanNumara, getTelefonNumarasi(), konusmaSuresi, new Date()));
    }

    public int faturaHesapla() {
        return faturaTutari;
    }

    @Override
    public String toString() {
        return "FaturaliHat{" +
                "numara=" + getTelefonNumarasi() +
                ", bedavaSure=" + bedavaSure +
                ", faturaTutari=" + faturaTutari +
                ", kullanilanSure=" + kullanilanSure +
                '}';
    }
}
