package view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private static final String CAR_OF_NUMBER_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TIME_NUMBER_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String SPLIT_SIGN = ",";
    private static final int MAX_PLAYER_NUMBER = 5;

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static Set<String> inputNumberOfCar() {
        System.out.println(CAR_OF_NUMBER_MESSAGE);
        String input = scanner.nextLine();
        String[] split = input.split(SPLIT_SIGN);

        return Arrays.stream(split)
                .filter(it -> it.length() <= MAX_PLAYER_NUMBER)
                .collect(Collectors.toSet());
    }

    public static int inputTime() {
        System.out.println(TIME_NUMBER_MESSAGE);
        return scanner.nextInt();
    }
}
