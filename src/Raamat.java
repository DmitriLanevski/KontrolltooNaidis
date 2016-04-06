/**
 * Created by lanev_000 on 24.03.2016.
 */
public class Raamat extends Teos{
    public Raamat(String teoseKirjeldus, String teoseTahis, String laenutajaNimi, int paevadeArv) {
        super(teoseKirjeldus, teoseTahis, laenutajaNimi, paevadeArv);
    }

    @Override
    public boolean kasHoidlast() {
        if (getTeoseTahis().equals("kollane") || getTeoseTahis().equals("sinine")){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Tegemist on raamatuga. \r\n" + super.toString();
    }
}
