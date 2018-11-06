package domain;

import domain.Car;

import java.util.List;

public class CarResult {

    public static String getRaceWinners(List<Car> cars) {
        int max = getMaxPosition( cars);

        return getWinners(cars, max);
    }

    public static String getWinners(List<Car> cars, int max) {
        String result = "";
        for(Car car : cars){
            result += car.getWinner(max);
        }
        return printWinners(result);
    }

    public static String printWinners(String result) {
        if(result.length() > 0) {
            result = result.substring(0, result.length() - 1);
            result += "가 최종 우승했습니다.";
        }
        System.out.println(result);
        return result;
    }

    public static int getMaxPosition(List<Car> cars) {
        int max = 0;
        for(Car car : cars){
            max = car.getMaxPosition(max);
        }
        return max;
    }
}
