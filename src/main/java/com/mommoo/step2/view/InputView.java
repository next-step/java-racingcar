package com.mommoo.step2.view;

import java.util.Scanner;

public class InputView {
    private static final String GUIDE_TEXT_OF_NAMING_OF_CAR = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분";
    private static final String GUIDE_TEXT_OF_WHAT_COUNT_OF_TRYING = "시도할 회수는 몇 회 인가요?";

    private InputView() {
        /* prevent creating instance */
    }

    public static String[] getCarNames() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(GUIDE_TEXT_OF_NAMING_OF_CAR);

        String inputCarNames = scanner.nextLine();
        return inputCarNames.split(",");
    }

    public static int getCountOfTrying() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(GUIDE_TEXT_OF_WHAT_COUNT_OF_TRYING);

        return scanner.nextInt();
    }
}
