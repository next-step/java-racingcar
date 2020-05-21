package game.ui;

import game.CarName;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsoleRacingGameInputView implements RacingGameInputView {

    private static final String CAR_NAME_DELIMITER = ",";

    private static final String QUESTION_NUMBER_OF_CAR = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String QUESTION_TIME = "시도할 회수는 몇 회 인가요?";

    @Override
    public int getTime() {
        System.out.println(QUESTION_TIME);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public List<CarName> getCarNameList() {
        System.out.println(QUESTION_NUMBER_OF_CAR);
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split(CAR_NAME_DELIMITER);
        return Stream.of(names).map(CarName::new).collect(Collectors.toList());
    }
}
