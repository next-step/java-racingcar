package com.nextstep.racingcargame.view;

import com.nextstep.racingcargame.core.ClientResponse;
import java.util.Scanner;

public class QuestionView {

    private static final String CAR_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_QUESTION = "시도할 횟수는 몇 회 인가요?";

    public static ClientResponse clientQuestion() {
        Scanner scanner = new Scanner(System.in);

        printText(CAR_QUESTION);
        String carNameClientInput = scanner.next();

        printText(TRY_QUESTION);
        int tryCount = scanner.nextInt();

        return new ClientResponse(carNameClientInput, tryCount);
    }

    private static void printText(String printValue) {
        System.out.println(printValue);
    }

}
