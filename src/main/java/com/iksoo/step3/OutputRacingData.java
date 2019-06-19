package com.iksoo.step3;

import java.util.List;

public class OutputRacingData {
    public void printBlankLine() {
        System.out.println();
    }

    OutputRacingData() {
        System.out.println("\n실행 결과");
        printBlankLine();
    }

    public void printEachInning(Car[] car) {
        for (int i = 0; i < car.length; i++) {
            car[i].printInningResult();
        }
    }

    public void printFinalResult(List<Object> winner) {
        System.out.print(winner);
        System.out.print("가 최종 우승했습니다.");
    }
}
