package step3.view;

import step3.domain.Car;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행결과";
    private static final String CAR_POSITION_MODEL = "-";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printCurrentCarPosition(final Car car) {
        System.out.println(addCarPosition(car.getPosition()));
    }

    public String addCarPosition(final int carPosition) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < carPosition; i++) {
            result.append(CAR_POSITION_MODEL);
        }
        return result.toString();
    }

}
