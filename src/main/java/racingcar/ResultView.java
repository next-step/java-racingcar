package racingcar;

import java.util.stream.Collectors;

public class ResultView {

    public static void print(GameResult result) {
        System.out.println("실행 결과\n");

        for (int i = 0; i < result.countRoundLength(); i++) {
            Round round = result.getRound(i);
            System.out.println(displayTraces(round) + "\n");
        }

        System.out.println(result.getWinnerId() + "가 최종 우승했습니다.");
    }

    private static String displayTraces(Round round) {
        return round.cars.stream()
                .map(it -> displayTrace(it))
                .collect(Collectors.joining("\n"));
    }

    private static String displayTrace(Car car) {
        String trace = car.getId() + " : ";
        for (int i = 0; i < car.getPosition(); i++) {
            trace += "-";
        }
        return trace;
    }
}
