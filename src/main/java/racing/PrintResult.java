package racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintResult {
    private boolean checkSame(Car toCompare, int winnerPosition) {
        if (toCompare.getMovingRange() == winnerPosition) {
            return true;
        }
        return false;
    }

    public List<String> setWinner(Players players) {
        Collections.sort(players.getCars());
        List<String> winner = new ArrayList<>();

        for (Car car : players.getCars()) {
            if (checkSame(car, players.getCars().get(0).getMovingRange())) {
                winner.add(car.getName());
            }
        }

        return winner;
    }

    public void printPlayers(Car aCar) {
        System.out.print(aCar.getName() + " : ");
        printTrace(aCar);
        System.out.println();
    }

    public void printTrace(Car aCar) {
        for (int i = 0; i < aCar.getMovingRange(); i++) {
            System.out.print("-");
        }
    }

    public void printWinner(List<String> winners) {

        System.out.print("최종 우승자: ");

        for (String winner : winners) {
            System.out.print(winner + " ");
        }
        System.out.println();

    }
}
