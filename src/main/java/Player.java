import java.util.Scanner;

public class Player {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int howManyCars = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int howManyTimesToTry = scanner.nextInt();

        CarFactory carFactory = new CarFactory();
        Cars cars = carFactory.create(howManyCars, howManyTimesToTry);
        CarRacingGame carRacingGame = CarRacingGame.gameSetting(cars);
        carRacingGame.start();
    }
}
