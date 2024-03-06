package CarRacing;

import java.util.*;

public class CarRacingGame {
    private final RandomGenerator generator;
    final List<Car> cars = new ArrayList<>();

    public CarRacingGame(RandomGenerator generator) {
        this.generator = generator;
    }

    public void startRacing(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int trialCount = scanner.nextInt();

        createCarList(carCount);
        carRacing(trialCount);
    }

    public void carRacing(int trialCount) {
        for (int trial = 0; trial < trialCount; trial++) {
            System.out.println((trial + 1) + "회차 이동");
            raceStart();
            printTrack();
            System.out.println();
        }
    }

    public void createCarList(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    private void raceStart() {
        for (Car car : cars) {
            car.updatePosition(createRandomNumber());
        }
    }

    private int createRandomNumber() {
        return generator.generate();
    }

    private void printTrack() {
        for (Car car : cars) {
            for (int track = 0; track < car.getPosition(); track++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}