package VoetbalToernooi;

import java.util.Random;

public class AmateurTeam extends VoetbalTeam {

    protected AmateurTeam(String naam, String mascotte, char deelnemer) {
        super(naam, mascotte);
        Random willekeur = new Random();
        int n = willekeur.nextInt(40) + 5;
        this.speelsterkte = n;
        this.deelnemer = deelnemer;
    }

    public String getNaam() {
        return naam;
    }

    public String getMascotte() {
        return mascotte;
    }

    public int speelsterkte() {
        return speelsterkte;
    }

    public char deelnemer() {
        return deelnemer;
    }
}
