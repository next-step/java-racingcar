package carracing.view;

import carracing.model.Car;
import carracing.model.Cars;

public class Output {
    private static final int CAR_POSITION_FIRST_INDEX = 0;
    private static final String DASH = "-";
    private static final String CAR_NAME_POSITION_SEPARATOR = " : ";
    private static final String WINNER_SEPARATOR = ", ";

    public static void showInputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void showInputRacingCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    private static StringBuilder progressCarPosition(int position) {
        StringBuilder line = new StringBuilder();
        for (int i = CAR_POSITION_FIRST_INDEX; i < position; i++) {
            line.append(DASH);
        }
        return line;
    }

    public static void showCarStatus(Car car) {
        StringBuilder carStatusBuilder = new StringBuilder();
        System.out.println(carStatusBuilder.append(car.getName()).append(CAR_NAME_POSITION_SEPARATOR)
                .append(progressCarPosition(car.getPosition())));
    }

    public static void showWinners(Cars cars) {
        StringBuilder winnersBuilder = new StringBuilder();
        System.out.println(winnersBuilder.append("최종 우승자: ")
                .append(String.join(WINNER_SEPARATOR, cars.makeWinners())));
    }

    public static void breakNewLine() {
        System.out.println();
    }
}
