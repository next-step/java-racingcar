/*
 * InputView.java *
 * v_0.1 *
 * 2021/7/26 *
 *
 * [저작권 및 라이센스 관련 정보를 여기 작성]
 * Copyright (c) 2021 Younhwan Son.
 */
package edu.nextstep.racingcar.view;

import java.util.Scanner;

public class InputView {

    private InputView() {}

    private static Scanner scanner = new Scanner(System.in);

    public static int inputCarNum() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public static int inputMoveNum() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
