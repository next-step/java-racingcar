package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Calculator calculator = new Calculator();
        System.out.println(calculator.getResult(br.readLine()));
        br.close();
    }

}
