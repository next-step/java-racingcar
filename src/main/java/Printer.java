import java.util.Scanner;

public class Printer {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DASH = "-";

    public static int askNumberOfCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public static int askNumberOfTry() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public static void printResult(Cars cars) {
        System.out.println("실행 결과");
        for (Car car : cars.getValue()) {
            printDashByCount(car.getPosition());
        }
    }

    private static void printDashByCount(int count) {
        StringBuilder sb = new StringBuilder();
        sb.append(DASH.repeat(Math.max(0, count)));
        System.out.println(sb.toString());
    }
}
