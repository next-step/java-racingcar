package racingcar;

import java.util.stream.Collectors;

public class ResultView {

    static void printTraces(GameResult result) {
        System.out.println("실행 결과\n");
        System.out.println(getCarTraces(result));
    }

    static String getCarTraces(GameResult result) {
        return result.getRounds().stream()
                .map(round -> getCarTraces(round))
                .collect(Collectors.joining("\n"));
    }

    private static String getCarTraces(Round round) {
        return round.getCars().stream()
                .map(carDTO -> getCarTrace(carDTO))
                .collect(Collectors.joining("\n"));
    }

    static String getCarTrace(CarDTO carDTO) {
        String trace = carDTO.getName() + " : ";
        for (int i = 0; i < carDTO.getPosition(); i++) {
            trace += "-";
        }
        return trace;
    }

    static void printWinner(GameResult result) {
        Winners winners = result.getWinners();
        System.out.println(winners.getWinnersName() + "가 최종 우승했습니다.");
    }
}
