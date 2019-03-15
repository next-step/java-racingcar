package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
    private List<Car> cars;

    public RacingGame(String names) {
        this.cars = new ArrayList<>();

        String[] carNames = names.split(",");
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
    }

    public GameResult play(int time) {
        GameResult result = new GameResult();

        for (int i = 0; i < time; i++) {
            carsMove();
            Round round = new Round(cars);
            result.addRound(round);
        }

        return result;
    }

    private void carsMove() {
        this.cars.stream()
                .forEach(it -> it.move(RandomUtils.getRandomNumber(10)));
    }

    public int getNumberOfCars() {
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
        ResultView.print(result);
    }
}