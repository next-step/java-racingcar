package step4.view;

import step4.dto.InputDto;
import step4.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private static final String TRY_COUNT_MESSAGE = "시도할 회수는 몇회 인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static InputDto input() {
        System.out.println(CAR_NAME_MESSAGE);
        String inputCarNames = scanner.next();

        // 메소드 내부에서 너무 많은 일을 하는 걸까요 ?? ...
        String[] carNameList = inputCarNames.split(",");

        for (String carName: carNameList) {
            Validator.checkCarName(carName);
        }

        System.out.println(TRY_COUNT_MESSAGE);
        int tryCount = scanner.nextInt();
        Validator.checkTryCountIsMinus(tryCount);

        System.out.println();
        System.out.println(RESULT_MESSAGE);

        return new InputDto(new ArrayList<>(Arrays.asList(carNameList)), tryCount);
    }
}
