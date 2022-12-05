package app;

public class TextToView {

    private static final String tableOfRules[] =  {
            " ",
            "[1]  Gracze na początku gry wybierają wysokość oraz szerokość planszy w zakresie 4-31",
            "[2]  Gracz grający białymi posiada kamyczki na planszy 'o', gracz grający czarnymi - 'x', puste pola oznaczone są '.' ",
            "[3]  W przypadku różnicy poziomu zawodników dozwolony jest handicap - kładzione są na planszy czarne kamyki o ilości równej różnicy poziomów,",
                    "       Handicap może być tylko zrealizowany na planszach: 9x9, 13x13, 19x19",
            "[4]  Każde pole posiada koordynate pionową i poziomą (cyfra to koordynata pozioma, litera - pionowa) ruch piszemy w formacie cyfra-litera np: 1A",
            "[5]  Niedozwolone jest stawianie kamyczka na zajętym polu!",
            "[6]  Każdy kamyk posiada 4 oddechy - oddechy są to wolne pola wokół kamyka (wyłączając skosy - tylko prawo,lewo,góra,dół)",
            "[7]  Takie same kamyki sąsiadujące z sobą tworzą grupę - w takim wypadku liczone są oddechy całej grupy (suma wolnych pól dla kamyków w grupie)",
            "[8]  Do grupy należą wszystkie kamyki sąsiadujące z kolejnymi takimi samymi kamykami wyłączając skosy",
            "[9]  Kamyk oraz grupe kamyków można zbić doprowadzając do sytuacji, w której kamyk/grupa posiada 0 oddechów",
            "[10] Niedozwolone jest samozbicie - gracz podczas swojej tury nie może doprowadzić do sytuacji, w której któryś z jego kamyków/grup nie będzie miał już oddechów ",
            "[11] Dozwolone jest passowanie tury za pomocą wypisania na ekran - pass",
            "[12] Dozwolony jest reset całej gry za pomocą wypisania na ekran - reset",
            "[13] Gre zawsze zaczynają czarne kamyczki z wyłączeniem sytuacji handicapu - wtedy rozpoczynają białe",
            "[14] Dozwolony jest powrót kilka tur wstecz za pomocą wypisania na ekran - rollback oraz następnie podania ilości tur",
            "[15] Wygrywa gracz, który ma najwięcej kamyczków na planszy",
            " "
    };

    private static final char[] tableToViewHelloText = ("     Witaj w grze GO+ ! GO+ to ulepszona wersja popularnej gry GO \n").toCharArray();

    private static final String[] tableOfGOLogo = {
            "========================================================================",
            "             _____  _____          _____   ___  ___  ___ _____",
            "            |  __ \\|  _  |   _    |  __ \\ / _ \\ |  \\/  ||  ___|",
            "            | |  \\/| | | | _| |_  | |  \\// /_\\ \\| .  . || |__",
            "            | | __ | | | ||_   _| | | __ |  _  || |\\/| ||  __|",
            "            | |_\\ \\\\ \\_/ /  |_|   | |_\\ \\| | | || |  | || |___",
            "             \\____/ \\___/          \\____/\\_| |_/\\_|  |_/\\____/",
            "========================================================================"
    };

    private static final String startStringChooseAction = "Wybierz działanie poprzez wypisanie akcji:: [ start ] - rozpoczęcie gry [ rules ] - zasady  [ end ] - zakończenie gry";


    static void generateMainView() throws InterruptedException {
       soutGoLogo();
       generateStartText();
    }

     static void soutStartStringToChooseAction() {
        System.out.println();
        System.out.println(startStringChooseAction);
    }

    private static void soutGoLogo() throws InterruptedException {
        for (int i = 0; i < tableOfGOLogo.length; i++) {
            System.out.println(tableOfGOLogo[i]);
            Thread.sleep(200L);
        }
    }

     static void generateStartText() throws InterruptedException {
        for (int i = 0; i < tableToViewHelloText.length; i++) {
            System.out.print(tableToViewHelloText[i]);
            Thread.sleep(15l);
        }
    }

    static void soutRules() throws InterruptedException {
        for (int i = 0; i < tableOfRules.length; i++) {
            System.out.println(tableOfRules[i]);
            Thread.sleep(90l);
        }
    }

}
