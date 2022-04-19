package racing.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    static final Scanner scanner = new Scanner(System.in);
    static final String CAR_NAME_DELIMITER = ",";
    static final int CAR_NAME_MAX_LENGTH = 5;

    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.next();
        List<String> carNames = Arrays.asList(input.split(CAR_NAME_DELIMITER));
        validCarNames(carNames);
        return carNames;
    }

    public int inputMoveNumber() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    private void validCarNames(List<String> carNames) {
        for (String carName : carNames) {
            validNameLength(carName);
        }
    }

    private void validNameLength(String carName) {
        if(carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new RuntimeException("자동차의 이름은 5글자를 초과할 수 없습니다.");
        }
    }
}
