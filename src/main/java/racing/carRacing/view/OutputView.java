package racing.carRacing.view;

import racing.carRacing.model.Car;
import racing.carRacing.model.Cars;
import racing.carRacing.model.Count;

import java.util.List;

public class OutputView {
    public static final String MOVEMENT = "-";
    public static final String COMBINER = ", ";

    public static void printResultMention() {
        System.out.println("실행 결과");
    }

    public static void printCarsStatus(Cars cars) {
        for (int i = 0; i < cars.getCarsSize(); i++) {
            Car currentCar = cars.getCurrentCar(i);
            printCarStatus(currentCar);
        }
    }

    private static void printCarStatus(Car car) {
        System.out.print(car.getCurrentCar() + " : ");
        for (int i = 0; i < car.getCurrentPosition(); i++) {
            System.out.print(MOVEMENT);
        }
        System.out.println();
    }

    public static void printRemainStage(Count count) {
        System.out.println("==================");
        System.out.println("남은 회수 :" + count);
    }

    public static void printWinner(List<String> winner) {
        System.out.println();
        System.out.println(String.join(COMBINER, winner) + "가 최종 우승했습니다!");
    }
}
