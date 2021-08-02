package race.view;

import race.Car;
import race.Cars;

import java.util.List;

import static java.lang.System.out;

public class ResultView {

    private static ResultView resultView;
    private static int HIGH_DISTANCE = -1;

    public static synchronized ResultView getInstance() {
        if(resultView == null) {
            return new ResultView();
        }
        return resultView;
    }

    public void operate(Cars cars, int finalTryCount) {
        out.println("실행 결과");
        printCarsByRound(cars.getCars(), finalTryCount);
        printWinner(cars);
    }

    private void printWinner(Cars cars) {
        String winners = cars.getWinner(HIGH_DISTANCE);
        out.println(winners + "가 최종 우승했습니다.");
    }

    private void printCarsByRound(List<Car> cars, int finalTryCount) {
        for (int tryCount = 0; tryCount <= finalTryCount; tryCount++) {
            printCars(cars, tryCount);
            out.println();
        }
    }

    private void printCars(List<Car> cars, int tryCount) {
        for (Car car : cars) {
            printCar(car, tryCount);
        }
    }

    private void printCar(Car car, int tryCount) {
        String carName = car.getName();
        int distance = car.getDistance(tryCount);

        if (isHighDistance(distance)) {
            HIGH_DISTANCE = distance;
        }

        out.print(carName + " : ");
        out.print("-");
        for (int i = 0; i < distance; i++) {
            out.print("-");
        }
        out.println();
    }

    private boolean isHighDistance(int distance) {
        return HIGH_DISTANCE < distance;
    }

    private ResultView() {

    }

}
