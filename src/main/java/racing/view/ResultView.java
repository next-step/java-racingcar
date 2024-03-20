package racing.view;

import java.util.List;
import java.util.stream.Collectors;
import racing.domain.Car;
import racing.domain.Cars;

public class ResultView {

    public static void end() {
        System.out.println("===============레이스가 종료되었습니다.===============");
    }

    public static void start() {
        System.out.println("===============레이스 시작!!!===============");
    }

    public static void round(int i) {
        System.out.println(String.format("===============ROUND [%s]===============", i));
    }

    public static void showWinner(Cars cars) {
        System.out.println(
            String.format("===============최종 우승자 [%s]===============", cars.getWinner()));
    }
}
