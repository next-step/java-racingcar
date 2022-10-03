package racingcar.view;

import java.util.List;

import racingcar.domain.Distance;
import racingcar.domain.Distances;

public class ConsoleDisplayer implements Display {
    private static final String SHOW_DELIMITER = " : ";
    
    private final String symbol;

    public ConsoleDisplayer(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public void show(Distances distances) {
        for (Distance distance : distances) {
            show(distance, symbol);
        }
        showNewLine();
    }

    @Override
    public void showWinners(Distances distances) {
        showWinner(winnerNames(distances));
    }

    private List<String> winnerNames(Distances distances) {
        return distances.longest().names();
    }
    
    private void show(Distance distance, String distanceSymbol) {
        System.out.print(distance.getCarName() + SHOW_DELIMITER);
        for (int count = 0; count < distance.getDistance(); count++) {
            System.out.print(distanceSymbol);
        }
        System.out.println();
    }

    private void showWinner(List<String> winners) {
        System.out.println(String.join(",", winners) + "가 최종 우승했습니다.");
    }
    
    private void showNewLine() {
        System.out.println();
    }
}
