package racingcar;

import java.util.List;

public class Output {
    static void print(List<Car> cars) {
        System.out.println("실행결과");
        cars.forEach(car -> System.out.println(car.getName() + ": " + car.getRacingPath()));
    }

    static void printWinner(List<Car> winners) {
        String nameOfWinners = winners.toString();
        System.out.print(nameOfWinners.substring(1, nameOfWinners.length()-1));
        System.out.println("가 최종 우승했습니다.");
    }
}
