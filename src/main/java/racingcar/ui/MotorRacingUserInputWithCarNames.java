package racingcar.ui;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static racingcar.ui.MotorRacingDisplay.display;

public class MotorRacingUserInputWithCarNames {
    private static final Scanner scanner = new Scanner(System.in);
    public static final String CAR_NAME_SPLIT_STR = ",";

    public static UserInputInfoWithCarNames input(){
        final Set<String> carNames =  Stream.of(inputCarNames())
                                            .map(String::trim)
                                            .collect(Collectors.toCollection(LinkedHashSet::new ));
        final int tryCount = inputTryCount();
        return new UserInputInfoWithCarNames(carNames, tryCount);
    }

    private static String[] inputCarNames(){
        display("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine().split(CAR_NAME_SPLIT_STR);
    }

    private static int inputTryCount() {
        display("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }


}
