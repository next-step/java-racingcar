package step3.view;

import step3.game.Game;
import step3.model.Cars;

import java.util.List;

public class ResultView {
    static public void showResult(Cars resultOfTurn, int count) {
        for (int i = 0; i < count; i++) {
            List<Integer> pointOfCarsByTime = resultOfTurn.getPointOfCarsByTime(i);
            pointOfCarsByTime.forEach(ResultView::printDistance);
            printBorder();
        }
    }

    static void printDistance(int distance) {
        for (int i = 0; i < distance; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    static private void printBorder() {
        System.out.println("==========================");
    }

    public static void showResult(Game game) {
        for (int i = 0; i < game.countOfGame(); i++) {
            List<Integer> pointOfCarsByTime = game.cars().getPointOfCarsByTime(i);
            pointOfCarsByTime.forEach(ResultView::printDistance);
            printBorder();
        }
    }
}
