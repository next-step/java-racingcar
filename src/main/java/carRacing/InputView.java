package carRacing;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int carInput(){
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }
    public static int tryInput() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return scanner.nextInt();
    }
    public static String[] carNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        return input.split(",");
    }

}
