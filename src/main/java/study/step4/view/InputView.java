package study.step4.view;

import java.util.Scanner;

import study.step4.domain.Rule;

import static study.step4.view.InputParser.parse;


public class InputView {

    public static Rule requestRule() {
        Rule rule = new Rule(parse(getCarNames()), getMovingTimes());
        System.out.println();
        return rule;
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
