package step3.racingcar;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputViewProcessor {
    private static final String CAR_COUNTS_INSTRUCTION = "자동차 대수는 몇 대 인가요?";
    private static final String GAME_TRY_COUNTS_INSTRUCTION = "시도할 회수는 몇 회 인가요?";
    private static final String ERROR_MESSAGE = "ERROR : 입력 숫자는 1 이상이어야 합니다.";

    private InputViewProcessor() {
    }

    public static Map<String, Integer> getUserInputMap() {
        Map<String, Integer> userInputMap = new HashMap<>();
        int carCounts = getUserInput(CAR_COUNTS_INSTRUCTION);
        int gameTryCounts = getUserInput(GAME_TRY_COUNTS_INSTRUCTION);
        userInputMap.put(UserInputMapKey.CAR_COUNTS.getKey(), carCounts);
        userInputMap.put(UserInputMapKey.GAME_TRY_COUNTS.getKey(), gameTryCounts);
        return userInputMap;
    }

    private static int getUserInput(String instructionMessage) {
        System.out.println(instructionMessage);
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        scanner.close();
        validateUserInput(userInput);
        return userInput;
    }

    public static void validateUserInput(int userInput) {
        if (userInput <= 0)
            throw new IllegalArgumentException(ERROR_MESSAGE);
    }
}
