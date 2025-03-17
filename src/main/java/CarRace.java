import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class CarRace {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numCar = receiveCarNum();
        int numTry = receiveNumTry();
        String[] cars = initCurrentState(numCar);

        IntStream.range(0, numTry)
                .forEach(
                        i -> {
                            updateCurrentState(cars, numCar);
                            printCurrentState(cars);
                        });
    }

    public static Integer receiveCarNum() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int numCar = scanner.nextInt();
        if (numCar > 0) {
            return numCar;
        }
        throw new RuntimeException("자동차 대수는 양수 여야합니다.");
    }

    public static Integer receiveNumTry() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int numTry = scanner.nextInt();
        if (numTry > 0) {
            return numTry;
        }
        throw new RuntimeException("시도할 회수는 양수 여야합니다.");
    }

    public static String[] initCurrentState(int numCar) {
        if (numCar > 0) {
            return Arrays.stream(new String[numCar]).map(car -> "-").toArray(String[]::new);
        }

        throw new RuntimeException("자동차 대수는 양수 여야합니다.");
    }

    public static void updateCurrentState(String[] cars, int numCar) {
        Random random = new Random();
        if (numCar <= 0) {
            throw new RuntimeException("자동차 대수는 양수 여야합니다.");
        }
        IntStream.range(0, numCar)
                .forEach(
                        j -> {
                            int randomVal = random.nextInt(10);
                            if (randomVal >= 4) {
                                cars[j] += "-";
                            }
                        });
    }

    public static void printCurrentState(String[] cars) {
        Arrays.stream(cars).forEach(System.out::println);
        System.out.println();
    }
}
