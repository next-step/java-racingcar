package racingcar.view;

import java.util.Scanner;

public class InputStringView implements InputView{
    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String RACE_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public static final String DELIMITER = ",";

    private final Scanner scanner;

    public InputStringView() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String[] readCar() {
        System.out.println(CAR_NAME_MESSAGE);
        String text = scanner.nextLine();
        return text.split(DELIMITER);
    }

    @Override
    public Integer readRace() {
        System.out.println(RACE_COUNT_MESSAGE);
        return scanner.nextInt();
    }
}
