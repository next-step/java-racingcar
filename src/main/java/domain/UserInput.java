package domain;

import java.util.stream.IntStream;

public class UserInput {

    private final String[] namesForCars;
    private final int attemptCount;
    private static final String[] INVALID_NAME_INPUTS = {"\t", "\n", ""};
    static final String EMPTY_NAME_ERROR_MESSAGE = "빈 값을 입력하시면 안됩니다.";
    static final String LESS_THAN_ONE_ERROR_MESSAGE = "0 보다 큰 정수만 입력 가능합니다.";
    static final String MORE_THAN_FIVE_WORD_ERROR_MESSAGE = "이름은 다섯 글자 이내로 생성해주세요";
    static final int NAME_LENGTH_LIMIT = 5;

    public UserInput(String inputNames, int attemptCount) {
        String[] names = validateUserInput(inputNames, attemptCount);
        this.namesForCars = names;
        this.attemptCount = attemptCount;
    }

    private static String[] validateUserInput(String inputNames, int attemptCount) {
        isNotEmptyNames(inputNames);
        String[] names = inputNames.split(",");
        isNotMoreThanFiveWord(names);
        isOverOne(attemptCount);
        return names;
    }


    private static void isNotEmptyNames(String inputNames) {
        if (IntStream.range(0, INVALID_NAME_INPUTS.length)
                .anyMatch(i -> INVALID_NAME_INPUTS[i].equals(inputNames))) {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR_MESSAGE);
        }
    }

    private static void isNotMoreThanFiveWord(String[] names) {
        if (IntStream.range(0, names.length)
                .anyMatch(i -> names[i].length() > NAME_LENGTH_LIMIT)) {
            throw new IllegalArgumentException(MORE_THAN_FIVE_WORD_ERROR_MESSAGE);
        }
    }

    public static void isOverOne(int attemptCount) {
        if (attemptCount <= 0) {
            throw new IllegalArgumentException(LESS_THAN_ONE_ERROR_MESSAGE);
        }
    }

    public int getNumbersOfCar() {
        return namesForCars.length;
    }

    public String[] getNamesForCars() {
        return namesForCars;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
