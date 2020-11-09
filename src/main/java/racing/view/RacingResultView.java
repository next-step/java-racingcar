package racing.view;

import racing.domain.LineUp;
import utils.StringUtils;

public class RacingResultView {

    private static final String RACE_MACHINE_STATUS_BAR = "-";
    private static final String READY_BANNER = "실행 결과";
    private static final String ROUND_STATUS = "%s : %s%n";
    private static final String ANNOUNCE_CHAMPION = "%s가 최종 우승했습니다.";

    private RacingResultView() {
    }

    public static void viewRound(LineUp lineUp) {
        lineUp.each(raceMachine -> {
            String machineLap = StringUtils.repeat(RACE_MACHINE_STATUS_BAR, raceMachine.getLap());
            System.out.printf(ROUND_STATUS, raceMachine.getDriverName(), machineLap);
        });
        System.out.println();
    }

    public static void ready(LineUp lineUp) {
        System.out.println(READY_BANNER);
    }

    public static void viewChampion(LineUp lineUp) {
        String championNames = lineUp.getChampionNames();
        viewRound(lineUp);
        System.out.printf(ANNOUNCE_CHAMPION, championNames);
    }
}
