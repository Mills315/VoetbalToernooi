package VoetbalToernooi;

abstract class VoetbalTeam {

    protected String naam;
    protected String sponsor;
    protected String mascotte;
    protected int speelsterkte;
    protected char deelnemer;
    protected int fitheid;

    protected VoetbalTeam(String naam, String sponsor, String mascotte) {
        this.naam = naam;
        this.sponsor = sponsor;
        this.mascotte = mascotte;
        int fitheid = 0;
    }

    public String getNaam() {
        return naam;
    }

    public String getMascotte() {
        return mascotte;
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

    public int fitheid() {
        return fitheid;
    }


}
