package study;
import java.util.Arrays;
import java.util.Scanner;

public class CalculatorSample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputVal = "";
        int resVal = 0;
        System.out.print("계산 할 문자열을 입력해주세요. ");
        inputVal = scanner.nextLine();
        System.out.println("입력값=="+ inputVal);
        Calculator calcu = new Calculator();
        String[] strArr = calcu.inPutVal(inputVal);
        calcu.cal(strArr);
        System.out.println("값=="+ calcu.cal(strArr));


    }
}
