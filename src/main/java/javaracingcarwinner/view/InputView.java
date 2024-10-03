package javaracingcarwinner.view;

import javaracingcarwinner.dto.RacingInfoDto;

import java.util.Scanner;

public class InputView {
    private static final String REQUEST_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n";
    private static final String REQUEST_TRY_COUNT = "시도할 회수는 몇회인가요?\n";

    private static Scanner scanner = new Scanner(System.in);

    private final RacingInfoDto racingInfoDto;

    public InputView(){
        String text = requestCarName();
        int tryCount = requestTryCount();
        this.racingInfoDto = new RacingInfoDto(text,tryCount);
    }

    private String requestCarName() {
        System.out.print(REQUEST_CAR_NAME_MESSAGE);
        return scanner.nextLine();
    }

    private int requestTryCount() {
        System.out.print(REQUEST_TRY_COUNT);
        return scanner.nextInt();
    }

    public RacingInfoDto info(){
        return this.racingInfoDto;
    }

}
