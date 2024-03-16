package racingcar.view;

import java.util.Scanner;

public class InputView {

    public static void main(String[] args) {
        int carNum = inputNum("자동차 대수는 몇 대 인가요?");
        int times = inputNum("시도할 회수는 몇 회 인가요?");
    }

    private static int inputNum(String str) {

        System.out.println(str);
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }
}
