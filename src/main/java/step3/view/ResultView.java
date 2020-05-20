package step3.view;

import step3.model.Car;
import step3.view.Visitable;
import step3.view.Visitor;

public class ResultView implements Visitor {

    private static final String RESULT_MESSAGE = "실행 결과";

    // static 메소드 위치
    public static void start() {
        System.out.println(RESULT_MESSAGE);
    }

    @Override
    public void visit(Visitable car) {
        System.out.println(((Car) car).getStep());
    }

    public void end() {
        System.out.println();
    }
}
