package com.kakao.racingcar.ui;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    public String inputUserNames() {
        System.out.print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public int inputTryCount() {
        System.out.print("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

}
