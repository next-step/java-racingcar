package step4_racingCarWithWinner;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class RacingGamePrint{

    public void printResult(List<Car> list) {
        OptionalInt max = list.stream().mapToInt(car -> car.carDistance().length()).max();
        String winnersNames = list.stream().filter(car -> car.carDistance().length() == max.getAsInt()).map(Car::carName).collect(Collectors.joining(","));
        System.out.println(winnersNames+"가 최종 우승했습니다.");
    }

    public void printEachGame(List<Car> list) {
        list.forEach(System.out::println);
        System.out.println();
    }

}
