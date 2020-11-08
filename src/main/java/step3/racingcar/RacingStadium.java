package step3.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingStadium {
    private Scanner scanner;
    private List<Car> racingCars;

    public RacingStadium() {
        this.scanner = new Scanner(System.in);
        this.racingCars = new ArrayList<>();
    }

    public void run(){
        start();
    }

    private void start() {
        System.out.println("step3 - 자동차 경주");
        enterRacingCars();
        startRacing(prepareRacing());
    }

    private int prepareRacing() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    private void startRacing(int repeatCount) {
        for (int count=0; count < repeatCount; count++) {
            this.racingCars.stream().forEach(racingCar -> {
                racingCar.move();
            });

            System.out.println();
            System.out.println();
        }
    }

    private void enterRacingCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();

        for(int lane=0; lane<carCount; lane++) {
            Car car = new RacingCar(lane);
            car.setMovableStrategy(new RandomStrategy());
            this.racingCars.add(car);
        }
    }
}
