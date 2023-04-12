package study.racing.view;

import study.racing.domain.Car;

import java.util.List;

public class ResultView {
    private static ResultView instance = null;

    // 우승한 자동차를 출력
    public static String displayWinningCars(List<Car> winningCars) {
        return displayCarsNames(winningCars) + "가 최중 우승했습니다.";
    }

    // 자동차 이름을 출력
    public static String displayCarsNames(List<Car> cars) {
        if (cars.isEmpty()) {
            return "";
        }

        String result = "";
        for (Car car : cars) {
            result += car.getName() + ", ";
        }
        return result.substring(0, result.length() - 2);
    }

    // 경기중인 자동차를 출력
    public static String getStatusCars(List<Car> racingCars) {
        String status = "";
        for (Car racingCar : racingCars) {
            status += getStatus(racingCar);
        }
        return status;
    }

    public static String getStatus(Car car) {
        String status = "";
        status += car.getName() + " : ";
        for (int i = 0; i < car.getCurrentLocation(); i++) {
            status += "-";
        }
        status += "\n";
        return status;
    }

    public static ResultView getInstance() {
        if (instance == null) {
            instance = new ResultView();
        }
        return instance;
    }

    private ResultView() {
    }
}
