package study.carRacing;

import java.util.Scanner;

public class ReceiveInputValue {

    private Scanner scanner;

    public ReceiveInputValue() {
        scanner = new Scanner(System.in);
    }

    public int receiveInputValueForCar() {
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        ReceiveInputValue receiveInputValue = new ReceiveInputValue();
        int result = receiveInputValue.receiveInputValueForCar();

        System.out.println("결과: " + result);
    }


}
