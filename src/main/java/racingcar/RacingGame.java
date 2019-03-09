package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {


    private static final int RULE_COUNT = 10;
    private static final int RUNNABLE_RULE_COUNT = 3;

    private List<Car> carList;
    private int moveCount;

    public RacingGame(int carCount, int moveCount) {
        this.moveCount = moveCount;
        this.carList=setupCar(carCount);
    }


    public List<Car> setupCar(int carCount) {
        carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
        return carList;
    }


    public void startRace() {
        System.out.println("자동차 대수: " +  carList.size() + "\n");
        for (int i = 0; i < moveCount; i++) {
            System.out.println((i+1) + "번쨰횟수");
            for (Car car : carList) {
                run(car);
                System.out.println(printCarDistance(car));
            }

            System.out.println();
        }
    }

    private void run(Car car) {
        Random randomNum = new Random();
        if (randomNum.nextInt(RULE_COUNT) > RUNNABLE_RULE_COUNT) {
            car.moveCar();
        }
    }

    private String printCarDistance(Car car) {
        StringBuilder raceResult = new StringBuilder();
        for (int i = 0; i < car.getMovingDistance(); i++) {
            raceResult.append("-");
        }
        return raceResult.toString();

    }



}
