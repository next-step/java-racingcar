import calculator.InputValidator;
import calculator.StringCalculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        InputValidator iv = new InputValidator();
        StringCalculator sc = new StringCalculator();
        try {
            String[] data = iv.validate(inputStr).split(" ");
            int leftData = 0;
            int rightData = 0;
            String calculate;
            int maxI = data.length;
            for (int i = 0; i < maxI; i++) {
                if (i == 0) leftData = Integer.parseInt(data[i]);
                if (i % 2 == 1) {
                    calculate = iv.calculateValidate(data[i]);
                    rightData = Integer.parseInt(data[i + 1]);
                    leftData = sc.calculate(leftData, rightData, calculate);
                }
            }
            System.out.println(leftData);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        br.close();
    }
}
