import java.util.Date;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Konusma nesneleri oluşturma
        Konusma konusma1 = new Konusma("5551112233", "5553332211", 300, new Date());
        Konusma konusma2 = new Konusma("5551112233", "5554443322", 150, new Date());
        Konusma konusma3 = new Konusma("5553332211", "5551112233", 450, new Date());

        // FaturaliHat nesnesi oluşturma ve test etme
        FaturaliHat faturaliHat = new FaturaliHat("5551112233", 100, 50);
        faturaliHat.AramaYap("5553332211", 6000); // 100 dakika bedava, kalan 10 dakika ücretli (20 TL)
        faturaliHat.GelenArama("5554443322", 300);
        faturaliHat.AramaYap("5554443322", 3000); // 50 dakika ücretli (100 TL)

        System.out.println(faturaliHat);
        System.out.println("En Uzun Konuşma: " + faturaliHat.EnUzunKonusma());
        System.out.println("Fatura Tutarı: " + faturaliHat.faturaHesapla());

        // FaturasizHat nesnesi oluşturma ve test etme
        FaturasizHat faturasizHat = new FaturasizHat("5552223344", (int) 100.0);
        faturasizHat.AramaYap("5553332211", 3000); // 150 TL (3000 saniye * 0.05 TL)
        faturasizHat.GelenArama("5554443322", 1800);
        faturasizHat.AramaYap("5554443322", 6000); // Bakiye yetersiz, sadece kalan 100 TL kullanılabilir

        System.out.println(faturasizHat);
        System.out.println("En Uzun Konuşma: " + faturasizHat.EnUzunKonusma());
        System.out.println("Kalan Bakiye: " + faturasizHat.getBakiye());

        // Arama sıklığına göre sıralama
        ArrayList<String> aramaSikligi = faturaliHat.AramaSikliginaGoreSirala();
        System.out.println("Arama Sıklığına Göre Sıralama: " + aramaSikligi);
    }
}
