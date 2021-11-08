package racingcar.ui;

import racingcar.controller.dto.RaceResult;
import racingcar.controller.dto.RacingCarOutput;
import racingcar.utils.OutputUtils;

import java.util.List;

public class RacingCarOutputView implements OutputView {
    private static final String DASH = "-";
    private static final String EMPTY = "";

    @Override
    public void output(RacingCarOutput racingCarOutput) {
        racingCarOutput.getRaceResults().forEach(result -> {
            OutputUtils.println(String.format("%d 번째 경주", result.getCurrentRound().getRound()));
            print(result.getRaces());
        });

        OutputUtils.println(String.format("%s가 최종 우승했습니다", racingCarOutput.getWinnerName()));
    }

    public void print(List<RaceResult.Race> races) {
        races.forEach(this::print);
        OutputUtils.println(EMPTY);
    }

    private void print(RaceResult.Race race) {
        OutputUtils.print(String.format("%s : ", race.getCarName().getName()));
        for (int i = 0; i < race.getCurrentPosition().getPosition(); i++) {
            OutputUtils.print(DASH);
        }
        OutputUtils.println(EMPTY);
    }
}
