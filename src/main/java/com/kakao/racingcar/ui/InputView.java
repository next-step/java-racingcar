package com.kakao.racingcar.ui;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    public int inputCarTotal() {
        System.out.print("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public int inputTryCount() {
        System.out.print("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

}
