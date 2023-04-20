package racingcar.dto;

import java.util.stream.IntStream;

public class UserInput {

    public static final String DELIMITER = ",";
    private final Integer gameRound;
    private String carName;

    public UserInput(Integer gameRound, String carName) {
        validateNegativeNumber(gameRound);
        validateCarName(carName);
        this.gameRound = gameRound;
        this.carName = carName;
    }

    private void validateCarName(String carName) {
        String[] name = carName.split(DELIMITER);
        for (int i = 0; i < name.length; i++) {
            validateLength(name[i]);
        }
    }

    private void validateLength(String name) {
        if (name.trim().length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과 할 수 없습니다");
        }
    }

    public Integer getGameRound() {
        return gameRound;
    }

    public String getCarName() {
        return carName;
    }

    private static void validateNegativeNumber(Integer gameRound) {
        if (gameRound <= 0) throw new IllegalArgumentException("자동차 시도 횟수는 양수만 입력 가능합니다");
    }
}
