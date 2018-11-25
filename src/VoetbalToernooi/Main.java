package VoetbalToernooi;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<VoetbalTeam> teams = getTeams();
        printTeams(teams);

        // maak een methode om rondes te simuleren. List van A -
        // List van A - H randomizen en dan index 0 -1 , 2 - 3, ..?
        // variabele fitheid toevoegen? dat is dan de 'wedstrijdspeelsterkte'
        // zo kan een amateurteam van een proteam winnen. maar niet vaak.
        // sterkte kan ook naar een percentage scoren omgezet worden.. bijv scoren = 50% betekent dat ze 50% kans hebben om 1 goal te scoren, 50%*50% voor 2 goals, et cetera


        

    }

    private static List<VoetbalTeam> getTeams() {
        List<VoetbalTeam> teams = new ArrayList<>();
        teams.add(new ProTeam("Rood", "Philips", 'A'));
        teams.add(new ProTeam("Blauw", "Unilever", 'B'));
        teams.add(new ProTeam("Groen", "AEGON", 'C'));
        teams.add(new ProTeam("Geel", "Shell", 'D'));
        teams.add(new AmateurTeam("Honing", "Winnie de pooh", 'E'));
        teams.add(new AmateurTeam("Pindakaas", "Tijgetje", 'F'));
        teams.add(new AmateurTeam("Hagelslag", "Knorretje", 'G'));
        teams.add(new AmateurTeam("Chocoladepasta", "Iejoor", 'H'));
        return teams;
    }

    private static void printTeams(List<VoetbalTeam> teams) {
        for (VoetbalTeam team : teams) {
            System.out.println("Team " + team.deelnemer + ", met een sterkte van " + team.speelsterkte + "; ook wel bekend als Team '" + team.naam + "', is klaar om deel te nemen aan het toernooi.");
        }
    }
}

