import java.util.Random;
import java.util.Scanner;

public class Game {
    Car car = new Car();
    View view = new View();
    static int gameTurn;

    void gameStart() {
        view.enterCarsName();
        gameTurn = view.enterGameTurn();
        System.out.println("실행결과");
        for (int i = 0; i < gameTurn; i++) {
            racing();
        }
        findWinner();
    }

    void racing() {
        Random random = new Random();
        for (int i = 0; i < Car.cars.size(); i++) {
            int randomNumber = random.nextInt(10);
            car.carsMove(i, randomNumber);
        }
        view.printTurnResult();
    }

    void findWinner() {
        int maxDistance = car.findMaxDistance();
        car.findMaxDistanceCar(maxDistance);
        view.printWinnerResult();
    }

}
