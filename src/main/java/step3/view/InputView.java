package step3.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class InputView {

    public int input(String input) {
        String data = input;
        InputStream is = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    public String inputString(String input) {
        String data = input;
        InputStream is = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public int numOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        int result = scanner.nextInt();
        return result;
    }

    public int numberOfAttempts() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner scanner = new Scanner(System.in);
        int result = scanner.nextInt();
        System.out.println();
        System.out.println("실행결과");
        return result;
    }

}
