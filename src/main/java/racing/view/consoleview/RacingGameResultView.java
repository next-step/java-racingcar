package racing.view.consoleview;

import racing.dto.CarRoundResult;
import racing.domain.RacingGameResult;
import racing.dto.RacingGameRoundResult;

import java.util.List;

public class RacingGameResultView {

    private final static String PRINT_CAR_PISITION = "-";

    public static void raceResultView(RacingGameResult racingGameResult) {
        System.out.println("실행 결과");

        for (RacingGameRoundResult racingGameRoundResult : racingGameResult.printRoundHistory()) {
            printCarRound(racingGameRoundResult.getCarResults());
            System.out.println();
        }

        // 최종우승
        List<String> winners = racingGameResult.findRacingWinner();
        System.out.println(String.join(",", winners) + "가 최종 우승하셨습니다.");
    }

    // 라운드별 출력
    public static void printCarRound(List<CarRoundResult> carRoundResults) {
        for (CarRoundResult carRoundResult : carRoundResults) {
            System.out.print(carRoundResult.getCarName() + " : ");

            for (int i = 0; i < carRoundResult.getMovePosition(); i++) {
                System.out.print(PRINT_CAR_PISITION);
            }
            System.out.println();
        }
    }
}