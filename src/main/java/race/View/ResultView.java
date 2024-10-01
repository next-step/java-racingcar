package race.View;

import race.vehicle.Car;

import java.util.List;

public class ResultView {
    private static final String EXECUTION = "\n실행 결과";
    private static final String ROUND_SEPERATION = "\n";

    private static List<Car> cars;

    public ResultView(List<Car> cars) {
        this.cars = cars;
    }

    public static void printResultView() {
        System.out.println(EXECUTION);
    }

    public static void seperateRound() {
        System.out.println(ROUND_SEPERATION);
    }

    public static void printResult(int round)
    {
        printResultView();
        for(int i=0;i<round;i++)
        {
            for (Car car : cars) {
                car.move();
                System.out.println(car.getLocation());
            }
            seperateRound();
        }
    }

}
