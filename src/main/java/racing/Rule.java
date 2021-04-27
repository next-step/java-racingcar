package racing;

import java.util.*;

public class Rule {
    boolean isGame = true;
    int round = 0;
    String[] winnerRacer;
    int winnerSpeed = 0;
    HashMap<String, Integer> finalWinner;

    void checkWinnerReset() {
        winnerSpeed = 0;
        finalWinner = new LinkedHashMap<String, Integer>();
    }

    void checkWinner(String racer, int speed, int idx, int carsIdx) {
        if (winnerSpeed < speed) {
            winnerSpeed = speed;
            finalWinner.put(racer, speed);
            winnerRacer[idx] = racer;
        }
    }

    void NameLengthCheck(String name) {
        if (name.length() > 4) {
            isGame = false;
            System.out.println(" 5 < name length ");
        }
    }

    void setRound(int round) {
        this.round = round;
        winnerRacer = new String[round];
    }

    void roundWinner(int roundIdx) {
        System.out.println(winnerRacer[roundIdx]);
    }

    void finalWinner() {
        int max=0;
        String winner = "";
        for (Map.Entry<String, Integer> entry : finalWinner.entrySet()) {
            if (entry.getValue() > max ) {
                max = entry.getValue();
                winner = entry.getKey();
            }
            System.out.println("final : " + entry.getKey() );
        }
    }
}
