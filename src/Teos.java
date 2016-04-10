/**
 * Created by lanev_000 on 24.03.2016.
 */
public abstract class Teos implements Comparable<Teos>{
    private String teoseKirjeldus;
    private String teoseTahis;
    private String laenutajaNimi;
    private int paevadeArv;
    private double viivis = 0.0;

    public Teos(String teoseKirjeldus, String teoseTahis, String laenutajaNimi, int paevadeArv) {
        this.teoseKirjeldus = teoseKirjeldus;
        this.teoseTahis = teoseTahis;
        this.laenutajaNimi = laenutajaNimi;
        this.paevadeArv = paevadeArv;
    }

    public String getTeoseKirjeldus() {
        return teoseKirjeldus;
    }

    public String getTeoseTahis() {
        return teoseTahis;
    }

    public abstract boolean kasHoidlast();

    public int getLaenutusaeg(){
        int laenutusaeg;

        if (teoseTahis.equals("roheline")){
            laenutusaeg = 1;
        }
        else if (teoseTahis.equals("puudub")){
            laenutusaeg = 14;
        }
        else if (teoseTahis.equals("kollane")){
            laenutusaeg = 30;
        }
        else if (teoseTahis.equals("sinine")){
            laenutusaeg = 60;
        }
        else{
            laenutusaeg = 0;
        }
        return laenutusaeg;
    }

    public double getPaevaneViivis(){
        double paevaneViivis;

        if (teoseTahis.equals("roheline")){
            paevaneViivis = 2.0;
        }
        else if (teoseTahis.equals("puudub")){
            paevaneViivis = 0.15;
        }
        else if (teoseTahis.equals("kollane")){
            paevaneViivis = 0.05;
        }
        else if (teoseTahis.equals("sinine")){
            paevaneViivis = 0.05;
        }
        else{
            paevaneViivis = 0.0;
        }
        return  paevaneViivis;
    }

    public void arvutaViivis(Kontrollija kontrollija){
        double viivis;
        if (paevadeArv > getLaenutusaeg()){
            viivis = (paevadeArv - getLaenutusaeg()) * getPaevaneViivis();
            this.viivis = viivis;
            kontrollija.salvestaViivis(laenutajaNimi, teoseKirjeldus, viivis);
        }
    }

    public String toString(){
        String jahVoiEi;
        if (kasHoidlast()){
            jahVoiEi = "Jah";
        }
        else{
            jahVoiEi = "Ei";
        }
        return  "Teos: " + teoseKirjeldus + "\r\n" +
                "Tahis: " + teoseTahis + "\r\n" +
                "Laenutusaeg: " + getLaenutusaeg() + "\r\n" +
                "Paevane viivis: " + getPaevaneViivis() + "\r\n" +
                "Kas hoidlast?: " + jahVoiEi + "\r\n" +
                "Laenutaja nimi: " + laenutajaNimi + "\r\n" +
                "Paevade arv: " + paevadeArv + "\r\n" +
                "Viivis on " + viivis + "\r\n";
    }

    @Override
    public int compareTo(Teos teos) {
        if (teoseKirjeldus.compareTo(teos.getTeoseKirjeldus()) < -1){
            return -1;
        }
        if (teoseKirjeldus.compareTo(teos.getTeoseKirjeldus()) > 1){
            return 1;
        }
        return 0;
    }
}
