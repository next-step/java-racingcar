package racingcar;

import java.util.List;
import java.util.Scanner;

public class View {

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
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

        printWinners(RacingGame.getWinner(cars));

    }

    private static void printCarsStatus(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.toString()));
    }

    private static void printWinners(List<Car> cars) {
        if (cars.size() == 0) {
            System.out.println("우승자가 없습니다.");
        }

        final StringBuilder stringBuilder = new StringBuilder();

        for (Car car : cars) {
            stringBuilder.append(", ");
            stringBuilder.append(car.getName());
        }

        stringBuilder.delete(0, 2);

        stringBuilder.append("가 최종 우승했습니다.");

        System.out.println(stringBuilder);
    }

}
