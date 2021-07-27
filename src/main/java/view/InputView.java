package view;

import java.util.Scanner;

public class InputView {


    private void insertCarCountAndTryCount() {

        int carCount = 0;
        int tryCount = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        carCount = scanner.nextInt();

        if (carCount < 1) {
            throw new IllegalArgumentException("자동차 개수는 0이나 음수는 허용하지 않습니다.");
        }

        System.out.println("시도할 회수는 몇 회 인가요?");
        tryCount = scanner.nextInt();

        if (tryCount < 1) {
            throw new IllegalArgumentException("시도 횟수는 0이나 음수는 허용하지 않습니다.");
        }


    }

    public void CallInsertElement() {
        insertCarCountAndTryCount();
    }

}
