package edu.nextstep.camp.racing.view;

import edu.nextstep.camp.racing.domain.RacingResult;

import java.util.List;
import java.util.stream.Collectors;

import static edu.nextstep.camp.racing.view.OutputView.print;

public class ConsoleRacingOutputView implements RacingOutputView {
    private static final String WINNER_GUIDE_MSG = "(이)가 최종 우승했습니다.";

    @Override
    public void racingResultView(List<RacingResult> racingResults, List<String> winners) {
        print("\n실행 결과");
        print(racingResults.stream()
                .map(RacingResult::toString)
                .collect(Collectors.joining("\n\n")));

        print("\n" + String.join(",", winners) + WINNER_GUIDE_MSG);
    }
}
