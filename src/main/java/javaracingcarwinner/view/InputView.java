package javaracingcarwinner.view;

import javaracingcarwinner.dto.GameSettingDto;

import java.util.Scanner;

public class InputView {
    private static final String REQUEST_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n";
    private static final String REQUEST_TRY_COUNT = "시도할 회수는 몇회인가요?\n";

    private static Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static GameSettingDto gameSettings() {
        return new GameSettingDto(requestCarName(), requestTryCount());
    }

    private static String requestCarName() {
        System.out.print(REQUEST_CAR_NAME_MESSAGE);
        return scanner.nextLine();
    }

    private static int requestTryCount() {
        System.out.print(REQUEST_TRY_COUNT);
        return scanner.nextInt();
    }
}
