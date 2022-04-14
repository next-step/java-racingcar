package racingcar.ui;

import racingcar.domain.Cars;

import java.util.List;
import java.util.Map;

public class OutputView {

    private OutputView() {
        throw new AssertionError();
    }

    public static void printRaceStart() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printCurrentPositions(Cars cars) {
        Map<String, Integer> nameToPosition = cars.getNameToPosition();
        nameToPosition.forEach(OutputView::printCurrentPosition);
        System.out.println();
    }

    private static void printCurrentPosition(String name, int position) {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinCarNames(List<String> winCarNames) {
        StringBuilder sb = new StringBuilder();
        winCarNames.forEach(name -> sb.append(name + ","));
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb + " 이(가) 최종 우승했습니다");
    }
}
