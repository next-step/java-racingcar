package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Step3View implements View {
    final String FORWARD_SYMBOL = "-";

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
            printDistance(car.getDistance());
            System.out.print('\n');
        });
        System.out.print('\n');
    }

    private void printDistance(Distance distance) {
        Distance emptyDistance = new Distance(0);
        while (!distance.equals(emptyDistance)) {
            distance = distance.decrease();
            System.out.print(FORWARD_SYMBOL);
        }
    }

    @Override
    public void printWinners(List<String> winnersName) {
    }
}
