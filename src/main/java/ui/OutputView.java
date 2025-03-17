package ui;

import racing.GrandPrix;

public class OutputView {

    public static void printResult(GrandPrix grandPrix) {
        var reports = grandPrix.report();

        reports.forEach(report -> System.out.println("-".repeat(report.getPosition())));
    }
}
