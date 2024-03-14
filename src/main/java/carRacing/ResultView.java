package carRacing;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void printResult(List<Car> cars) {
        for(Car car: cars) {
            System.out.print(car.getName());
            printCarResult(car);
        }
    }

    public static void printCarResult(Car car) {
        for(int i=0; i<car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printResultStartMessage() {
        System.out.println("실행 결과");
    }

    public static void printWinner(List<Car> cars) {
        List<String> winners = getWinner(cars, getMaxPosition(cars));
        System.out.print(String.join(",",winners));
        System.out.print("가 최종 우승했습니다.");
    }

    public static int getMaxPosition(List<Car> cars) {
        return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    }

    public static List<String> getWinner(List<Car> cars, int maxPosition) {
        return cars.stream().filter(car -> car.getPosition() == maxPosition).map(Car::getName).collect(Collectors.toList());
    }
}

