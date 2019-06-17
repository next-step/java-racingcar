package racing.view;

import racing.Car;
import racing.common.Cars;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
    private final static String COLON = " : ";
    private final static int START_NUMBER = 0;
    
    public static void printCarsMoving(List<Car> cars) {
        cars.stream().forEach(ResultView::printCarStatus);
    }
    
    private static void printCarStatus(Car car) {
        String movedRange = "";
        for (int i = START_NUMBER, size = car.getPosition(); i < size; i++) {
            movedRange += "-";
        }
        
        System.out.println(car.getName() + COLON + movedRange);
    }
 
    public void printMovingStatus(Cars cars) {
        cars.getCars().forEach(car -> {
            System.out.print(car.getName() + " : ");
            IntStream.range(0, car.getPosition()).forEach(i -> System.out.print("-"));
            System.out.println();
        });
    }
    
    public void printWinners(String winnerNames) {
        System.out.println(winnerNames + " 가 최종 우승했습니다.");
    }
}
