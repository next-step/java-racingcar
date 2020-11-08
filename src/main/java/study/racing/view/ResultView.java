package study.racing.view;

import study.racing.Car;

public class ResultView {

    private static String RESULT_HEAD_MESSAGE = "=============실행결과=============";
    private static String RESULT_LAP_HEAD_MESSAGE = "번째 시도";


    public void showResultHead() {
        System.out.println(RESULT_HEAD_MESSAGE);
    }

    public void showCarRacingLapResult(Car carLapResult) {
        System.out.println(carLapResult.toString());
    }

    public void showLapResultHead(int tryIndex) {
        System.out.println((tryIndex+1) + RESULT_LAP_HEAD_MESSAGE);
    }
}
