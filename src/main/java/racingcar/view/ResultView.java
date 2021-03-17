package racingcar.view;

import java.util.List;
import java.util.stream.IntStream;

public enum ResultView {

    INSTANCE;

    private final String RESULT_STATEMENT = "실행 결과";
    private final String COLON = " : ";
    private final String WINNERS_STATEMENT = "가 최종 우승했습니다.";
    private final String COMMA = ", ";

    public void printResultStatement() {
        System.out.println();
        System.out.println(RESULT_STATEMENT);
    }

    public void printEachRoundResult(List<String> CarsName, List<Integer> CarsPosition) {
        int CarsCount = CarsName.size();

        for (int i = 0; i < CarsCount; i++) {
            String name = CarsName.get(i);
            System.out.print(name + COLON);
            Integer movementRange = CarsPosition.get(i);
            IntStream.range(0, movementRange)
                    .mapToObj(j -> "-")
                    .forEach(System.out::print);
            System.out.println();
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String nameOfWinners = String.join(COMMA, winners);
        System.out.println(nameOfWinners + WINNERS_STATEMENT);
    }
}
