package com.rick.racing.ui;

import com.rick.racing.model.RacingPlayData;
import java.util.Scanner;

public class InputView {

    private static final String MESSAGE_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String MESSAGE_TRY_COUNT = "시도할 횟수는 몇 회 인가요?";

    private final Scanner scanner = new Scanner(System.in);

    public RacingPlayData getGameDataFromUser() {
        return new RacingPlayData(getCarCountFromUser(), getTryCountFromUser());
    }

    private int getCarCountFromUser() {
        System.out.println(MESSAGE_CAR_COUNT);
        return getNumber();
    }

    private int getTryCountFromUser() {
        System.out.println(MESSAGE_TRY_COUNT);
        return getNumber();
    }

    private int getNumber() {
        String value = scanner.nextLine();
        return Integer.parseInt(value);
    }
}
