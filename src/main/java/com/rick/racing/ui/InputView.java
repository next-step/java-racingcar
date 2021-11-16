package com.rick.racing.ui;

import com.rick.racing.model.CarRacingInfo;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String NAME_SEPERATOR = ",";
    private static final String MESSAGE_TRY_COUNT = "시도할 횟수는 몇 회 인가요?";
    private static final String MESSAGE_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private static final Scanner scanner = new Scanner(System.in);

    public static CarRacingInfo getCarRacingInfo() {
        return CarRacingInfo.create(getCarNamesFromUser(), getTryCountFromUser());
    }

    private static List<String> getCarNamesFromUser() {
        System.out.println(MESSAGE_CAR_NAMES);
        return getCarNames();
    }

    private static int getTryCountFromUser() {
        System.out.println(MESSAGE_TRY_COUNT);
        return getNumber();
    }

    private static int getNumber() {
        String value = scanner.nextLine();
        return Integer.parseInt(value);
    }

    private static List<String> getCarNames() {
        String value = scanner.nextLine();
        String[] splitedNames = value.split(NAME_SEPERATOR);
        return Arrays.asList(splitedNames);
    }
}
