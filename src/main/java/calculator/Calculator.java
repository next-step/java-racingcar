package calculator;

import java.util.List;
import java.util.Scanner;

public class Calculator {

    public void run() {
        System.out.println("Step2  문자열 계산기");
        start();
    }

    private void start() {
        String input = init();

        Splitter splitter = new Splitter(input);
        List<Integer> numbers = splitter.getIntegers();
        List<CalculatorSign> signs = splitter.getSigns();

        int frontNumber = numbers.get(0);

        int roofCount = signs.size();
        for (int i=0; i<roofCount; i++) {
            frontNumber = signs.get(i).operate(frontNumber, numbers.get(i+1));
        }

        printResult(frontNumber);
    }

    private void printResult(int result) {
        System.out.println("계산 결과 : " + result);
    }

    private String init() {
        System.out.print("계산식을 입력하세요 = ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
