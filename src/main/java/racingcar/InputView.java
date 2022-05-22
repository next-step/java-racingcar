package racingcar;

import java.util.Scanner;

public class InputView {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분)\n");
        Cars cars = new Cars(scanner.nextLine());

        System.out.print("시도할 횟수는 몇 회 인가요?");
        new RacingGame(cars, scanner.nextInt());
    }

}
