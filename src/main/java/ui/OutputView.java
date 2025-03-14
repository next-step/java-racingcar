package ui;

import racing.GrandPrix;

public class OutputView {

    public static void printResult(GrandPrix grandPrix) {
        var report = grandPrix.report();

        report.forEach((key, value) -> System.out.println("-".repeat(value)));
    }
}
