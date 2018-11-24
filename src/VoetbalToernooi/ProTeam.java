package VoetbalToernooi;

import java.util.Random;

public class ProTeam extends VoetbalTeam {

    protected ProTeam(String naam, String sponsor, char deelnemer) {
        super(naam, sponsor);
        Random willekeur = new Random();
        int n = willekeur.nextInt(100) + 50;
        this.speelsterkte = n;
        this.deelnemer = deelnemer;
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
}