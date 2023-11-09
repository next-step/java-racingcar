package study.racingcar;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printRequestTextInitCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public void printRequestTextInitRound() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public void printRoundResult() {
        System.out.println("실행 결과");
    }

    public void printInteger(int number) {
        System.out.println(number);
    }

    public void printEnter() {
        System.out.println();
    }

    public <T> void printListMapValues(List<Map<T, String>> listMap) {
        listMap.forEach(map -> {
            map.forEach((t, s) -> {
                System.out.println(s);
            });
            System.out.println("\n");
        });
    }
}
