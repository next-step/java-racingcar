package racingcar.view;

import lombok.Getter;

import java.util.Scanner;

@Getter
public class InputView {
    final String QUESTIONS_NUMBER = "자동차 대수는 몇 대인가요?";
    final String QUESTIONS_TIME = "시도할 횟수는 몇 회인가요?";

    private int time;
    private int number;

    public void input() {
        System.out.println(QUESTIONS_NUMBER);

        Scanner scanner = new Scanner(System.in);
        number = Integer.valueOf(scanner.nextLine());

        System.out.println(QUESTIONS_TIME);
        time = Integer.valueOf(scanner.nextLine());
    }
}
