package racingcar.view;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Getter
public class InputView {
    private static final String QUESTIONS_TIME = "시도할 횟수는 몇 회인가요?";
    private static final String QUESTIONS_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private int time;
    private List<String> carNames;

    public void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(QUESTIONS_CAR_NAME);
        carNames = Arrays.asList(scanner.nextLine().split(","));

        System.out.println(QUESTIONS_TIME);
        time = Integer.valueOf(scanner.nextLine());
    }
}
