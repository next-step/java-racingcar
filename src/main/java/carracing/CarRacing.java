package carracing;

import java.util.Scanner;


public class CarRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        String carNumber = scanner.nextLine();
        System.out.println("시도할 회수는 몇 회 인가요?");
        String tryNumber = scanner.nextLine();

        System.out.println("실행 결과");



    }


    public static int carInputProcess(String text) {
//        int result = 0;

        if(isBlank(text)) {
            return 0;
        }

        if(text.length() > 1) {
            return toInt(text.substring(0,1));
        }

        return toInt(text);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }
    private static int toInt(String text) {
        return Integer.parseInt(text);
    }
}
