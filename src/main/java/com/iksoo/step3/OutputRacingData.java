package com.iksoo.step3;

import java.util.List;

public class OutputRacingData {
    public void printBlankLine() {
        System.out.println();
    }

    public void printRacingStart() {
        System.out.println("\n실행 결과");
        printBlankLine();
    }

    public void printFinalResult(List<Object> winner) {
        System.out.print(winner);
        System.out.print("가 최종 우승했습니다.");
    }

    public void printWinner(List<Object> winner) {
        System.out.print(winner);
    }
}
