package carRacing;

import carRacing.car.Cars;
import carRacing.common.RandomGenerator;
import carRacing.common.RandomGeneratorImpl;
import carRacing.race.RacingGame;
import carRacing.race.RacingGameUI;
import carRacing.race.RacingGameUiImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class RacingGameApplication {
    public static void main(String[] args) throws Exception {

        RandomGenerator randomGenerator = new RandomGeneratorImpl();
        Cars cars = Cars.of(new ArrayList<>());
        RacingGameUI ui = new RacingGameUiImpl();
        RacingGame racingGame = RacingGame.of(randomGenerator,cars,ui);


        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = scanner.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int trialCount = scanner.nextInt();

        racingGame.startRacing(carNames, trialCount);

        scanner.close();
    }
}
