package racingcar.ui;

import java.util.Objects;
import java.util.Scanner;

import static racingcar.domain.RacingGameConstant.*;

public class InputView {

    private String[] carNames;
    private int time;

    public InputView() {
        this.carNames = requestCarNames();
        this.time = requestTime();
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int getTime() {
        return time;
    }

    private String[] requestCarNames() {
        System.out.println(REQUEST_CAR_NAME_MESSAGE);
        return parseCarNames();
    }

    private int requestTime() {
        System.out.println(REQUEST_TRY_TIME_MESSAGE);
        return parseTime();
    }

    private String[] parseCarNames() {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        if (isEmpty(value)) {
            System.out.println(IS_NOT_NULL);
            requestCarNames();
        }
        if (!COMMA_PATTERN.matcher(value).find()) {
            throw new IllegalArgumentException(IS_NOT_A_COMMA);
        }
        String[] splitWithComma = value.split(DELIMITER_COMMA);
        return splitWithComma;
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
