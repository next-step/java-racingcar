/*
 * edu.nextstep.racingcarwinner.view.InputView.java
 * 0.1 2021.08.07 18:24
 * 해당 클래스의 경우 TDD, CleanCode with Java 수업의 RacingCar step4에 해당됩니다.
 */

package edu.nextstep.racingcarwinner.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.next();
    }

    public int inputRoundNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        int roundNum = scanner.nextInt();
        System.out.println();
        return roundNum;
    }
}
