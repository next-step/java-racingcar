package racing.controller;

import racing.domain.Racing;
import racing.domain.RacingHost;
import racing.dto.RacingReport;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.List;

public class RacingController {

    private final InputView inputView;
    private final ResultView resultView;
    private final RacingHost racingHost;

    public RacingController(InputView inputView, ResultView resultView, RacingHost racingHost) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.racingHost = racingHost;
    }

    public void run() {
        List<String> names = inputView.getNames();
        int round = inputView.getRound();

        validateNames(names);
        validateRound(round);

        Racing racing = racingHost.holdRacing(names, round);
        RacingReport racingReport = racing.start();

        resultView.printRacingReport(racingReport);
    }

    private void validateNames(List<String> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("이름을 입력해주세요.");
        }
    }

    private void validateRound(int round) {
        if (round <= 0) {
            throw new IllegalArgumentException("최소 한 번 이상은 움직여야 합니다.");
        }
    }

}
