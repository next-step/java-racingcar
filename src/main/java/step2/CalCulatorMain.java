package step2;

import step2.object.Calculator;

import java.util.Scanner;

public class CalCulatorMain {

    public static void main(String[] args) {
        Calculator cal = new Calculator();
        String data = "5 + 4 - 3 * 2 / 1";

        Scanner scan = new Scanner(System.in);

        data = scan.nextLine();

        cal.validate(data);

        System.out.println(cal.caculation(data));

        scan.close();
    }
}
