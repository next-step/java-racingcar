package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String mathExpr = Calculator.getValidExpr(br.readLine());
        System.out.println(Calculator.getResult(mathExpr));
        br.close();
    }



}
