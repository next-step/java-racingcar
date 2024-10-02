package race.View;

import race.vehicle.Car;

import java.util.List;

public class ResultView {
    private static final String EXECUTION = "\n실행 결과";
    private static final String ROUND_SEPARATION = "\n";

    private final List<Car> cars;

    public ResultView(List<Car> cars) {
        this.cars = cars;
    }

    private void printResultView() {
        System.out.println(EXECUTION);
    }

    private void separateRound() {
        System.out.print(ROUND_SEPARATION);
    }

    public void printResult(int round)
    {
        printResultView();
        for(int i=0;i<round;i++)
        {
            for (Car car : cars) {
                car.move();
                System.out.println(car.getLocation());
            }
            separateRound();
        }
    }

}
