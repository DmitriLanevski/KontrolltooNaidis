import java.util.ArrayList;
import java.util.List;

/**
 * Created by lanev_000 on 24.03.2016.
 */
public class ViiviseHoiataja implements Kontrollija {
    private double lubatudViivis;
    private List<String> viivisteHoidja = new ArrayList<>();

    public ViiviseHoiataja(double lubatudViivis) {
        this.lubatudViivis = lubatudViivis;
    }

    public double getLubatudViivis() {
        return lubatudViivis;
    }

    public void setLubatudViivis(double lubatudViivis) {
        this.lubatudViivis = lubatudViivis;
    }

    public void salvestaViivis(String laenutajaNimi, String teoseKirjeldus, double viiviseSuurus){
        if (viiviseSuurus > lubatudViivis && !viivisteHoidja.contains(laenutajaNimi)){
            viivisteHoidja.add(laenutajaNimi);
        }
    }

    public List<String> getViivisteHoidja() {
        return viivisteHoidja;
    }
}
