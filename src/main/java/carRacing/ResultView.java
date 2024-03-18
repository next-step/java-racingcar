package carRacing;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void printResult(List<Car> cars) {
        for(Car car: cars) {
            String result = "";
            result += car.getName()+" ";
            result += printCarPosition(car);
            System.out.println(result);
        }
        System.out.println();
    }

    private static String printCarPosition(Car car) {
        String position = "";
        for(int i=0; i<car.getPosition(); i++) {
            position +="-";
        }
        return position;
    }

    public static void printResultStartMessage() {
        System.out.println("실행 결과");
    }

    public static void printWinner(List<Car> cars) {
        System.out.print(cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(",")));
        System.out.print("가 최종우승했습니다.");
    }
}

