package racingcar.model;

import com.google.common.base.Strings;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static racingcar.model.RacingGame.MIN_ROUND;


public class GameRequest {

    static final String NAMES_DELIMITER = ",";
    static final String REGEX_NAMES_PATTERN = "^[가-힣\\w]+(,[가-힣\\w]+)*$";
    private static Pattern pattern = Pattern.compile(REGEX_NAMES_PATTERN);

    private int inputOfRound;
    private List<String> names;

    private GameRequest(int inputOfRound, List<String> names) {
        this.inputOfRound = inputOfRound;
        this.names = names;
    }

    public static GameRequest valueOf(int inputOfRound, String inputOfCarNames) {
        validateMinRound(inputOfRound);
        validateCarNames(inputOfCarNames);
        return new GameRequest(inputOfRound, parseNames(inputOfCarNames));
    }

    private static List<String> parseNames(String inputOfCarNames) {
        return Arrays.stream(inputOfCarNames.split(NAMES_DELIMITER))
                .collect(Collectors.toList());
    }

    private static void validateMinRound(int inputOfRound) {
        if (inputOfRound < MIN_ROUND) {
            throw new IllegalArgumentException(String.format("실행 횟수는 %d보다 커야합니다.", MIN_ROUND));
        }
    }

    private static void validateCarNames(String names) {
        if (names == null || names.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 문자열 입니다");
        }
        if (!pattern.matcher(names).matches()) {
            throw new IllegalArgumentException(String.format("잘못된 입력입니다. 구분자: %s", NAMES_DELIMITER));
        }
    }

    public int getInputOfRound() {
        return inputOfRound;
    }

    public List<String> getNames() {
        return names;
    }
}
