package mission1.step4.view;

import java.util.Scanner;

public class InputView {

    public static String carNameList;
    public static int execNum;

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        carNameList = scanner.next();
        System.out.println("시도할 회수는 몇 회 인가요?");
        execNum = scanner.nextInt();
    }
}




