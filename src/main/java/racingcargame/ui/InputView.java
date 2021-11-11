/*
 * InputView
 *
 * version 1.0
 *
 * 2021-11-09
 *
 * 저작권 nextstep
 */

package racingcargame.ui;

import java.util.Scanner;

public class InputView {
    private static final String READ_CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String READ_TRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private final Scanner scanner = new Scanner(System.in);

    public int readCarCount() {
        System.out.println(READ_CAR_COUNT_MESSAGE);
        return scanner.nextInt();
    }

    public int readTryCount() {
        System.out.println(READ_TRY_COUNT_MESSAGE);
        return scanner.nextInt();
    }
}
