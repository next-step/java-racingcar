package racing;

import java.util.List;
import java.util.Scanner;

public class RacingApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        int carCount = inputView.inputCarCount();
        int opportunity = inputView.inputOpportunity();

        Cars cars = new Cars(RacingSupporter.generateCarList(carCount));

        for (int i = 0; i < opportunity; i++) {
            List<Integer> randomList = NumberGenerator.generateRandomList(carCount);
            RacingSupporter.raceCars(cars, randomList);

            RacingPrinter.drawPositions(cars.valueOfCarsPosition());
        }
    }
}
