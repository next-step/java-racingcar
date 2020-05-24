package com.kimdahyeee.racing.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String NAME_SEPARATOR = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String names = scanner.nextLine();

        return getCarNames(names);
    }

    private static List<String> getCarNames(String names) {
        if (names == null || names.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        return Arrays.asList(names.split(NAME_SEPARATOR));
    }

    public static int getTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();

        return tryCount;
    }
}
