package racing.view;

import utils.StringUtils;

import java.util.Map;

public class RacingResultView {

    private static final String RACE_MACHINE_STATUS_BAR = "-";

    public void viewRound(Map<Integer, Integer> lapMapStatus) {
        lapMapStatus.forEach((raceMachineId, lap) -> {
            String machineLapView = StringUtils.repeat(RACE_MACHINE_STATUS_BAR, lap);
            System.out.println(machineLapView);
        });
        System.out.println();
    }

    public void ready(Map<Integer, Integer> lapMapStatus) {
        System.out.println("\n실행 결과");
        viewRound(lapMapStatus);
    }
}
