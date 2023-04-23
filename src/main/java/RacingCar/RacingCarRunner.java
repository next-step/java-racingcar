package RacingCar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarRunner {
    public static void main(String[] args) {
        InputManager im = new InputManager();

        System.out.println("자동차 대수는 몇 대 인가요?");
        int numOfCars = im.getUserInput();

        System.out.println("시도할 횟수는 몇 회 인가요?");
        int raceCount = im.getUserInput();

        // 자동차
        List<Car> cars = new ArrayList<>();
        for (int i = 1; i <= numOfCars; i++) {
            cars.add(new Car(i));
        }

        // 자동차 경주 실행 로직
        List<RacingCarRunnable> racingCarRunnables = new ArrayList<>();
        for (Car car : cars) {
            RacingCarRunnable racingCarRunnable = new RacingCarRunnable(car, raceCount);
            racingCarRunnables.add(racingCarRunnable);
        }

        // 결과 출력
        for (int i = 1; i <= raceCount; i++) {
            System.out.println("\n" + "[" +  i + "회 경주 결과]");
            for (RacingCarRunnable racingCarRunnable : racingCarRunnables) {
                racingCarRunnable.run();
                racingCarRunnable.printRacingCarResult();
            }
        }
    }
}
