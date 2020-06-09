package edu.nextstep.racing;

import java.util.ArrayList;

public class ResultView {
    public static void view(String contents) {
        System.out.println(contents);
    }

    public static void carView(String carName) {
        System.out.print(carName + " : ");
    }

    public static void carLineView() {
        System.out.print("-");
    }

    public static void winnerView(ArrayList winnerList) {
        
        System.out.print(winners + "가 최종 우승했습니다.");
    }

    public static void newLine() {
        System.out.println();
    }
}
