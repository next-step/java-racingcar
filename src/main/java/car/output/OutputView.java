package car.output;

import car.domain.CarResult;
import java.util.List;
import car.domain.Car;
import car.domain.Cars;

public final class OutputView {

    private static final String EXECUTE_RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_WINNER_MESSAGE = "가 최종 우승했습니다.";

    public static void printResult() {
        System.out.println(EXECUTE_RESULT_MESSAGE);
    }

    public static void printEachRaceResult(Cars cars) {
        cars.getCars().stream().forEach(car ->
            System.out.println(new CarResult(car))
        );
        System.out.println();
    }

    public static void printWinner(List<Car> winner) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < winner.size() - 1; i++) {
            sb.append(winner.get(i).getName()).append(", ");
        }
        sb.append(winner.get(winner.size() - 1).getName()).append(" ");
        sb.append(FINAL_WINNER_MESSAGE);
        System.out.println(sb.toString());
    }
}