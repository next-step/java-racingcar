package racing.view;

import racing.domain.Car;

public class ResultView {
    private static String CAR_STATE_STR = "-";
    private static String CAR_STATE_FORMAT = "%s : %s\n";

    public static void printRacingResult(String result) {
        System.out.println(result);
    }

    public static String positionToString(Car car) {
        StringBuilder stringBuilder = new StringBuilder();

        int times = car.getPosition();
        for (int i = 0; i < times; i++) {
            stringBuilder.append(CAR_STATE_STR);
        }

        return String.format(CAR_STATE_FORMAT, car.getName(), stringBuilder.toString());
    }
}