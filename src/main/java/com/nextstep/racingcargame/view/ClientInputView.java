package com.nextstep.racingcargame.view;

import com.nextstep.racingcargame.core.ClientInput;
import java.util.Scanner;

public class ClientInputView {

    private static final String CAR_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String TRY_QUESTION = "시도할 횟수는 몇 회 인가요?";

    public static ClientInput getClientInputByCarAndTryCounts() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(CAR_QUESTION);
        int carCount = scanner.nextInt();

        System.out.println(TRY_QUESTION);
        int tryCount = scanner.nextInt();

        return new ClientInput(carCount, tryCount);
    }

}
