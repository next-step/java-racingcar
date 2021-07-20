package racing_car;

import java.util.Scanner;

public class StringCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] temp = str.split(" ");
        
        Arithmetic arithmetic = new Arithmetic();
        int first = Integer.parseInt(temp[0]);
        int result = first;
        for (int i = 1; i < temp.length; i+=2) {
            String operator = temp[i];
            int second = Integer.parseInt(temp[i+1]);
            result = arithmetic.operation(result,operator,second);
        }

        System.out.println("실행결과 = " + result);
    }

}
