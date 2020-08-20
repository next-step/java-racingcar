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

    public int numOfCars(String data) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int result = input(data);
        System.out.println(result);
        return result;
    }

    public int numberOfAttempts(String data) {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int result = input(data);
        System.out.println(result);
        return result;
    }

}
