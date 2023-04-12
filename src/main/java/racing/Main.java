package racing;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        InputView.showCarCountInputMessage();
        int numberOfCars = Integer.parseInt(scanner.nextLine());
        InputView.showRoundInputMessage();
        int numberOfRound = Integer.parseInt(scanner.nextLine());

        Cars cars = Cars.init(numberOfCars);
        System.out.println("실행 결과");

        for (int i = 0; i < numberOfRound; i++) {
            cars.move();
            List<Integer> positions = cars.getCarsPositions();
            ResultView.showRepeatedDashWithCount(positions);
        }
    }
}
