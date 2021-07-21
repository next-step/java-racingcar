package step4.view;

import step4.game.Game;

import java.util.List;

public class ResultView {
    private ResultView() {
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

    static public void showResult(Game game) {
        for (int i = 0; i < game.countOfGame(); i++) {
            List<Integer> pointOfCarsByTime = game.cars().getPointOfCarsByTime(i);
            pointOfCarsByTime.forEach(ResultView::printDistance);
            printBorder();
        }
    }
}
