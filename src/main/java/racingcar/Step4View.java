package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Step4View implements View {
    final String FORWARD = "-";
    final String CAR_NAME_POSTFIX = " : ";

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

    @Override
    public void printTitle() {
        final String TITLE = "실행 결과";
        System.out.println();
        System.out.println(TITLE);
    }

    @Override
    public void printSingleRacingResult(List<Car> cars) {
        cars.forEach(car -> {
            int distance = car.getDistance();
            System.out.print(car.getName() + CAR_NAME_POSTFIX);
            while (distance-- != 0) {
                System.out.print(FORWARD);
            }
            System.out.print('\n');
        });
        System.out.print('\n');
    }

    @Override
    public void printWinners(List<String> winnersName) {
        if (winnersName.isEmpty()) return;

        System.out.print(winnersName.get(0));
        for (int i = 1; i < winnersName.size(); i++) {
            System.out.print(", ");
            System.out.print(winnersName.get(i));
        }
        System.out.print("가 최종 우승했습니다.\n");
    }
}
