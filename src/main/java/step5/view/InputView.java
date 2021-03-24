package step5.view;

import step5.domain.InputValidator;
import step5.dto.InputDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private static final String TRY_COUNT_MESSAGE = "시도할 회수는 몇회 인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static InputDto input() {
        System.out.println(CAR_NAME_MESSAGE);
        String inputCarNames = scanner.next();

        String[] carNameList = split(inputCarNames);

        System.out.println(TRY_COUNT_MESSAGE);
        int tryCount = scanner.nextInt();

        return new InputDto(new ArrayList<>(Arrays.asList(carNameList)), tryCount);
    }

    private static String[] split(String inputCarNames) {
        return inputCarNames.split(",");
    }
}
