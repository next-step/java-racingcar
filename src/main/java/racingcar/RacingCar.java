package racingcar;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingCar {
    private static final int RANDOM_BOUND = 10;
    private int carCount;
    private int racingCount;
    private List<Car> cars = new ArrayList<>();
    private Random random;


    private RacingCar(int carCount, int racingCount, Random random) {
        this.carCount = carCount;
        this.racingCount = racingCount;
        this.random = random;

        if (carCount > 0) {
            addCar(carCount);
        }
    }

    public static RacingCar create(int carCount, int racingCount) {
        return new RacingCar(carCount, racingCount, new Random());
    }

    private void addCar(int num) {
        for (int i = 0; i < num; i++) {
            cars.add(new Car(cars.size() + 1));
        }
    }

    public void start() {
        for (int i = 0; i < racingCount; i++) {
            race();
        }
    }

    private void race() {
        for (int i = 0; i < cars.size(); i++) {
            int r = random.nextInt(RANDOM_BOUND);
            cars.get(i).move(r);
            System.out.println("[" + cars.get(i).getId() + "] : " + r + "=> " + cars.get(i).getDistance());
        }
    }

    public int getCarCount() {
        return carCount;
    }

    public int getRacingCount() {
        return racingCount;
    }

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        int carNum = inputView.input("자동차 대수는 몇 대 인가요?");
        int racingNum = inputView.input("시도할 횟수는 몇 회 인가요?");

        RacingCar racingCar = RacingCar.create(carNum, racingNum);
        racingCar.start();

        inputView.close();
    }
}
