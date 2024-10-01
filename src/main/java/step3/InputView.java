package step3;

import java.util.Scanner;

public class InputView {
    private int carCount;
    private int round;

    public void receiveAndViewAndValidate() {
        Scanner scanner = new Scanner(System.in);

        PrintView printView = new PrintView();

        printView.print("자동차 대수는 몇 대 인가요?");
        String carCount = scanner.nextLine();

        printView.print("시도할 회수는 몇 회 인가요?");
        String round = scanner.nextLine();

        printView.enter();

        inputValidate(carCount, round);
    }

    private void inputValidate(String carCount, String round) {
        InputValidator.validate(carCount, round);

        this.carCount = Integer.parseInt(carCount);
        this.round = Integer.parseInt(round);
    }

    public int getCarCount() {
        return carCount;
    }

    public int getRound() {
        return round;
    }

}
