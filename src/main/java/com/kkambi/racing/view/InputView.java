package com.kkambi.racing.view;

import java.util.Scanner;

public class InputView {

    private static final String QUESTION_CAR_NAME_LIST = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String QUESTION_NUMBER_OF_TRIES = "시도할 회수는 몇 회인가요?";

    public String[] getCarNameList() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(QUESTION_CAR_NAME_LIST);
        return scanner.nextLine().split(",");
    }

    public int getNumberOfTries() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(QUESTION_NUMBER_OF_TRIES);
        return scanner.nextInt();
    }
}
