package RacingCar;

import java.util.*;

public class RacingCar {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static final List<Car> carList = new ArrayList<>();

    public static void main(String[] args) {
        int carCount = carCountScan();
        int round = roundScan();

        initCar(carCount);

        racing(round);
    }

    private static void racing(int round) {
        ResultView.resultView();
        for (int i = 0; i < round; i++) {
            round();
            roundResult();
        }
    }

    private static void roundResult() {
        for (Car car : carList) {
            ResultView.positionView(car.getPosition());
        }
        System.out.println();
    }

    private static void round() {
        for (Car car : carList) {
            car.move();
        }
    }

    public static void initCar(int carCount) {
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car(i, 0));
        }
    }

    private static int roundScan() {
        InputView.roundView();
        return scan();
    }

    private static int carCountScan() {
        InputView.carCountView();
        return scan();
    }

    public static int random() {
        return random.nextInt(10);
    }

    public static int scan() {
        return scanner.nextInt();
    }


}
