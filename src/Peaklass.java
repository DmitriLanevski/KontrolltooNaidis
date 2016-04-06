import javafx.print.Collation;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lanev_000 on 24.03.2016.
 */
public class Peaklass {
    public static List<Teos> loeTeoseid(String fileName) throws Exception{
        List<Teos> teosteList = new ArrayList<>();

        String filePath = "C:/Users/lanev_000/IdeaProjects/KontrolltooNaidis/src/" + fileName;
        java.io.File fail = new java.io.File(filePath);

        Scanner sc = new Scanner(fail, "UTF-8");

        while (sc.hasNextLine()){
            String rida = sc.nextLine();
            String[] tukid;
            tukid = rida.split(";");
            int paevadeArv = Integer.parseInt(tukid[3].trim());
            if (tukid[0].contains("/")){
                teosteList.add(new Ajakiri(tukid[0].trim(), tukid[1].trim(), tukid[2].trim(), paevadeArv));
            }
            else{
                teosteList.add(new Raamat(tukid[0].trim(), tukid[1].trim(), tukid[2].trim(), paevadeArv));
            }
        }
        return teosteList;
    }

    public static void main(String[] args) throws Exception{
        List<Teos> teosteList = loeTeoseid("laenutus.txt");
        Collections.sort(teosteList);
        SuurimaViiviseleidja suurimaViiviseleidja = new SuurimaViiviseleidja();
        ViiviseHoiataja viiviseHoiataja = new ViiviseHoiataja(0.2);

        for (Teos teos : teosteList) {
            teos.arvutaViivis(viiviseHoiataja);
            teos.arvutaViivis(suurimaViiviseleidja);
            System.out.println(teos.toString());
        }

        System.out.println("Viivist omavad: ");
        for (String nimi : viiviseHoiataja.getViivisteHoidja()) {
            System.out.println(nimi);
        }
        System.out.println(" ");

        suurimaViiviseleidja.saadaHoiatus();
    }
}
