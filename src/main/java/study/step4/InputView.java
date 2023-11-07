package study.step4;

import java.util.Scanner;

import static study.step4.InputParser.parse;


public class InputView {

    public static Rule request() {
        return new Rule(parse(getCarNames()), getMovingTimes());
    }

    private static String getCarNames() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    private static int getMovingTimes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회 인가요?");
        return scanner.nextInt();
    }
}
