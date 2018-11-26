package VoetbalToernooi;

import java.util.Random;

public class ProTeam extends VoetbalTeam {

    protected ProTeam(String naam, String sponsor, char deelnemer) {
        super(naam, sponsor, "");
        Random willekeur = new Random();
        int n = willekeur.nextInt(50) + 50;
        this.speelsterkte = n;
        this.deelnemer = deelnemer;
        int fitheid = 0;
    }

    public String getNaam() {
        return naam;
    }

    public String getSponsor() {
        return sponsor;
    }

    public int speelsterkte() {
        return speelsterkte;
    }

    public char deelnemer() {
        return deelnemer;
    }

    public void setFitheid(int fitheid) {
        this.fitheid = fitheid;
    }
}