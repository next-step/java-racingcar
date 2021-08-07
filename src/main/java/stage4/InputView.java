package stage4;

import java.util.Scanner;

public class InputView {

    private Scanner sc;

    public InputView() {
        this.sc = new Scanner(System.in);
    }

    public InputValue input() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        final String carNames = sc.next();
        final String[] splitName = splitName(carNames);

        System.out.println("시도할 회수는 몇회인가요?");
        int tryNum = sc.nextInt();
        System.out.println();

        return new InputValue(splitName, tryNum);
    }

    private String[] splitName(String carNames) {
        // todo validation
        return carNames.split(",");
    }
}
