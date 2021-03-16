package step5.View;

import step5.domain.Cars;
import java.util.Map;
import java.util.HashMap;

public class OutputView {

    private static Map<String, Integer> carsMap = new HashMap<>();

    public static void printStart() {
        System.out.println("실행결과");
    }

    public static void printCarMove(Cars cars) {
        Map<String, Integer> eachRoundMove = cars.eachRoundMove();
        eachRoundMove.forEach((name, position) -> {
            System.out.println(name+ ":" + replacePositionToString(position));
        });
    }

    public static void printWinner(String winners) {

        System.out.println(winners+"가 최종 우승하였습니다.");
    }

    private static String replacePositionToString(int position) {
        String replacePosition ="";
        for (int i = 0; i < position; i++) {
            replacePosition += "-";
        }
        return  replacePosition;
    }
}
