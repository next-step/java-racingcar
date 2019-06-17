package com.jaeyeonling.racingcar.view;

import java.util.Scanner;

public final class ConsoleInputView {

    private static final String READ_NAME_OF_PARTICIPANTS_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String READ_MOVE_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private static final Scanner reader = new Scanner(System.in);

    private ConsoleInputView() { }

    public static String readNameOfParticipants() {
        return readStringWithMessage(READ_NAME_OF_PARTICIPANTS_MESSAGE);
    }

    public static int readMoveCount() {
        return readIntWithMessage(READ_MOVE_COUNT_MESSAGE);
    }


    private static String readString() {
        return reader.nextLine();
    }

    private static String readStringWithMessage(final String message) {
        ConsoleResultView.show(message);
        return readString();
    }

    private static int readInt() {
        return reader.nextInt();
    }

    private static int readIntWithMessage(final String message) {
        ConsoleResultView.show(message);
        return readInt();
    }
}
