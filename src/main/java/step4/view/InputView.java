package step4.view;

import step4.dto.RequestDto;

import java.util.Scanner;

public final class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static InputView instance;

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    private final String inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.next();
    }

    private final int round() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public final RequestDto requestDto() {
        return new RequestDto(inputNames(), round());
    }

}
