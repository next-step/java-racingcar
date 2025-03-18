package util;

import calculator.Splitter;

import java.util.Scanner;

public class InputView {

    public static int getCarCountInput() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int getTryCountInput() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String[] getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요 (이름은 쉼표(,)를 기준으로 구분");
        Scanner scanner = new Scanner(System.in);
        return Splitter.split(scanner.nextLine());
    }
}
