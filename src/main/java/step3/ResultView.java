package step3;

import java.util.Scanner;

public class ResultView {

    public void startView() {
        System.out.println("실행 결과");
    }

    public static void resultView(int carLocation) {
        for(int i = 0; i < carLocation; i++) {
            System.out.print("-");
        }
    }
}
