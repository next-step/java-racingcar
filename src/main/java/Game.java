import java.util.Scanner;

public class Game {
    Car car = new Car();
    static int gameTurn;

    Scanner scanner = new Scanner(System.in);

    void gameStart(){
        car.enterCarsName();
        enterGameTurn();
    }

    void enterGameTurn(){
        System.out.println("시도할 회수는 몇회인가요?");
        gameTurn = scanner.nextInt();
    }
}
