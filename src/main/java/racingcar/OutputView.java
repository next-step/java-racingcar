package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printMileage(List<Car> cars, boolean isFirst) {
        if (isFirst) {
            System.out.println("실행 결과");
        }
        for (Car car : cars) {
            System.out.println(car.getName()+ ":" + "-".repeat(car.getMoveTotalCnt()));
        }
        System.out.println();
    }

    public static void printWinner(List<Car> cars) {
        Integer max = cars.stream().map(Car::getMoveTotalCnt).max(Integer::compare).orElse(Integer.valueOf(-1));

        List<String> winnerNames = cars.stream().filter(car -> car.getMoveTotalCnt() == max).map(Car::getName).collect(Collectors.toList());

        for (int i = 0; i < winnerNames.size(); i++) {
            printName(winnerNames.get(i), i == winnerNames.size()-1);
        }
        System.out.println("가 최종 우승했습니다");

    }

    private static void printName(String name, boolean isLast) {
        if (isLast) {
            System.out.print(name);
            return;
        }
        System.out.print(name + ",");
    }


}