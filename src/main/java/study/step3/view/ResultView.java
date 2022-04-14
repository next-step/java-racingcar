package study.step3.view;

import java.util.List;

public class ResultView {
    public static void print() {
        System.out.println("실행 결과");
    }

    public static void printPosition(int position) {
        String car = "";
        for (int i = 0; i < position; i++) {
            car += "-";
        }
        System.out.println(car);
    }
}
