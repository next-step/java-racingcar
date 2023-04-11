package study.step3;

import java.util.List;

public class ResultView {
    public static void outPut(Track track) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Car> cars = track.getCars();
        for (Car car : cars) {
            changeCarMoveToString(stringBuilder, car);
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static void changeCarMoveToString(StringBuilder stringBuilder, Car car) {
        for (int i = 0; i < car.getMove(); i++) {
            stringBuilder.append("-");
        }
    }
}
