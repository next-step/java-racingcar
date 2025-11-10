package step3;

import java.util.List;

public class ResultView {

    public static void race(List<Car> cars, int number){
        for (int i = 0; i < number; i++) {
            for (Car car : cars) {
                    Car.run(car);
                System.out.println(car.getRun());
            }
            System.out.println();
        }
    }
}
