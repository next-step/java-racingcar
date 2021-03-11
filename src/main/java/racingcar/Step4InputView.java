package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Step4InputView implements InputView {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public List<String> getCarNames() {
        final String QUESTION_FOR_GET_NUMBER_OF_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n";
        System.out.println(QUESTION_FOR_GET_NUMBER_OF_CARS);

        String[] carNames = scanner.nextLine().split(",");
        return Arrays.asList(carNames);
    }

    @Override
    public int getNumberOfRacing() {
        final String QUESTION_FOR_GET_NUMBER_OF_RACING = "시도할 회수는 몇 회 인가요?";
        System.out.println(QUESTION_FOR_GET_NUMBER_OF_RACING);
        int numberOfRacing = scanner.nextInt();
        return numberOfRacing;
    }

    @Override
    public int getNumberOfCar() {
        final String QUESTION_FOR_GET_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
        System.out.println(QUESTION_FOR_GET_NUMBER_OF_CARS);
        int numberOfCars = scanner.nextInt();
        return numberOfCars;
    }
}
