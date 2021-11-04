package step3;

import java.util.Scanner;

public class InputView {

    public GameInformation input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        String carCountStr = scanner.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요?");
        String timeStr = scanner.nextLine();

        UserInput userInput = UserInput.create(carCountStr, timeStr);
        userInput.validate();

        return GameInformation.create(userInput);
    }

    private Integer getIntegerValue(String input) {
        return Integer.valueOf(input);
    }

}
