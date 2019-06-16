package racing.view;

import racing.Car;

import java.util.List;

public class ResultView {
    private final static String COLON = " : ";
    private final static int START_NUMBER = 0;
    
    public static void printCarsMoving(List<Car> cars) {
        cars.stream().forEach(car -> printCarStatus(car));
    }
    
    private static void printCarStatus(Car car) {
        String movedRange = "";
        for (int i = START_NUMBER, size = car.getPosition(); i < size; i++) {
            movedRange += "-";
        }
        
        System.out.println(car.getName() + COLON + movedRange);
    }
}
