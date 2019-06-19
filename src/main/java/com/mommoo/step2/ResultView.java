package com.mommoo.step2;

public class ResultView {
    private static final String LINE = "-";
    private final StringBuilder BUILDER = new StringBuilder();

    public void printCarMoveLine(int moveCount) {
        BUILDER.setLength(0);
        while (moveCount-- > 0) {
            BUILDER.append(LINE);
        }
        System.out.println(BUILDER);
    }
}
