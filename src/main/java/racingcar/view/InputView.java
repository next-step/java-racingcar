package racingcar.view;

import java.util.Scanner;

public class InputView {
    private final String QUERY_FOR_NAMES_OF_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분).";
    private final String QUERY_FOR_NUMBER_OF_TURNS = "시도할 회수는 몇 회 인가요?";
    private final String DELIMITER = ",";

    public String[] getNamesOfCars() {
        System.out.println(QUERY_FOR_NAMES_OF_CARS);
        return getStringUserInputWithDelimiter();
    }

    private String[] getStringUserInputWithDelimiter() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String inputLine = scanner.nextLine();
            return inputLine.split(DELIMITER);
        }
        throw new IllegalStateException("입력을 받을 수 없습니다");
    }

    public int getNumberOfTurns() {
        System.out.println(QUERY_FOR_NUMBER_OF_TURNS);
        return getIntUserInput();
    }


    private int getIntUserInput() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            return scanner.nextInt();
        }
        throw new IllegalStateException("입력을 받을 수 없습니다");
    }
}
