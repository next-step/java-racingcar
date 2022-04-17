package racing.view;

import java.util.Scanner;

public class InputView {

    static final Scanner scanner = new Scanner(System.in);

    public int inputCarNumber() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNumber = scanner.nextInt();
        validCarNumber(carNumber);
        return carNumber;
    }

    public int inputMoveNumber() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int moveCount = scanner.nextInt();
        return moveCount;
    }

    private void validCarNumber(int carNumber) {
        if(carNumber < 0) {
            throw new RuntimeException("자동차의 숫자는 0 이상이여야 합니다.");
        }
    }
}
