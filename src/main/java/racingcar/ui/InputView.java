package racingcar.ui;

import racingcar.domain.InputData;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class InputView {

    public static final String NAME_DELIMITER = ",";
    private static Scanner scanner = new Scanner(System.in);

    public static InputData getInputData() {
        return new InputData(getCarNames(), getTryCount());
    }

    private static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분)");
        String value = scanner.nextLine();

        if (value.equals("") || Objects.isNull(value)) {
            System.out.println("빈 칸을 입력할 수 없습니다.");
            getCarNames();
        }

        return Arrays.stream(value.split(NAME_DELIMITER))
                .collect(toList());

    }

    private static int getTryCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
