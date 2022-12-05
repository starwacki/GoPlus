package app;
import Exceptions.IllegalMoveException;
import Exceptions.IllegalRollbackException;
import Exceptions.SelfCapturedException;
import model.Go;

import java.util.*;

public class MainTest {
    public static void main(String[] args) throws InterruptedException {
        TextToView.generateMainView();
        doUserAction();
    }

    private static String getStringFromUser() {
        return new Scanner(System.in).next();
    }

    private static void doUserAction() throws InterruptedException {
        String action = " ";
        while (!action.equals("end")) {
            TextToView.soutStartStringToChooseAction();
            action = getStringFromUser();
            if (action.equals("rules"))
                TextToView.soutRules();
            else if (action.equals("start")) {
                startGame();
                action = "end";
            } else if (action.equals("end"))
                action = "end";
            else
                System.out.println("Niepoprawna akcja! Spróbuj ponownie");
        }
    }

    private static void startGame() {
        String action = "";
        Go go = getGo();
        System.out.println("Plansza startowa:" + "\n\n" + go.getBoardToString() + "\n");
        if (isHandicapPossible(go)) {
            handicapStones(go);
        }
        System.out.println("Jeśli chcesz ruszyć wypisz koordynaty w formacie CYFRALITERA np [1A], jeśli chcesz skorzystać z innych akcji, wypisz: ");
        System.out.println("[ pass ] - passuje ture [ rollback ] - pozwala wrócić o ilość tur [ reset ] - resetuje gre [ end ] - konczy gre ");
        System.out.println("[results] - konczy gre pokazując wyniki");
        while (!action.equals("end")) {
            action = getStringFromUser();
            try {
                switch (action) {
                    case "pass" -> doPassAction(go);
                    case "reset" -> {
                        startGame();
                        action = "end";
                    }
                    case "results" -> {
                        go.soutResults();
                        action = "end";
                    }
                    case "end" -> action = "end";
                    case "rollback" -> doRollbackAction(go);
                    default -> doMoveAction(go,action);
                }
            } catch (IllegalMoveException e) {
                System.out.println("NIEPOPRAWNY RUCH, SPRÓBUJ PONOWNIE");
            } catch (IllegalRollbackException e) {
                System.out.println("NIEPOPRAWNA ILOŚĆ TUR DO ROLLBACKU! Wykonaj ponownie akcje!");
            } catch (SelfCapturedException e) {
                System.out.println("SAMOBICIE! SPRÓBUJ PONOWNIE");
            }
        }
    }

    private static void doRollbackAction(Go go) {
        System.out.println("Podaj ilosc tur do cofnięcia");
        int turns = Integer.parseInt(getStringFromUser());
        go.rollBack(turns);
        System.out.println("Stan planszy:" + "\n" + go.getBoardToString());
        System.out.println("Ruch należy do: " + go.getTurn());
        System.out.println("\nWypisz akcje do wykonania: ");
    }

    private static void doMoveAction(Go go,String action) {
        go.move(action);
        System.out.println("Stan planszy:" + "\n" + go.getBoardToString());
        System.out.println("Ruch należy do: " + go.getTurn());
        System.out.println("\nWypisz akcje do wykonania: ");
    }

    private static void doPassAction(Go go) {
        go.passTurn();
        System.out.println("Ruch należy do: " + go.getTurn());
        System.out.println("\nWypisz akcje do wykonania: ");
    }

    private static Go getGo() {
        int height = 0;
        int width = 0;
        while (height==0 || width==0) {
            try {
                System.out.println("Podaj wysokość planszy: (4-31) ");
                height = setBoardValue();
                System.out.println("Podaj szerokość planszy: (4-31) ");
                width = setBoardValue();
            } catch (NumberFormatException e) {
                System.out.println("Niepoprawna wielkość! spróbuj ponownie!!");
                return getGo();
            }
        }
        return new Go(height,width);
    }

    private static int setBoardValue() {
       int heightWidth = getBoardValue();
        if (!isGoodBoardValue(heightWidth))  {
            throw new NumberFormatException();
        }
        return heightWidth;
    }

    private static int getBoardValue() {
        return  Integer.parseInt(getStringFromUser());
    }

    private static boolean isGoodBoardValue(int heightWidth) {
        return heightWidth >3 && heightWidth <32;
    }

    private static boolean isHandicapPossible(Go go) {
        return (go.getSize().get("width") ==9 && go.getSize().get("height") ==9) ||
                (go.getSize().get("width") ==13 && go.getSize().get("height") ==13) ||
                (go.getSize().get("width") ==19 && go.getSize().get("height") ==19);
    }

    private static void handicapStones(Go go) {
        String getInfoFromUser;
        System.out.println("Możliwy jest handicap, czy chcesz go wykorzystać? - wypisz [ tak ]  ");
        getInfoFromUser = getStringFromUser();
        if (getInfoFromUser.equals("tak")) {
            int handicapStones = getHandicapLevels(go);
            go.handicapStones(handicapStones);
            System.out.println("Plansza po handicapie:" + "\n\n" + go.getBoardToString());
        }
    }

    private static int getHandicapLevels(Go go) {
        int handicapStones = 0;
        while (handicapStones==0) {
            try {
                System.out.println("Podaj różnice poziomów między graczami (1-9)");
                int levels = Integer.parseInt(getStringFromUser());
                if (!isPropertyLevelsBetweenPlayers(levels))
                    throw new NumberFormatException();
                else
                    handicapStones = getPropertyStonesToHandicap(go,levels);
            } catch (NumberFormatException e) {
                System.out.println("Niepoprawna liczba poziomów");
            }
        }
        return handicapStones;
    }

    private static int getPropertyStonesToHandicap(Go go,int levels) {
        if (go.getSize().get("height")==9 && levels >5) return 5;
        else return levels;
    }

    private static boolean isPropertyLevelsBetweenPlayers(int stones) {
        return stones > 0 && stones < 10;
    }


}
