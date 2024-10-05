package step3.view;

import java.util.Scanner;

public class InputView {
    private String[] carNameArray;
    private int round;

    public void receiveAndViewAndValidate() {
        Scanner scanner = new Scanner(System.in);

        PrintView printView = new PrintView();

        printView.print("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)를 기준으로 구분)");
        String carName = scanner.nextLine();

        printView.print("시도할 회수는 몇 회 인가요?");
        String round = scanner.nextLine();

        printView.enter();

        inputValidate(carName, round);
    }

    private void inputValidate(String carName, String round) {
        InputValidator.validate(carName, round);

        this.carNameArray = carName.split(",");
        this.round = Integer.parseInt(round);
    }

    public String[] getCarNameArray() {
        return carNameArray.clone();
    }

    public int getRound() {
        return round;
    }

}
