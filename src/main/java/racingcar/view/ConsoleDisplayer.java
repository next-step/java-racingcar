package racingcar.view;

import java.util.List;

import racingcar.domain.Distance;

public class ConsoleDisplayer implements Display {
    private final String symbol;

    public ConsoleDisplayer(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public void show(List<Distance> distances) {
        for (Distance distance : distances) {
            show(distance, symbol);
        }
        showNewLine();
    }

    private static void show(Distance distance, String distanceSymbol) {
        for (int count = 0; count < distance.getDistance(); count++) {
            System.out.print(distanceSymbol);
        }
        System.out.println();
    }
    
    private static void showNewLine() {
        System.out.println();
    }
}
