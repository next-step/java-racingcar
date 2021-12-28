import java.util.Random;
import java.util.Scanner;

public class Game {
    Car car = new Car();
    static int gameTurn;

    Scanner scanner = new Scanner(System.in);

    void gameStart() {
        car.enterCarsName();
        enterGameTurn();
        System.out.println("실행결과");
        for (int i = 0; i < gameTurn; i++) {
            racing();
        }
        findWinner();
    }

    void enterGameTurn() {
        System.out.println("시도할 회수는 몇회인가요?");
        gameTurn = scanner.nextInt();
        System.out.println();
    }

    void racing() {
        Random random = new Random();
        for (int i = 0; i < Car.cars.size(); i++) {
            int randomNumber = random.nextInt(10);
            car.carsMove(i, randomNumber);
        }
        printTurnResult();
    }

    void printTurnResult() {
        for (int i = 0; i < Car.cars.size(); i++) {
            String carName = Car.cars.get(i);
            String carMoving = Car.carsMoving.get(i);
            System.out.println(carName + " : " + carMoving);
        }
        System.out.println();
    }

    void findWinner() {
        int maxDistance = car.findMaxDistance();
        car.findMaxDistanceCar(maxDistance);
        printWinnerResult();
    }

    void printWinnerResult() {
        for (int i = 0; i < Car.winner.size(); i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(Car.winner.get(i));
        }
        System.out.println("가 최종 우승했습니다");
    }
}
