package io;

import java.util.List;

public class ConsoleWriter {
    public static void writeHeader() {
        System.out.println("실행 결과");
    }

    public static void writeGameInformation(ResultView resultView) {
        System.out.println(resultView.getGameAsString());
    }

    public static void writeWinner(List<String> winner) {
        System.out.println(String.join(",", winner) + "가 최종 우승했습니다.");
    }

    private ConsoleWriter() {
    }
}
