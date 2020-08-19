package step3.operation;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class InputValue {
    Scanner scan = new Scanner(System.in);

    public int input(String input) {
        String data = input;
        InputStream is = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }
}
