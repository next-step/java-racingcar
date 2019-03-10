package car;

import java.util.Scanner;

public class InputValue {
    private int carCount;
    private int tryCount;


    public static InputValue getValue() {
        InputValue inputValue = new InputValue();

        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");

        int num1 = scanner.nextInt();
        inputValue.setCarCount(num1);

        System.out.println("시도할 회수는 몇 회 인가요?");
        int num2 = scanner.nextInt();
        inputValue.setTryCount(num2);

        return inputValue;
    }

    private void setCarCount(int carCount) {
        this.carCount = carCount;
    }

    private void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public int getCarCount() {
        return this.carCount;
    }

    public int getTryCount() {
        return this.tryCount;
    }
}
