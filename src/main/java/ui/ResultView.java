package ui;

import model.Racing;

public class ResultView {

    public static void doRaceAndPrintResult(Racing racing) {
        System.out.println("실행 결과");

        while (racing.isRemainTry()) {
            racing.move();
            racing.print();
        }

        racing.printWinner();
    }
}
