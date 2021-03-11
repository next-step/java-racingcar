package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Step3View implements View {
    final String FORWARD = "-";

    private Scanner scanner = new Scanner(System.in);

    @Override
    public int getNumberOfCar() {
        final String QUESTION_FOR_GET_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
        System.out.println(QUESTION_FOR_GET_NUMBER_OF_CARS);
        int numberOfCars = scanner.nextInt();
        return numberOfCars;
    }

    @Override
    public int getNumberOfRacing() {
        final String QUESTION_FOR_GET_NUMBER_OF_RACING = "시도할 회수는 몇 회 인가요?";
        System.out.println(QUESTION_FOR_GET_NUMBER_OF_RACING);
        int numberOfRacing = scanner.nextInt();
        return numberOfRacing;
    }

    @Override
    public List<String> getCarNames() {
        return new ArrayList<String>() {
        };
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
            while (distance-- != 0) {
                System.out.print(FORWARD);
            }
            System.out.print('\n');
        });
        System.out.print('\n');
    }

    @Override
    public void printWinners(List<String> winnersName) {
    }
}
