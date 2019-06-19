package com.mommoo.step2;

import java.util.Scanner;

public class InputView {
    private static final String GUIDE_TEXT_OF_NAMING_OF_CAR = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분";
    private static final String GUIDE_TEXT_OF_WHAT_COUNT_OF_TRYING = "시도할 회수는 몇 회 인가요?";

    private final Scanner SCANNER = new Scanner(System.in);

    public String[] getCarNames() {
        System.out.println(GUIDE_TEXT_OF_NAMING_OF_CAR);
        String inputCarNames = SCANNER.nextLine();
        return inputCarNames.split(",");
    }

    public int getCountOfTrying() {
        System.out.println(GUIDE_TEXT_OF_WHAT_COUNT_OF_TRYING);
        return SCANNER.nextInt();
    }
}
