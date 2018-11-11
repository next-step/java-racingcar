package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {

    public static void print(List<Car> cars) {
        String str = "";
        for(Car car : cars) {
            str += car.getName() + " : " + getString(car) + "\n";
        }
        System.out.print(str);
    }
    private static String getString(Car car) {
        String str = "";
        for(int i=0; i<car.getCurPosition(); i++) {
            str += "-";
        }
        return str;
    }
    public static String printWinner(List<Car> cars, int winnerNum) {
        String name = "";
        for(Car car : cars) {
            name += createWord(winnerNum, car);
        }
        return name.substring(0, name.length()-2);
    }
    private static String createWord(int max, Car car) {
        if(car.findWinner(max) == "") {
            return "";
        }
        return car.getName() + ", ";
    }
}
