package racingcar.ui;

import racingcar.domain.RacingGameConstant;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

    private static final Pattern COMMA_PATTERN = Pattern.compile("(?:,|$)");

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
        System.out.println(RacingGameConstant.REQUEST_CAR_NAME_MESSAGE);
        return parseCarNames();
    }

    private int requestTime() {
        System.out.println(RacingGameConstant.REQUEST_TRY_TIME_MESSAGE);
        return parseTime();
    }

    private String[] parseCarNames() {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        if (isEmpty(value)) {
            System.out.println(RacingGameConstant.IS_NOT_NULL);
            requestCarNames();
        }
        if (!COMMA_PATTERN.matcher(value).find()) {
            throw new IllegalArgumentException(RacingGameConstant.IS_NOT_A_COMMA);
        }
        String[] splitWithComma = value.split(RacingGameConstant.DELIMITER_COMMA);
        return splitWithComma;
    }

    private int parseTime() {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(RacingGameConstant.IS_NOT_A_NUMBER);
        }
    }

    private boolean isEmpty(String value) {
        return Objects.isNull(value) || "".equals(value);
    }

}
