package carracing;

import java.util.List;

public class Output {
    private static final String DASH = "-";

    public static void showInputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void showInputRacingCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    private static StringBuilder progressCarPosition(int position) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < position; i++) {
            line.append(DASH);
        }
        return line;
    }

    public static void showCarStatus(List<Car> cars, int racingCount) {
        for (int i = 0; i < racingCount; i++) {
            for (Car car : cars) {
                System.out.println(car + " : " + progressCarPosition(car.getPosition()));
            }
            System.out.println();
        }
    }

    public static void showWinner(CarRacing carRacing) {
        System.out.println("최종 우승자: " + carRacing.makeWinners().toString().replaceAll(
                "\\[", "").replaceAll("\\]", ""));
    }
}