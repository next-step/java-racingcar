package study.carracing.ui;

import java.util.List;

public class CarRacingResultView implements ResultView {

    public static final String comment = "가 최종 우승했습니다.";

    @Override
    public void outputTitle() {
        System.out.println("실행 결과");
    }

    @Override
    public <Type> void outputResult(List<Type> items) {
        for (Type item : items) {
            System.out.println(item);
        }
        System.out.println();
    }

    @Override
    public <Type> void outputResultAndComment(List<Type> items) {
        for (Type item : items) {
            System.out.print(item);
        }
        System.out.println(comment);
    }
}
