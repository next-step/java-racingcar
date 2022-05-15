package racingcar;

import java.util.Scanner;

public class InputView {
    public static Scanner scanner = new Scanner(System.in);
    public static String input = "";

    public static void main(String[] args) {

        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분)\n");
        input = scanner.nextLine().replace(" ", "");
        emptyValueCheck(input);

        Cars cars = new Cars(input);

        System.out.print("시도할 횟수는 몇 회 인가요?");
        new RacingGame(cars, scanner.nextInt());
    }

    public static void emptyValueCheck(String input) {
        if (input.isEmpty() || input == "") {
            System.out.println("자동차 이름을 제대로 입력하세요.");
            throw new NullPointerException();
        }
    }

}
