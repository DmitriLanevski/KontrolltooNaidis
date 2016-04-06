/**
 * Created by lanev_000 on 24.03.2016.
 */
public class SuurimaViiviseleidja implements Kontrollija{
    private String viiviseHoidja = "";
    private String teoseKirjeldus = "";
    private double suurimViivis = 0;

    public void saadaHoiatus(){
        System.out.println("Suurima viivisega laenutaja nimi on: " + viiviseHoidja + ". Teos on: " + teoseKirjeldus + ". " + "Suurim viivis on " + suurimViivis + ".");
    }

    public void salvestaViivis(String laenutajaNimi, String teoseKirjeldus, double viiviseSuurus){
        if (viiviseSuurus > suurimViivis){
            suurimViivis = viiviseSuurus;
            viiviseHoidja = laenutajaNimi;
            this.teoseKirjeldus = teoseKirjeldus;
            //saadaHoiatus();
        }
    }
}
