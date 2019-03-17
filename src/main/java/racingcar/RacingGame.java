package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> cars;

    RacingGame(String names) {
        this.cars = Arrays.stream(names.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    GameResult play(int time) {
        GameResult result = new GameResult();

        for (int i = 0; i < time; i++) {
            this.cars = move(cars);
            result.addRound(new Round(this.cars));
        }

        return result;
    }

    private List<Car> move(List<Car> cars) {
        return cars.stream()
                .map(it -> it.move(RandomUtils.getRandomNumber(10)))
                .collect(Collectors.toList());
    }

    int getNumberOfCars() {
        return cars.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = scanner.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int time = scanner.nextInt();

        RacingGame game = new RacingGame(carNames);
        GameResult result = game.play(time);
        ResultView.printTraces(result);
        ResultView.printWinner(result);
    }
}