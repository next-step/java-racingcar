import java.util.List;
import java.util.Scanner;

public class Printer {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DASH = "-";

    public static String askNameOfCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.next();
    }

    public static int askNumberOfTry() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public static void printResultTitle() {
        System.out.println("\n실행 결과");
    }

    public static void printResult(Cars cars) {
        for (Car car : cars.getValue()) {
            printDashByCount(car);
        }
        System.out.println();
    }

    private static void printDashByCount(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(DASH.repeat(Math.max(0, car.getPosition())));
        System.out.println(car.getName() + " : " + sb.toString());
    }

    public static void printWinner(Cars cars) {
        List<Car> winners = cars.findWinners();
        String winnerNames = winners.stream()
                .map(Car::getName)
                .reduce((name1, name2) -> name1 + ", " + name2)
                .orElse("");

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
