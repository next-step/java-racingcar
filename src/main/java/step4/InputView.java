package step4;

import java.util.Scanner;

public class InputView {
    private static final int NAME_LENGTH_LIMIT = 5;

    public RacingGameInputData init() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            String[] carNames = scanner.next().split(",");
            if (validateName(carNames)) continue;
            System.out.println("시도할 회수는 몇 회 인가요?");
            int tryCount = scanner.nextInt();
            return new RacingGameInputData(tryCount, carNames);
        }

    }

    public boolean validateName(String[] carNames) {
        for (String carName : carNames) {
            return isOverLimit(carName);
        }
        return false;
    }

    public boolean isOverLimit(String carName) {
        if (carName.length() >= NAME_LENGTH_LIMIT) {
            System.out.println("차 이름은 5글자를 초과할수 없습니다. 다시 입력하세요.\n");
            return true;
        }
        return false;
    }

}
