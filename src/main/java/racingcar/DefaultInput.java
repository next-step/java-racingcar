package racingcar;

import java.util.Scanner;

public class DefaultInput implements Input {
    private static final Scanner scanner = new Scanner(System.in);

    public int getCarQuantity() {
        System.out.println("경기에 출전할 자동차 수는 몇대인가요?");
        return scanner.nextInt();
    }

    public int getMovementCount() {
        System.out.println("자동차의 이동 횟수는 몇번인가요?");
        return scanner.nextInt();
    }

}
