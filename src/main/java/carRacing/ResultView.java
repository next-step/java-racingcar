package carRacing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private static final StringBuilder tempPositionString = new StringBuilder();

    public static void displayRacingState(List<Car> carList) {
        carList
                .forEach(car -> System.out.println(car.getName() + " : " +getPositionString(car.getPosition())));
        System.out.println("");
    }

    public static void displayRacingWinner(List<Car> winnerList){
        tempPositionString.setLength(0);
        String winnerNames = winnerList
                .stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

    private static String getPositionString(int position) {
        tempPositionString.setLength(0);
        IntStream.range(0, position).forEach(vo -> tempPositionString.append("-"));
        return tempPositionString.toString();
    }

}
