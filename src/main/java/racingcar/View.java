package racingcar;

import java.util.List;
import java.util.Scanner;

public class View {

    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        String inputName = scanner.nextLine();

        List<Car> cars = Car.createCars(inputName);

        System.out.println("시도할 회수는 몇 회 인가요?");
        String gameNum = scanner.nextLine();
        System.out.println("실행 결과");
        final RacingGame racingGame = new RacingGame();
        for (int i = 0; i < Integer.parseInt(gameNum); i++) {
            printCarsStatus(cars = racingGame.carMoveRandom(cars));
            System.out.println();
        }
    }

    private static void printCarsStatus(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.toString()));
    }

}
