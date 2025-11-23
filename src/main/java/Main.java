import model.CarRacingGame;
import model.Cars;

import java.util.Scanner;

public class Main {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String CAR_MOVE_COUNT_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String GAME_RESULT_MESSAGE = "\n실행 결과";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CarRacingGame carRacingGame = new CarRacingGame();

        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String carNames = scanner.nextLine();

        Cars cars = new Cars(carNames);

        System.out.println(CAR_MOVE_COUNT_INPUT_MESSAGE);
        int tryCount = scanner.nextInt();
        System.out.println(GAME_RESULT_MESSAGE);
        carRacingGame.race(tryCount, cars.getCars());
    }
}
