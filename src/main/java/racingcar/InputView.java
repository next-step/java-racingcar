package racingcar;

import java.util.Scanner;

public class InputView {

    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        int number = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");

        System.out.println("실행 결과");
    }
}
