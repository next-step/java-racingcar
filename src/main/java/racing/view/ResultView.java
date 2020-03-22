package racing.view;

import racing.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public void printWinner(List<Car> winners) {
        String winnerMsg = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.printf("%s가 최종 우승했습니다.", winnerMsg);
        printLineBreak();
    }

    public void printPositions(List<Car> cars) {
        for (Car car : cars) {
            printPosition(car);
        }
        printLineBreak();
    }

    private void printPosition(Car car) {
        System.out.print(car.getName() + " : ");
        for (int p = 0 ; p < car.getPosition() ; p++) {
            System.out.print("-");
        }
        printLineBreak();
    }

    private void printLineBreak() {
        System.out.println();
    }

}
