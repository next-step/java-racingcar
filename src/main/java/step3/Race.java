package step3;

import java.util.ArrayList;

public class Race {

    public static void result(ArrayList<Car> cars, int raceCount) {
        while (raceCount > 0) {
            for(Car car: cars){
                int speed = car.speed();
                car.move(speed);

                int distance = car.getDistance();
                getCarLocation(distance);
            }
            raceCount--;
            System.out.println();
        }
    }

    private static void getCarLocation(int distance) {
        while (distance > 0) {
            System.out.print("-");
            distance--;
        }
        System.out.println();
    }

}
