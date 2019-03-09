package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

//    private int time;
//    private int[] carPositions = {0, 0, 0};


//    public int[] move() {
//
//    }

    private static final int RULE_COUNT = 10;
    private static final int RUNNABLE_RULE_COUNT = 3;


    private List<Car> carList;



    public void setGame(int carCount, int moveCount) {
        RacingGame racingGame = new RacingGame();
        racingGame.setupCar(carCount);
        printRace(moveCount, racingGame);
    }



    public void setupCar(int carCount) {
        this.carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    private void run(Car car) {
        Random randomNum = new Random();
        if (randomNum.nextInt(RULE_COUNT) > RUNNABLE_RULE_COUNT) {
            car.moveCar();
        }
    }

    private String carRaceResult(Car car) {
        StringBuffer raceResult = new StringBuffer();
        for (int i = 0; i < car.getMovingDistance(); i++) {
            raceResult.append("-");
        }
        return String.valueOf(raceResult);

    }

    private void printRace(int moveCount, RacingGame racingGame) {
        List<Car> carList = racingGame.getCarList();
        System.out.println("자동차 대수: " +  carList.size() + "\n");
        for (int i = 0; i < moveCount; i++) {
            System.out.println((i+1) + "번쨰횟수");
            for (Car car : carList) {
                racingGame.run(car);
                System.out.println(racingGame.carRaceResult(car));
            }

            System.out.println();
        }
    }



}
