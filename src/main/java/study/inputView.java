package study;

import java.util.Scanner;

public class inputView {

    static String value = null;
    static int number = 0;

    public static void inputView() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        value = scanner.nextLine();
        System.out.println("자동차 대수는 몇 회 인가요?");
        number = scanner.nextInt();
    }

}
