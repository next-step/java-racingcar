package racingcar;

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

    public static void printWinner(List<Car> cars) {
        int max = getWinnerNum(cars);
        String name = "";
        for(Car car : cars) {
            name = createWord(max, name, car);
        }
        name = name.substring(0, name.length()-2);
        System.out.println(name + "가 최종 우승했습니다.");
    }

    private static String createWord(int max, String name, Car car) {
        if(car.findWinner(max) != "") {
            name += car.findWinner(max) + ", ";
        }
        return name;
    }

    private static int getWinnerNum(List<Car> cars) {
        int max = 0;
        for(Car car : cars) {
            max = car.compareNum(max);
        }
        return max;
    }
}
