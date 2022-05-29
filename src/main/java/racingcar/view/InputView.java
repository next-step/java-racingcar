package racingcar.view;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    
    public Cars enterCarNames() {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분)\n");
        Cars cars = new Cars(scanner.nextLine());
        return cars;
    }

    public void enterNumberOfGames(Cars cars) {
        System.out.print("시도할 횟수는 몇 회 인가요?");
        RacingGame racingGame = new RacingGame(cars, scanner.nextInt());
    }
}
