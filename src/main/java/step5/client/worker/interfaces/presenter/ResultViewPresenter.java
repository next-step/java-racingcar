package step5.client.worker.interfaces.presenter;

import step5.client.worker.domain.RacingGameResult;
import step5.client.worker.domain.RacingGameRoundResult;
import step5.client.worker.interfaces.render.RoundResultViewRender;
import step5.client.worker.interfaces.render.WinnerResultViewRender;

import java.util.List;
import java.util.stream.Collectors;

import static step5.client.worker.interfaces.render.ViewString.NEWLINE;

public class ResultViewPresenter {
    private static final String RESULT_ANNOUNCEMENT = NEWLINE + "실행결과" + NEWLINE;
    
    public String present(final RacingGameResult response) {
        final List<RoundResultViewRender> roundResultViewRenders = createRoundResultViewRenders(response);
        final WinnerResultViewRender winnerResultViewRender = new WinnerResultViewRender(response.getWinners());

        final String roundResultView = createRoundResultView(roundResultViewRenders);
        final String winnerResultView = winnerResultViewRender.render();
        return RESULT_ANNOUNCEMENT + roundResultView + winnerResultView;
    }

    private List<RoundResultViewRender> createRoundResultViewRenders(final RacingGameResult response) {
        final List<RacingGameRoundResult> racingGameRoundResults = response.getRacingGameRoundResults();
        return racingGameRoundResults.stream()
                .map(RacingGameRoundResult::getCars)
                .map(RoundResultViewRender::new)
                .collect(Collectors.toList());
    }

    private String createRoundResultView(final List<RoundResultViewRender> roundResultViewRenders) {
        return roundResultViewRenders.stream()
                .map(RoundResultViewRender::render)
                .collect(Collectors.joining());
    }
}
