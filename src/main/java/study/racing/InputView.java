package study.racing;

import study.validation.InputValidation;

import java.util.Scanner;

public class InputView {

    public int input(String code) {
        Scanner scanner = new Scanner(System.in);
        int totalCount = 0;

        System.out.println(RacingMessage.find(code).getMsg());
        String count = scanner.nextLine();

        boolean isInputMatch = InputValidation.racingInputValidation(count);

        if(isInputMatch) {
            totalCount = Integer.parseInt(count);

        }
        return totalCount;
    }
}
