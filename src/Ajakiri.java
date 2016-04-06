/**
 * Created by lanev_000 on 24.03.2016.
 */
public class Ajakiri extends Teos{
    public Ajakiri(String teoseKirjeldus, String teoseTahis, String laenutajaNimi, int paevadeArv) {
        super(teoseKirjeldus, teoseTahis, laenutajaNimi, paevadeArv);
    }

    @Override
    public boolean kasHoidlast() {
        int aasta = Integer.parseInt(getTeoseKirjeldus().split("/")[1].split(",")[0]);
        if (aasta <= 2000){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Tegemist on ajakirjaga \r\n" + super.toString();
    }
}
