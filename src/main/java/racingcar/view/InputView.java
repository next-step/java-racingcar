package racingcar.view;


import racingcar.domain.InputReq;

import java.util.Scanner;

public class InputView {

    public static InputReq getInputData() {
        InputReq inputReq = new InputReq();
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        inputReq.setCarNames(scanner.nextLine());
        System.out.println("시도할 회수는 몇 회 인가요?");
        inputReq.setMoveCount(Integer.parseInt(scanner.nextLine()));

        return inputReq;
    }


}
