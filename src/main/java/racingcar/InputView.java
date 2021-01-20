package racingcar;

import java.util.Scanner;

public class InputView {

    public String[] returnNames(){
        System.out.println("경주할 자동차 이름을 입력하세요:");
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split(",");;
        return names;
    }

    public int getTryNo(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        Scanner scanner = new Scanner(System.in);
        int loopCount = scanner.nextInt();
        System.out.println();
        return loopCount;
    }
}