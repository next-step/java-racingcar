import java.util.Scanner;

public class Printer {
    private static final Scanner scanner = new Scanner(System.in);

    public int askNumberOfCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public int askNumberOfTry() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public void printResult(Cars cars) {
        System.out.println("실행 결과");
        for (Car car : cars.getValue()) {
            printDashByCount(car.getPosition());
        }
    }

    private void printDashByCount(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("-");
        }
    }
}
