package study;

import java.util.List;

public class ResultView {

    // 우승한 자동차를 출력
    public static String displayWinningCars(List<Car> winningCars) {
        return displayCarsNames(winningCars) + "가 최중 우승했습니다.";
    }

    // 자동차 이름을 출력
    public static String displayCarsNames(List<Car> cars) {
        if(cars.isEmpty()){
            return "";
        }

        String result = "";
        for (Car car : cars) {
            result += car.getName() + ", ";
        }
        return result.substring(0, result.length()-2);
    }

    // 경기중인 자동차를 출력
    public static String displayRacingCars(List<Car> racingCars) {
        String result = "";
        for (Car racingCar : racingCars) {
            result += racingCar.displayCurrentStatus();
        }
        return result;
    }
}
