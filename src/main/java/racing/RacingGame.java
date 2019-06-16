package racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
    private ArrayList<Car> cars;
    private int time;
    private Random mRand;

    public RacingGame() {
        mRand = new Random();
    }

    private void greeting() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        setNumOfCars(getInput());
        System.out.println("시도할 회수는 몇 회 인가요?");
        setNumOfMove(getInput());
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

    public List<Integer> move() {
        // TODO 구현
        return Collections.emptyList();
    }

    private int getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public boolean checkGoOrNot(int randValue) {
        return randValue >= 4;
    }

    private int getRand() {
        return mRand.nextInt(10);
    }

    public static void main(String[] args) {
        RacingGame game = new RacingGame();
        game.greeting();
    }

}

class Car {
    public int position;

    public Car() {
        position = 0;
    }
}