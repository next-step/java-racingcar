package step4;

import step4.checkor.ScoreCheckor;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ViewManager {

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputMessageAboutCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
        return scanner.nextLine();
    }

    public static int inputMessageAboutTry() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public static void outputMessageAboutMove(List<Driver> drivers, int numOfTry) {
        System.out.println();
        System.out.println("실행 결과");
        for (int i=0; i<numOfTry; i++) {
            drivers.stream().forEach(driver -> driver.drive(RandomGenerator.generate()));
            System.out.println();
        }
    }

    public static void outputMessageAboutWinner(List<Driver> drivers, int winnerScore) {
        String resultMessage = new StringBuilder()
                .append(getWinners(drivers, winnerScore))
                .append("가 최종 우승했습니다").toString();
        System.out.println(resultMessage);
    }

    private static String getWinners(List<Driver> drivers, int winnerScore) {
        return   drivers.stream()
                .filter(driver->driver.getDistanceSize()==winnerScore)
                .map(driver -> driver.getCarName())
                .collect(Collectors.joining(", "));
    }
}
