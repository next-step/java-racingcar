package racingcar;

import java.util.List;

public class DisplayView {
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
}
