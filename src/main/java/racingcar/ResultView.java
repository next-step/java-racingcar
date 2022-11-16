package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private ResultView() {
        throw new RuntimeException("인스턴스화가 불가능한 클래스입니다.");
    }

    public static void printCars(CarGameInfo gameInfo, int count) {
        for (int i=0 ; i<count ; i++) {
            gameInfo.printCars(i);
            System.out.println();
        }
    }

    public static void printWinners(CarGameInfo gameInfo) {
        List<Car> winners = gameInfo.getWinnerList();
        String winnersName = winners.stream().map(Car::getName).collect(Collectors.joining(", "));
        System.out.println(winnersName + "가 최종 우승하였습니다.");
    }

}
