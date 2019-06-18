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
 * create date  : 2019-06-15 21:17
 */
public class InputView {

    private Scanner scanner = new Scanner(System.in);

    public int setCarNumber() {
        System.out.println("자동차 대수는 몇대 인가요?");
        return scanner.nextInt();
    }

    public int setMoveNumber() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();

    }
}
