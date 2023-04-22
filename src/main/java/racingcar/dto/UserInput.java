package racingcar.dto;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class UserInput {

    public static final String DELIMITER = ",";
    private final Integer gameRound;
    // private String carName;
    private List<String> carNames = new ArrayList<>();

    public UserInput(Integer gameRound, String names) {
        validateNegativeNumber(gameRound);
        splitCarName(names);
        this.gameRound = gameRound;
    }

    private void splitCarName(String names) {
        String[] name = names.split(DELIMITER);
        for (int i = 0; i < name.length; i++) {
            carNames.add(name[i]);
        }
    }

    public Integer getGameRound() {
        return gameRound;
    }

    public List<String> getCarNames() {
        return this.carNames;
    }

    private static void validateNegativeNumber(Integer gameRound) {
        if (gameRound <= 0) throw new IllegalArgumentException("자동차 시도 횟수는 양수만 입력 가능합니다");
    }
}
