package edu.nextstep.raing.view;

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

    public int[] setNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("자동차 대수는 몇대 인가요?");
        int car = Integer.parseInt(sc.nextLine());
        System.out.println("시도할 회수는 몇 회 인가요?");
        int move = Integer.parseInt(sc.nextLine());
        sc.close();

        int[] number = new int[2];
        number[0] = car;
        number[1] = move;

        return number;
    }
}
