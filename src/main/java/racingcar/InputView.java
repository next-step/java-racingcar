package racingcar;

import java.util.List;
import java.util.Scanner;

public class InputView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차는 몇 대인가요?");
        int cars = scanner.nextInt();
        System.out.println("몇 번 시도하나요?");
        int attempts = scanner.nextInt();

        RacingGame racingGame = new RacingGame(cars, attempts);

        System.out.println("실행결과");
        List<Car> carList = racingGame.getCarList();
        for (int i = 0; i <attempts ; i++) {
            for (int j = 0; j <carList.size() ; j++) {
                Car car = carList.get(j);
                boolean[] moves = car.getMoves();
                for (int k = 0; k <= i ; k++) {
                    if (moves[k]) {
                        System.out.print("-");
                    }
                }
                System.out.print("\n");
            }
            System.out.print("\n");
        }
    }
}
