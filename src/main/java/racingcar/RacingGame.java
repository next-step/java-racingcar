package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingGame {
    private int time;
    private List<Car> cars;

    public RacingGame(int time, int numberOfCar) {
        this.time = time;
        this.cars = new ArrayList<>();
        for (int i = 0; i < numberOfCar; i++) {
            cars.add(new Car(i));
        }
    }

    public void play() {
        System.out.println("실행 결과");

        for (int i = 0; i < this.time; i++) {
            moveCars();
            System.out.println(displayCarPositions());
            System.out.println();
        }
    }

    public void moveCars() {
        cars.stream()
                .forEach(it -> it.move(RandomUtils.getRandomNumber(10)));
    }

    public String displayCarPositions() {
        return cars.stream()
                .map(it -> it.displayPosition())
                .collect(Collectors.joining("\n"));
    }

    public int getNumberOfCars() {
        return cars.size();
    }

    public int getTime() {
        return time;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int value = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int number = scanner.nextInt();

        RacingGame game = new RacingGame(value, number);
        game.play();
    }
}