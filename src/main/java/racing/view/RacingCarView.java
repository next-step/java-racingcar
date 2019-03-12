package racing.view;

import racing.domain.Car;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RacingCarView {

    public static boolean checkPattern(String text) throws RuntimeException {
        Pattern pattern = Pattern.compile("^\\s*(([a-zA-Z]+),)+([a-zA-Z]+)+\\s*$");
        Matcher matcher = pattern.matcher(text);

        if (!matcher.find()) {
            throw new RuntimeException("패턴 불일치");
        }

        return true;
    }

    public static String[] splitText(String text) {
        return text.split(",");
    }

    public static String[] parseCarNames(String text) throws RuntimeException {
        String[] names = new String[0];

        if (checkPattern(text)) {
            names = splitText(text.trim());
        }

        return names;
    }

    public static void viewCarMoveInfo(int moveDistance) {
        for (int i = 0; i < moveDistance; i++) {
            System.out.print("-");
        }
    }

    public static void viewRacingCarWinners(List<Car> winners) {
        String winner = "";
        for (Car car : winners) {
            winner += car.getName() + ", ";
        }
        System.out.println(winner.substring(0, winner.length() - 2) + "가 최종 우승했습니다.");
    }

    public static String getCarNames() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        return scanner.nextLine();
    }

    public static int getRoundCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇 회 인가요?");

        return Integer.parseInt(scanner.nextLine());
    }
}
