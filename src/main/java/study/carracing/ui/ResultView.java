package study.carracing.ui;

import java.util.List;

public class ResultView {

    public static void outputTitle() {
        System.out.println("실행 결과");
    }

    public static <Type> void outputResult(List<Type> items) {
        for (Type item : items) {
            System.out.println(item);
        }
        System.out.println();
    }
}
