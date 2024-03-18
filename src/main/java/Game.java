import java.util.Scanner;

/**
 * @author jeongheekim
 * @date 3/12/24
 */

public class Game {
    private static int gameCount;
    private static Car[] cars;

    public void start() {
        cars = createCar();
        gameCount = getGameCount();

        System.out.println("실행 결과");
        for (int i = 0; i < gameCount; i++) {
            for (Car car : cars) {
                int i1 = (int) (Math.random() * 10);
                if (i1 >= 4) {
                    car.drive();
                }
            }
            System.out.println("                           ");
        }

    }

    private static int getGameCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇 회 인가요?");
        int gameCount = scanner.nextInt();
        System.out.println("gameCount = " + gameCount);
        return gameCount;
    }


    private static Car[] createCar() {
        int carCount = getCarCount();
        Car[] cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            cars[i] = new SmallCar();
        }
        return cars;
    }

    private static int getCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        int carCount = Integer.parseInt(scanner.nextLine());
        System.out.println("자동차 대수 = " + carCount);
        return carCount;
    }

    public static Car[] getCars() {
        return cars;
    }
}
