/*
 * InputView.java  1.0.0   2019.10.27
 */
package step2.view;

import step2.dto.RacingData;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 자동차 게임 사용자 입력 부분
 *
 * @author naheenosaur
 * @version 1.0.0
 */
public class InputView {
    private static final String CAR_MODELS_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TURN_COUNT_QUESTION = "시도할 회수는 몇 회 인가요?";
    private static final String DELIMITER = ",";
    private static Scanner scanner = new Scanner(System.in);

    public static RacingData input() {
        String[] carModels = inputCarModels();
        int turn = inputGameTurns();
        return new RacingData(carModels, turn);
    }

    private static String[] inputCarModels() {
        System.out.println(CAR_MODELS_QUESTION);
        String answer = scanner.nextLine();
        return Stream.of(answer.trim().split(DELIMITER))
                .map(String::trim).toArray(String[]::new);
    }

    private static int inputGameTurns() {
        System.out.println(TURN_COUNT_QUESTION);
        return scanner.nextInt();
    }
}
