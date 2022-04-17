package racing.view;

import exception.CustomException;
import racing.module.Car;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String STARTING_LINE = " : ";
    private static final String CAR_POSITION_BAR = "-";
    private static final String NEW_LINE = "\n";
    private static final String COMMA = ",";
    private static final String WINNER_MESSAGE_START = "최종 우승자는 ";
    private static final String WINNER_MESSAGE_END = "입니다.";

    private OutputView() throws CustomException {
        throw new CustomException("유틸성클래스는 인스턴스 생성을 할 수 없습니다.");
    }

    public static void startPrint() {
        System.out.println("\n실행결과");
    }

    public static void nextline() {
        System.out.println("\n");
    }

    public static void printCarsPosition(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getCarName());
            System.out.print(STARTING_LINE);
            printCarPosition(car.getPosition());
            System.out.print(NEW_LINE);
        }

    }

    public static void printCarPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print(CAR_POSITION_BAR);
        }
    }

    public static void printWinner(List<Car> carList) {
        System.out.print(WINNER_MESSAGE_START);
        System.out.print(carList.stream().map(Car::getCarName).collect(Collectors.joining(",")));
        System.out.print(WINNER_MESSAGE_END);
        System.out.print(NEW_LINE);
    }
}
