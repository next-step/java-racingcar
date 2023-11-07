package study.carRacing;

import java.util.Scanner;

public class ReceiveInputValue {

    private Scanner scanner;

    public ReceiveInputValue() {
        scanner = new Scanner(System.in);
    }

    public int receiveInputValueForCar() {
        System.out.println("자동차 대수를 입력하세요.");
        return scanner.nextInt();
    }


}
