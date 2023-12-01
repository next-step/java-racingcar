package racinggame.view;

import racinggame.dto.RacingInputDTO;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int MAX_RACING_ROUND_COUNT = 9;
    private static final int NON_NEGATIVE_CHECK = 0;

    private InputView() {
    }

    public static RacingInputDTO printRequestGameValue() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carName = scanner.nextLine();
        List<String> carNames = Arrays.asList(carName.split(","));

        System.out.println("시도할 회수는 몇회인가요?");
        String gameCountString = scanner.nextLine();
        try {
            validateInputGameCount(gameCountString);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return printRequestGameValue();
        }

        return new RacingInputDTO(carNames, Integer.parseInt(gameCountString));
    }

    public static void validateInputGameCount(String gameCountString) {
        int gameCount;
        try {
            gameCount = Integer.parseInt(gameCountString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("게임 시도 횟수는 숫자만 입력할 수 있습니다.");
        }

        if (gameCount <= NON_NEGATIVE_CHECK) {
            throw new IllegalArgumentException("게임 시도 횟수는 음수 및 0은 입력할 수 없습니다.");
        }

        if (gameCount > MAX_RACING_ROUND_COUNT) {
            throw new IllegalArgumentException("게임 시도 횟수는 최대 10번만 가능 합니다.");
        }
    }
}
