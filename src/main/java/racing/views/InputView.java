package racing.views;

import racing.domain.InputDto;

import java.util.Scanner;

public class InputView {

    private static final String CAR_NAMES_Q = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String NUMBER_Q = "시도할 회수는 몇 회 인가요?";

    private final Scanner scanner;

    public InputView () {
        this.scanner = new Scanner(System.in);
    }

    public String inputString(String description) {
        System.out.println(description);
        return scanner.nextLine();
    }

    public InputDto generateInputDto() {
        String names = inputString(CAR_NAMES_Q);
        String number = inputString(NUMBER_Q);
        return new InputDto(names, number);
    }
}
