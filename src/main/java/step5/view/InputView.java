package step5.view;

import step5.domain.InputValidator;
import step5.dto.InputDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private static final String TRY_COUNT_MESSAGE = "시도할 회수는 몇회 인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    // 뭔가 지져분한 메소드 같은...
    public static InputDto input() {
        System.out.println(CAR_NAME_MESSAGE);
        String inputCarNames = scanner.next();

        // 여기서 이렇게 메소드를 분리한다 한들 좋지 않은 코드가 될까요 ??
        // 입력을 받자마자 바로 유효성 체크를 하고 싶어서 여기에 이렇게 넣긴 했는데 깔끔해보이지는 않습니다.. (개인적으로 ㅠㅠ)
        String[] carNameList = inputValidator(inputCarNames);

        System.out.println(TRY_COUNT_MESSAGE);
        int tryCount = scanner.nextInt();
        // 이것도 위와 같습니다 ㅠ-ㅠ
        InputValidator.checkTryCountIsMinus(tryCount);

        System.out.println();
        System.out.println(RESULT_MESSAGE);

        return new InputDto(new ArrayList<>(Arrays.asList(carNameList)), tryCount);
    }

    private static String[] inputValidator(String inputCarNames) {
        String[] carNameList = inputCarNames.split(",");

        for (String carName : carNameList) {
            InputValidator.checkCarName(carName);
        }

        return carNameList;
    }
}
