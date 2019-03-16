package racing;

import java.util.Scanner;
import java.util.StringTokenizer;

public class InputView {

    public static String[] getNamesOfCars() {
       System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
       Scanner scanner = new Scanner(System.in);
       return splitInputToNamesOfCars(scanner.nextLine());
    }

    private static String[] splitInputToNamesOfCars(String input) {
        return input.split(",");
    }

    public static int getNumberOfCar() {
        System.out.println("자동차 대수는 몇 대인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int getTimeToTry() {
        System.out.println("시도할 회수는 몇 회인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
