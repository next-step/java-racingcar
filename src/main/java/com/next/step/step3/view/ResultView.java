package com.next.step.step3.view;

public class ResultView {

    private static final String RESULT_TITLE = "실행 결과";

    private static final String RESULT_DELIMITER = "";

    public void showResultTitle() {
        System.out.println(RESULT_TITLE);
    }

    public void showResultContents(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.position());
        }
        System.out.println(RESULT_DELIMITER);
    }
}
