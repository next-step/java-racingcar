package racingcar.controller;


public class ResultView {


    private ResultView() {

    }

    public static ResultView INSTANCE = null;

    public static ResultView getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ResultView();
        }
        return INSTANCE;
    }

    public void printRacingCarsStatus(String racingCarsStatus) {
        System.out.println(racingCarsStatus);
    }
}
