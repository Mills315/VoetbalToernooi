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
        System.out.println();

        pause();

        Ronde1Shuffle(teams);
        Ronde1Fitheid(teams);
        System.out.println();

        pause();

        List<VoetbalTeam> winnaarsRonde1 = Ronde1Spelen(teams);
        System.out.println();

        pause();

        Ronde2Shuffle(winnaarsRonde1);
        Ronde2Fitheid(winnaarsRonde1);
        System.out.println();

        pause();

        List<VoetbalTeam> winnaarsRonde2 = Ronde2Spelen(winnaarsRonde1);
        System.out.println();

        pause();

        FinaleShuffle(winnaarsRonde2);
        FinaleFitheid(winnaarsRonde2);
        System.out.println();

        pause();

        List<VoetbalTeam> winnaar = FinaleSpelen(winnaarsRonde2);
        System.out.println();

        pause();

        Nabeschouwing(winnaar);
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

    private static List<VoetbalTeam> Ronde1Spelen(List<VoetbalTeam> teams) {
        List<VoetbalTeam> winnaarsRonde1 = new ArrayList<>();
        if (teams.get(0).speelsterkte + teams.get(0).fitheid > teams.get(1).speelsterkte + teams.get(1).fitheid) {
            winnaarsRonde1.add(teams.get(0));
            System.out.println(winnaarsRonde1.get(0).naam + " wint!");
        } else {
            winnaarsRonde1.add(teams.get(1));
            System.out.println(winnaarsRonde1.get(0).naam + " wint!");
        }
        if (teams.get(2).speelsterkte + teams.get(2).fitheid > teams.get(3).speelsterkte + teams.get(3).fitheid) {
            winnaarsRonde1.add(teams.get(2));
            System.out.println(winnaarsRonde1.get(1).naam + " wint!");
        } else {
            winnaarsRonde1.add(teams.get(3));
            System.out.println(winnaarsRonde1.get(1).naam + " wint!");
        }
        if (teams.get(4).speelsterkte + teams.get(4).fitheid > teams.get(5).speelsterkte + teams.get(5).fitheid) {
            winnaarsRonde1.add(teams.get(4));
            System.out.println(winnaarsRonde1.get(2).naam + " wint!");
        } else {
            winnaarsRonde1.add(teams.get(5));
            System.out.println(winnaarsRonde1.get(2).naam + " wint!");
        }
        if (teams.get(6).speelsterkte + teams.get(6).fitheid > teams.get(7).speelsterkte + teams.get(7).fitheid) {
            winnaarsRonde1.add(teams.get(6));
            System.out.println(winnaarsRonde1.get(3).naam + " wint!");
        } else {
            winnaarsRonde1.add(teams.get(7));
            System.out.println(winnaarsRonde1.get(3).naam + " wint!");
        }
        return winnaarsRonde1;
    }

    // ronde twee starten met lijst van winnaars. weer shufflen? waarom niet. nieuwe random fitheid, om het spannend te houden. speelsterkte blijft wel hetzelfde.

    private static void Ronde2Shuffle(List<VoetbalTeam> winnaarsRonde1) {
        Collections.shuffle(winnaarsRonde1);
        System.out.println("In ronde 2 spelen de volgende teams tegen elkaar:");
        System.out.println();
        System.out.print(winnaarsRonde1.get(0).naam + " speelt tegen " + winnaarsRonde1.get(1).naam + ".");
        System.out.println();
        System.out.print(winnaarsRonde1.get(2).naam + " speelt tegen " + winnaarsRonde1.get(3).naam + ".");
        System.out.println();
    }

    private static void Ronde2Fitheid(List<VoetbalTeam> winnaarsRonde1) {
        for (VoetbalTeam team : winnaarsRonde1) {
            if (winnaarsRonde1 instanceof AmateurTeam) {
                Random willekeur = new Random();
                int n = willekeur.nextInt(50 + 1);
                team.setFitheid(n);
            }
            if (winnaarsRonde1 instanceof ProTeam) {
                Random willekeur = new Random();
                int n = willekeur.nextInt(20) + 1;
                team.setFitheid(n);
            }
        }
    }

    private static List<VoetbalTeam> Ronde2Spelen(List<VoetbalTeam> winnaarsRonde1) {
        List<VoetbalTeam> winnaarsRonde2 = new ArrayList<>();
        if (winnaarsRonde1.get(0).speelsterkte + winnaarsRonde1.get(0).fitheid > winnaarsRonde1.get(1).speelsterkte + winnaarsRonde1.get(1).fitheid) {
            winnaarsRonde2.add(winnaarsRonde1.get(0));
            System.out.println(winnaarsRonde2.get(0).naam + " wint!");
        } else {
            winnaarsRonde2.add(winnaarsRonde1.get(1));
            System.out.println(winnaarsRonde2.get(0).naam + " wint!");
        }
        if (winnaarsRonde1.get(2).speelsterkte + winnaarsRonde1.get(2).fitheid > winnaarsRonde1.get(3).speelsterkte + winnaarsRonde1.get(3).fitheid) {
            winnaarsRonde2.add(winnaarsRonde1.get(2));
            System.out.println(winnaarsRonde2.get(1).naam + " wint!");
        } else {
            winnaarsRonde2.add(winnaarsRonde1.get(3));
            System.out.println(winnaarsRonde2.get(1).naam + " wint!");
        }
        return winnaarsRonde2;
    }

    private static void FinaleShuffle(List<VoetbalTeam> winnaarsRonde2) {
        System.out.println("In de finale spelen de volgende teams tegen elkaar:");
        System.out.println();
        System.out.print(winnaarsRonde2.get(0).naam + " speelt tegen " + winnaarsRonde2.get(1).naam + ".");
        System.out.println();
    }

    private static void FinaleFitheid(List<VoetbalTeam> winnaarsRonde2) {
        for (VoetbalTeam team : winnaarsRonde2) {
            if (winnaarsRonde2 instanceof AmateurTeam) {
                Random willekeur = new Random();
                int n = willekeur.nextInt(75 + 1);
                team.setFitheid(n);
            }
            if (winnaarsRonde2 instanceof ProTeam) {
                Random willekeur = new Random();
                int n = willekeur.nextInt(30) + 1;
                team.setFitheid(n);
            }
        }
    }

    private static List<VoetbalTeam> FinaleSpelen(List<VoetbalTeam> winnaarsRonde2) {
        List<VoetbalTeam> winnaar = new ArrayList<>();
        if (winnaarsRonde2.get(0).speelsterkte + winnaarsRonde2.get(0).fitheid > winnaarsRonde2.get(1).speelsterkte + winnaarsRonde2.get(1).fitheid) {
            winnaar.add(winnaarsRonde2.get(0));
            System.out.println(winnaar.get(0).naam + " wint de FINALE!!!!");
        } else {
            winnaar.add(winnaarsRonde2.get(1));
            System.out.println(winnaar.get(0).naam + " wint de FINALE!!!!");
        }
        return winnaar;
    }


    private static void Nabeschouwing(List<VoetbalTeam> winnaar) {
        if (winnaar.get(0) instanceof ProTeam) {
            System.out.println("De sponsor van " + winnaar.get(0).naam + ", " + ((ProTeam) winnaar.get(0)).getSponsor() + ", geeft aan verheugd te zijn met deze uitkomst.");
        } else {
            System.out.println("De mascotte van " + winnaar.get(0).naam + ", " + ((AmateurTeam) winnaar.get(0)).getMascotte() + ", werd dronken aangetroffen achter de stamkroeg van het team");
        }   // Casting redundant maar voor de duidelijkheid.
    }

    private static void pause() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}

