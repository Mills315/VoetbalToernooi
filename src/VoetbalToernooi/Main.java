package VoetbalToernooi;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;

public class Main {

    // maak een methode om rondes te simuleren. List van A -
    // List van A - H randomizen en dan index 0 -1 , 2 - 3, ..?
    // variabele fitheid toevoegen? dat is dan de 'wedstrijdspeelsterkte'
    // zo kan een amateurteam van een proteam winnen. maar niet vaak.
    // sterkte kan ook naar een percentage scoren omgezet worden.. bijv scoren = 50% betekent dat ze 50% kans hebben om 1 goal te scoren, 50%*50% voor 2 goals, et cetera
    // maak een 10 sec delay. Tussen elke ronde doen, anders is het toernooi binnen no time over ... ;p


    public static void main(String[] args) {

        List<VoetbalTeam> teams = getTeams();
        printTeams(teams);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Ronde1Shuffle(teams);
        Ronde1Fitheid(teams);
        Ronde1Spelen(teams);

        try {
            Thread.sleep(4000);
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

    // maak een fitheid generator. fitheid wordt een random, niet toegevoegd, moet in latere rondes weer een 'random random' zijn. pro teams hebben minder aan fitheid dan kroegteams.
    // om daarvoor te zorgen kijken je met instanceof en geef je anders andere waarden mee.
    // eventueel fitheid/speelsterkte tweaken als er teveel gewonnen wordt door een of ander

    private static void Ronde1Fitheid(List<VoetbalTeam> teams) {
        for (VoetbalTeam team : teams) {
            if (team instanceof AmateurTeam) {
                Random willekeur = new Random();
                int n = willekeur.nextInt(50 + 1);
                team.setFitheid(n);
            }
            if (team instanceof ProTeam) {
                Random willekeur = new Random();
                int n = willekeur.nextInt(20) + 1;
                team.setFitheid(n);
            }
        }
    }

    // fitheid + speelsterkte is wedstrijdsterkte. nieuwe arraylist voor winnaars ronde 1.

    // bedenk wat voor gelijkspel!

    private static void Ronde1Spelen(List<VoetbalTeam> teams) {
        List<VoetbalTeam> winnaarsRonde1 = new ArrayList<>();
        if(teams.get(0).speelsterkte + teams.get(0).fitheid > teams.get(1).speelsterkte + teams.get(1).fitheid ){
           winnaarsRonde1.add(teams.get(0));
            System.out.println(winnaarsRonde1.get(0) + " wint!");
        } else {
            winnaarsRonde1.add(teams.get(1));
            System.out.println(winnaarsRonde1.get(0) + " wint!");
        }
        if(teams.get(2).speelsterkte + teams.get(2).fitheid > teams.get(3).speelsterkte + teams.get(3).fitheid ){
            winnaarsRonde1.add(teams.get(2));
            System.out.println(winnaarsRonde1.get(1) + " wint!");
        } else {
            winnaarsRonde1.add(teams.get(3));
            System.out.println(winnaarsRonde1.get(1) + " wint!");
        }
        if(teams.get(4).speelsterkte + teams.get(4).fitheid > teams.get(5).speelsterkte + teams.get(5).fitheid ){
            winnaarsRonde1.add(teams.get(4));
            System.out.println(winnaarsRonde1.get(2) + " wint!");
        } else {
            winnaarsRonde1.add(teams.get(5));
            System.out.println(winnaarsRonde1.get(2) + " wint!");
        }
        if(teams.get(6).speelsterkte + teams.get(6).fitheid > teams.get(7).speelsterkte + teams.get(7).fitheid ){
            winnaarsRonde1.add(teams.get(6));
            System.out.println(winnaarsRonde1.get(3) + " wint!");
        } else {
            winnaarsRonde1.add(teams.get(7));
            System.out.println(winnaarsRonde1.get(3) + " wint!");
        }

    }
}

