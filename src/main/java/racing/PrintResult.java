package racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintResult {
    public void checkSame(List<String> winners, Car toCompare, Car winner) {
        if (winner.getMovingRange() == toCompare.getMovingRange() && toCompare != winner) {
            winners.add(toCompare.getName());
            System.out.print(", " + toCompare.getName());
        }
    }

    public void printTrace(Car aCar) {
        for (int i = 0; i < aCar.getMovingRange(); i++) {
            System.out.print("-");
        }
    }

    public List<String> printWinner(Players players) {

        Collections.sort(players.getCars());
        List<String> winner = new ArrayList<>();

        winner.add(players.getCars().get(0).getName());
        System.out.print("최종 우승자: " + winner.get(0));

        for (Car car : players.getCars()) {
            checkSame(winner, car, players.getCars().get(0));
        }
        System.out.println();

        return winner;
    }
}
