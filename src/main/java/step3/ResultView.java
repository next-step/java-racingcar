package step3;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
    private static final StringBuilder tempPositionString = new StringBuilder();

    public static void displayRacingState(List<Car> carList) {
        System.out.println("게임 결과");
        carList
                .forEach(car -> System.out.println(getPositionString(car.getPosition())));
        System.out.println("");
    }

    private static String getPositionString(int position) {
        tempPositionString.setLength(0);
        IntStream.range(0, position).forEach(vo -> tempPositionString.append("-"));
        return tempPositionString.toString();
    }
}
