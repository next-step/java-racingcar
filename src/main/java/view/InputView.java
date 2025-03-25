package view;

import java.util.Scanner;

import domain.Racing;
import utils.StringAddCalculator;

public class InputView {
    public static Racing input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.next();
        String[] carNameList = StringAddCalculator.split(input);

        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();

        return new Racing(carNameList, tryCount);
    }
}
