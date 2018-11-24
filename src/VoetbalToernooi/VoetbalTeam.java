package VoetbalToernooi;

public class VoetbalTeam {

    protected String naam;
    protected String sponsor;
    protected String mascotte;
    protected int speelsterkte;
    protected char deelnemer;
    protected VoetbalTeam(String naam, String sponsor) {
        this.naam = naam;
        this.sponsor = sponsor;
    }
    public String getNaam(){
        return naam;
    }
}
