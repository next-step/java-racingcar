package racing.io;

import racing.model.Car;

import java.util.List;

public class OutputView {

    public static void view(List<Car> cars) {
        cars.forEach(OutputView::printForCount);
        System.out.println();
    }

    private static void printForCount(Car car) {
        System.out.println(car.getName() + ":" + new String(new char[car.getPosition()]).replace("\0", "-"));
    }

    public static void showWinner(String carNames) {
        System.out.println(carNames + "가 최종 우승 하였습니다.");
    }
}
