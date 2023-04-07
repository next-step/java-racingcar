package racing;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfCars = takeParameterFromUser("자동차 대수는 몇 대 인가요?");
        int numberOfRound = takeParameterFromUser("시도할 회수는 몇 회 인가요?");

        Cars cars = Cars.init(numberOfCars);
        System.out.println("실행 결과");
        cars.showPositionsOfCars();

        for (int i = 1; i < numberOfRound; i++) {
            cars.tryToMoveAllCars();
            cars.showPositionsOfCars();
        }
    }

    private static int takeParameterFromUser(String guideMessage) {
        System.out.println(guideMessage);
        return Integer.parseInt(scanner.nextLine());
    }
}
