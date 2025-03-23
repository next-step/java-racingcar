package racing.view;

import java.util.List;
import racing.domain.Car;
import racing.domain.Cars;

public class OutputView {

    public static final String RESULT_LABEL = "실행 결과";

    public static void printResultLabel() {
        System.out.println(RESULT_LABEL);
    }

    public static void printResult(Cars cars) {
        List<Car> carList = cars.getCarList();
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(Integer.parseInt(car.getPosition().toString())));
        }
        System.out.println();
    }

    public static void printWinner(List<Car> winner) {
        for (int i = 0; i < winner.size() - 1; i++) {
            System.out.print(winner.get(i).getName() + ", ");
        }
        System.out.print(winner.get(winner.size() - 1).getName() + "가 최종 우승했습니다.");
    }
}
