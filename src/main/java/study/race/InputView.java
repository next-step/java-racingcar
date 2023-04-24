package study.race;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String scanNumberOfCar() {
        System.out.println("자동차 대 수는 몇 대 인가요?");
        return scanner.nextLine();
    }

    public static int  scanNumberOfCount(){
        System.out.println("시도할 횟 수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public static String scanNameOfCar() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        return scanner.nextLine();
    }

}
