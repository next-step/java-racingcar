package com.mommoo.step2;

import java.util.Scanner;

public class InputView {
    private static final String GUIDE_TEXT_OF_WHAT_COUNT_OF_CAR = "자동차 대수는 몇 대 인가요?";
    private static final String GUIDE_TEXT_OF_WHAT_COUNT_OF_TRYING = "시도할 회수는 몇 회 인가요?";

    private final Scanner SCANNER = new Scanner(System.in);

    public int getCountOfCar() {
        return getIntValue(GUIDE_TEXT_OF_WHAT_COUNT_OF_CAR);
    }

    public int getCountOfTrying() {
        return getIntValue(GUIDE_TEXT_OF_WHAT_COUNT_OF_TRYING);
    }

    private int getIntValue(String guideText) {
        System.out.println(guideText);
        return SCANNER.nextInt();
    }
}
