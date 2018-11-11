package racingGame;

import java.util.ArrayList;

public class RacingGame {
    private static int rCarCnt = 0;
    private static int rAttempCnt = 0;
    private static ArrayList<Car> cars = new ArrayList<>();

    public void gameStart(int carCnt, int attempCnt) {
        gameSet(carCnt, attempCnt);
        carsRun();
    }

    private void gameSet(int carCnt, int attempCnt) {
        System.out.println("자동차 수는 몇 대 인가요?");
        rCarCnt = carCnt;
        System.out.println("시도할 횟수는 몇 회 인가요?");
        rAttempCnt = attempCnt;

        for (int i = 0; i < carCnt; i++) {
            cars.add(new Car());
        }
    }

    private void carsRun() {
        for (int i = 0; i < rAttempCnt; i++) {
            carRunOneTurn();
            System.out.println("");
        }
    }

    private void carRunOneTurn() {
        for (Car car : cars) {
            car.run();
            System.out.println(carDistancePrint(car.getRunDistance()));
        }
    }

    private String carDistancePrint(int carDistance) {
        String printDistance = "";
        for (int i = 0; i < carDistance; i++) {
            printDistance += "-";
        }
        return printDistance;
    }

}
