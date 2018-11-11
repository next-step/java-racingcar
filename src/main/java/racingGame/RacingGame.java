package racingGame;

import java.util.ArrayList;

public class RacingGame {
    private static int rAttempCnt = 0;
    private ArrayList<Car> cars = new ArrayList<>();

    public void gameStart(String[] carsName, int attempCnt) throws RuntimeException {
        gameSet(carsName, attempCnt);
        carsRun();
        printWinners(getWinners());
    }

    private void gameSet(String[] carsName, int attempCnt) {
        System.out.println("자동차 수는 몇 대 인가요?");
        System.out.println(carsName.length);

        System.out.println("시도할 횟수는 몇 회 인가요?");
        rAttempCnt = attempCnt;
        System.out.println(rAttempCnt);
        System.out.println();

        for (String carName : carsName) {
            this.cars.add(new Car.Builder().carName(carName).build());
        }
    }

    private void carsRun() {
        for (int i = 0; i < rAttempCnt; i++) {
            carRunOneTurn();
            System.out.println();

        }
    }

    private void carRunOneTurn() {
        for (Car car : cars) {
            car.run();
            System.out.println(car);
        }
    }

    private ArrayList<Car> getWinners() throws RuntimeException {
        if (cars.size() <= 0) {
            throw new RuntimeException();
        }

        int winnerDistance = cars.get(0).getRunDistance();
        ArrayList<Car> winnerCars = new ArrayList<>();

        for (Car car : this.cars) {
            winnerDistance = getWinDistance(winnerDistance, car);
        }

        for (Car car : this.cars) {
            getWinnerCars(winnerDistance, winnerCars, car);
        }

        return winnerCars;
    }

    private void getWinnerCars(int winnerDistance, ArrayList<Car> winnerCars, Car car) {
        if (winnerDistance == car.getRunDistance()) {
            winnerCars.add(car);
        }
    }

    private int getWinDistance(int winDistance, Car car) {
        if (winDistance < car.getRunDistance()) {
            winDistance = car.getRunDistance();
        }
        return winDistance;
    }

    private void printWinners(ArrayList<Car> winnerCars) {
        for (int i = 0; i < winnerCars.size(); i++) {
            System.out.printf(winnerCars.get(i).getCarName());
            System.out.printf(i < winnerCars.size() - 1 ? ", " : "");
        }
        System.out.println("가 최종 우승했습니다.");
    }

}
