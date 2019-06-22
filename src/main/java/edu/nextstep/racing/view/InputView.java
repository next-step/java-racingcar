package edu.nextstep.racing.view;

import java.util.Scanner;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-22 15:04
 */
public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static String inputCars() {
        printMessage("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String playerNames = scanner.nextLine();

        return playerNames;
    }

    public static int inputRound() {
        printMessage("시도할 회수는 몇회인가요?");
        String round = scanner.nextLine();

        return Integer.parseInt(round);
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}
