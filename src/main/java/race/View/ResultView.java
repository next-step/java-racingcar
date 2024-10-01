package race.View;

import race.vehicle.Car;

import java.util.List;

public class ResultView {
    private static final String EXECUTION = "\n실행 결과";
    private static final String ROUND_SEPERATION = "\n";

    private final List<Car> cars;

    private ResultView(List<Car> cars) {
        this.cars = cars;
    }

    public static void printResultView() {
        System.out.println(EXECUTION);
    }

    public static void seperateRound() {
        System.out.println(ROUND_SEPERATION);
    }

    public static void printCarLocation(String carLocation){
        System.out.println(carLocation);
    }

    public static void pringResult(int round)
    {

    }
}
