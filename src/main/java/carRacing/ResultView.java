package carRacing;

import java.util.List;

public class ResultView {
    public static final String LINE = "-";

    public static void resultTitle() {
        System.out.println("실행 결과");
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            String line = LINE.repeat(car.getDistanceForPrint());
            System.out.println(car.getCarNameForPrint() + " : " + line);
        }
        System.out.println();
    }

    public static void printRacingWinner(List<String> nameList) {
        System.out.println(String.join(",", nameList) + " 가 최종 우승했습니다.");
    }


}
