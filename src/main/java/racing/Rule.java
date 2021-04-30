package racing;

import java.util.*;

public class Rule {
    boolean isGame = true;
    int round = 0;
    String[] winnerRacer;
    int winnerSpeed = 0;
    HashMap<String, Integer> finalWinner;

    void setWinnerList() {
        finalWinner = new LinkedHashMap<String, Integer>();
    }

    void setWinnerCount(String name, int count) {
        finalWinner.put(name, count);
    }


    void NameLengthCheck(String name) {
        if (name.length() > 4) {
            isGame = false;
            System.out.println(" 5 < name length ");
        }
    }

    void setRound(int round) {
        this.round = round;
    }


    void finalWinner() {
        int max = 0;
        String winnerName = "";
        for (Map.Entry<String, Integer> entry : finalWinner.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                winnerName = entry.getKey();
            }
        }
        System.out.println("winner : " + winnerName);
    }

    void racingPrint(int max) {
        for (int speedIdx = 0; speedIdx < max; speedIdx++) {
            System.out.print("-");
        }
    }

    // 각 라운드별 우승자 체크할 때 사용하는 기능, 룰 이해 잘못함 사용 x
    // 사용 x
    void checkWinnerReset() {
        winnerSpeed = 0;
        finalWinner = new LinkedHashMap<String, Integer>();
    }

    // 사용 x
    void checkWinner(String racer, int speed, int idx) {
        if (winnerSpeed < speed) {
            winnerSpeed = speed;
            finalWinner.put(racer, speed);
            winnerRacer[idx] = racer;
        }
    }

    // x
    void roundWinner(int roundIdx) {
        System.out.println(winnerRacer[roundIdx]);
    }
}
