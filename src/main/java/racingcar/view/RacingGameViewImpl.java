package racingcar.view;

import racingcar.domain.Car;
import racingcar.utils.NameChecker;
import racingcar.utils.NameCheckerImpl;

import java.util.List;
import java.util.Scanner;

public class RacingGameViewImpl implements RacingGameView {
    private final Scanner scanner = new Scanner(System.in);
    private final NameChecker nameChecker = new NameCheckerImpl();

    @Override
    public String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요:");
        String inputLine = scanner.nextLine();
        String[] carNames = nameChecker.splitName(inputLine);
        for (String carName : carNames) {
            nameChecker.checkAvailableCarName(carName);
        }

        return carNames;
    }

    @Override
    public int inputPlayCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int playCount = scanner.nextInt();
        System.out.println();
        return playCount;
    }

    @Override
    public void printWinner(List<Car> winners) {
        StringBuilder winnersBuilder = new StringBuilder();
        for (Car winner : winners) {
            winnersBuilder.append(winner.getName()).append(", ");
        }
        String winnerText = winnersBuilder.substring(0, winnersBuilder.length() - 2);
        System.out.println("최종 우승자: " + winnerText);
    }

    @Override
    public void printCars(List<Car> cars) {
        for (Car car : cars) {
            car.move();
            car.printCurrentPosition();
        }
        System.out.println();
    }
}