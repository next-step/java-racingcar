package study.carracing.ui;

import java.util.List;

public class ResultView {

    public static <Type> void outputResult(List<Type> items) {
        System.out.println("실행 결과");
        for (Type item : items) {
            System.out.println(item);
        }
    }
}
