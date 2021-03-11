package RacingCar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Step4InputView implements InputView {
    private final int MAX_CAR_NAME = 5;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public List<String> getCarNames() {
        final String QUESTION_FOR_GET_NUMBER_OF_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n";
        System.out.println(QUESTION_FOR_GET_NUMBER_OF_CARS);

        String[] carNames = scanner.nextLine().split(",");
        verifyCarName(carNames);
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
        return 0;
    }

    private void verifyCarName(String[] carNames) {
        boolean overLength = !Arrays.stream(carNames)
                .filter(carName -> carName.length() > MAX_CAR_NAME)
                .collect(Collectors.toList())
                .isEmpty();
        if (overLength) {
            throw new IllegalArgumentException("carName must be less then or equal to 5");
        }
    }
}
