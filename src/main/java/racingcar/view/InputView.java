package racingcar.view;

import static racingcar.utils.PrintUtils.print;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import racingcar.dto.GameConfig;

public class InputView {

    private final Scanner sc = new Scanner(System.in);

    private static final String JOIN_CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String NUMBER_OF_GAME_ROUND_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";


    public GameConfig initConfig() {

        print(JOIN_CAR_NAMES_INPUT_MESSAGE);
        List<String> joinCarNames = inputCarNames(sc.next());

        print(NUMBER_OF_GAME_ROUND_INPUT_MESSAGE);
        int numberOfGameRound = sc.nextInt();

        return new GameConfig(joinCarNames, numberOfGameRound);
    }

    public List<String> inputCarNames(String input) {
        String[] joinCarNames = input.split(",");

        for (String carName : joinCarNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
            }
        }

        return Arrays.asList(joinCarNames);
    }
}
