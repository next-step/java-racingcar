package racing;

import java.util.*;

public class RacingGame {
    private int time;
    private Random mRand;
    private ArrayList<Car> cars;

    public RacingGame() {
        mRand = new Random();
    }

    private void greeting() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        setNumOfCars(getInput());
        System.out.println("시도할 회수는 몇 회 인가요?");
        setNumOfMove(getInput());
        System.out.println("\n실행 결과");
    }

    private void startRace() {
        for (int i = 0; i < this.time; i++) {
            turn();
        }
    }

    private void turn() {
        for (Car car : cars) {
            car.goOrNot(getRand());

        }

        printCurrentTurn();
    }

    public void printCurrentTurn() {
        for (Car car : cars) {
            System.out.println(car.getMovesRoad());
        }

        System.out.println();
    }

    public static void main(String[] args) {
        RacingGame game = new RacingGame();
        game.race();
    }


    private void race() {
        greeting();

        startRace();

    }

    private int getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private int getRand() {
        return mRand.nextInt(10);
    }


    public int getNumOfCars() {
        return cars.size();
    }

    public void setNumOfCars(int numberOfCars) {
        cars = new ArrayList<>(numberOfCars);

        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
    }

    public int getNumOfMove() {
        return this.time;
    }

    public void setNumOfMove(int numberOfMoves) {
        this.time = numberOfMoves;
    }
}

class Car {
    public int position;

    public Car() {
        position = 0;
    }

    public void goOrNot(int randValue) {
        if (isNotAvailToGo(randValue)) {
            return;
        }

        go();
    }

    public void go() {
        position++;
    }

    public boolean isNotAvailToGo(int randValue) { return !isAvailToGo(randValue); }

    public boolean isAvailToGo(int randValue) {
        return randValue >= 4;
    }

    public String getMovesRoad() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < position; i++ ) {
            builder.append("-");
        }

        return builder.toString();
    }
}