package racingcar.view;

import racingcar.domain.RacingCarPositions;
import racingcar.domain.RacingCar;
import racingcar.utils.Const;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
    public static void results(List<RacingCar> racingCars, List<RacingCarPositions> racingCarPositions) {
        System.out.println("실행결과");
        racingCarPositions.forEach(carPosition -> {
            IntStream.range(Const.INITIAL_NUM, carPosition.get().size())
                    .forEach(position -> {
                                String print = String.format("%s : %s", racingCars.get(position).getCarName(), carPosition.get().get(position));
                                System.out.println(print);
                            }
                    )
            ;
            System.out.println();
        });
    }

    public static void whoIsWinner(List<RacingCar> racingCars) {
        int winnerStep = getWinnerStep(racingCars);
        List<String> winnerNames = getWinnerNames(racingCars, winnerStep);
        System.out.println(String.join(Const.SYMBOL_COMMA, winnerNames) + "가 최종 우승했습니다.");
    }

    private static List<String> getWinnerNames(List<RacingCar> racingCars, int winnerStep) {
        List<String> winnerNames = new ArrayList<>();
        for (int i = Const.INITIAL_NUM; i < racingCars.size(); i++) {
            if (racingCars.get(i).getPosition() == winnerStep) {
                winnerStep = racingCars.get(i).getPosition();
                winnerNames.add(racingCars.get(i).getCarName());
            }
        }
        return winnerNames;
    }

    private static int getWinnerStep(List<RacingCar> racingCars) {
        int winnerStep = Const.INITIAL_NUM;
        for (int i = Const.INITIAL_NUM; i < racingCars.size(); i++) {
            if (racingCars.get(i).getPosition() > winnerStep) {
                winnerStep = racingCars.get(i).getPosition();
            }
        }
        return winnerStep;
    }
}