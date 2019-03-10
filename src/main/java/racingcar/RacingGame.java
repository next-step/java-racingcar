package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> cars;

    public RacingGame(int numberOfCar) {
        this.cars = new ArrayList<>();

        for (int i = 0; i < numberOfCar; i++) {
            cars.add(new Car(i));
        }
    }

    public GameResult play(int time) {
        GameResult result = new GameResult();

        for (int i = 0; i < time; i++) {
            List<Integer> positions = positionsAfterCarsMove(cars);
            Round round = new Round(positions);
            result.addRound(round);
        }

        return result;
    }

    List<Integer> positionsAfterCarsMove(List<Car> cars) {
        return cars.stream()
                .mapToInt(it -> it.move(RandomUtils.getRandomNumber(10)))
                .boxed()
                .collect(Collectors.toList());
    }

    public int getNumberOfCars() {
        return cars.size();
    }

    public List<Car> getCars() {
        return cars;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCar = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int time = scanner.nextInt();

        RacingGame game = new RacingGame(numberOfCar);
        GameResult result = game.play(time);
        ResultView.print(result);
    }
}