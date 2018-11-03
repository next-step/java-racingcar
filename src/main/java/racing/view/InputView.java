package racing.view;

import java.util.Scanner;

public class InputView {

    private int carNumber;
    private int tryNumber;

    public InputView() {
        doInput();
    }

    public void doInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        carNumber = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        tryNumber = scanner.nextInt();
    }

    public int getCarNumber() {
        return this.carNumber;
    }

    public int getTryNumber() {
        return this.tryNumber;
    }

}
