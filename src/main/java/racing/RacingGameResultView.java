package racing;
import java.util.List;

public class RacingGameResultView {

    private final static String PRINT_CAR_PISITION = "-";

    public static void racingResultView(RacingGame rg) {
        RacingGameResult rgr = rg.racingGameResult();
        System.out.println("실행 결과");
        int beforeRoundNo = 1;
        for (CarRoundResult roundResult : rgr.printRoundHistory()) {
            // 라운드별 개행
            if (roundResult.getRoundNo() != beforeRoundNo) {
                System.out.println();
            }

            System.out.print(roundResult.getCar().getCarName() + " : ");
            for (int i = 0; i < roundResult.getMovePoint(); i++) {
                System.out.print(PRINT_CAR_PISITION);
            }
            System.out.println();

            beforeRoundNo = roundResult.getRoundNo();
        }

        // 최종우승
        List<String> winners = rg.winnerRacingGame();
        System.out.println(String.join(",", winners) + "가 최종 우승하셨습니다.");
    }
}