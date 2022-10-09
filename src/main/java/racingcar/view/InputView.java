package racingcar.view;

import util.NumberUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String CAR_DESCRIPTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_DESCRIPTION = "시도할 횟수는 몇 회 인가요?";

    private static final Scanner scanner= new Scanner(System.in);

    public static int getTryCount() {
        System.out.println(TRY_DESCRIPTION);
        return NumberUtil.getPositiveInteger(scanner.nextLine());
    }

    public static List<String> getCarNames() {
        System.out.println(CAR_DESCRIPTION);
        String inputCarNames = scanner.nextLine();
        return convertNameList(inputCarNames);
    }

    public static List<String> convertNameList(String inputNames) {
        if (inputNames == null || inputNames.isEmpty()) {
            throw new RuntimeException("자동차 이름을 한글자 이상 입력해주세요.");
        }
        String[] names = inputNames.split(",");

        return Arrays.asList(names);
    }
}
