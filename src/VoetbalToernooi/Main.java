package VoetbalToernooi;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        List<VoetbalTeam> teams = getTeams();
        printTeams(teams);

        // maak een methode om rondes te simuleren. List van A -
        // List van A - H randomizen en dan index 0 -1 , 2 - 3, ..?
        // variabele fitheid toevoegen? dat is dan de 'wedstrijdspeelsterkte'
        // zo kan een amateurteam van een proteam winnen. maar niet vaak.
        // sterkte kan ook naar een percentage scoren omgezet worden.. bijv scoren = 50% betekent dat ze 50% kans hebben om 1 goal te scoren, 50%*50% voor 2 goals, et cetera

        Ronde1Shuffle(teams);

        // maak een 10 sec delay. Tussen elke ronde doen, anders is het toernooi binnen no time over ... ;p

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }

    // in de volgende methode worden de teams gemaakt

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

    // in de volgende methode worden de gemaakte teams geprint

    private static void printTeams(List<VoetbalTeam> teams) {
        for (VoetbalTeam team : teams) {
            System.out.println("Team " + team.deelnemer + ", met een sterkte van " + team.speelsterkte + "; ook wel bekend als Team '" + team.naam + "', is klaar om deel te nemen aan het toernooi.");
        }
    }

    // dit is de methode voor ronde 1; eerst een shuffle, dan 'spelen'

    private static void Ronde1Shuffle(List<VoetbalTeam> teams) {
        Collections.shuffle(teams);
        System.out.println("In ronde 1 spelen de volgende teams tegen elkaar:");
        System.out.println();
        System.out.print(teams.get(0).naam + " speelt tegen " + teams.get(1).naam + ".");
        System.out.println();
        System.out.print(teams.get(2).naam + " speelt tegen " + teams.get(3).naam + ".");
        System.out.println();
        System.out.print(teams.get(4).naam + " speelt tegen " + teams.get(5).naam + ".");
        System.out.println();
        System.out.print(teams.get(6).naam + " speelt tegen " + teams.get(7).naam + ".");
        System.out.println();


    }

    private static void Ronde1Spelen(List<VoetbalTeam> teams){

    }
}

