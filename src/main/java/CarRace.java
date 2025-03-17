import java.util.Scanner;

public class CarRace {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numCar = receiveCarNum();

        int numTry = receiveNumTry();
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
}
