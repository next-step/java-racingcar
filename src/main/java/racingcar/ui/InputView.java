package racingcar.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

import static racingcar.domain.RacingGameConstant.*;

public class InputView {

    private List<String> carNames;
    private int time;

    public InputView() {
        this.carNames = requestCarNames();
        this.time = requestTime();
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getTime() {
        return time;
    }

    private List<String> requestCarNames() {
        System.out.println(REQUEST_CAR_NAME_MESSAGE);
        return parseCarNames();
    }

    private int requestTime() {
        System.out.println(REQUEST_TRY_TIME_MESSAGE);
        return parseTime();
    }

    private List<String> parseCarNames() {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        if (isEmpty(value)) {
            System.out.println(IS_NOT_NULL);
            requestCarNames();
        }
        if (!COMMA_PATTERN.matcher(value).find()) {
            throw new IllegalArgumentException(IS_NOT_A_COMMA);
        }

        return Arrays.stream(value.split(DELIMITER_COMMA))
                .collect(Collectors.toList());
    }

    private int parseTime() {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IS_NOT_A_NUMBER);
        }
    }

    private boolean isEmpty(String value) {
        return Objects.isNull(value) || NULL_BLANK.equals(value);
    }

}
