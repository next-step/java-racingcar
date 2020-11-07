package step5.worker.interfaces.presenter;

import step5.worker.application.SimulationResponse;
import step5.worker.domain.Snapshot;
import step5.worker.interfaces.render.RoundResultViewRender;
import step5.worker.interfaces.render.WinnerResultViewRender;

import java.util.List;
import java.util.stream.Collectors;

import static step5.worker.interfaces.render.ViewString.RESULT_ANNOUNCEMENT;

public class ResultViewPresenter {
    public String present(final SimulationResponse response) {
        final List<RoundResultViewRender> roundResultViewRenders = createRoundResultViewRenders(response);
        final WinnerResultViewRender winnerResultViewRender = new WinnerResultViewRender(response.getWinners());

        final String roundResultView = createRoundResultView(roundResultViewRenders);
        final String winnerResultView = winnerResultViewRender.render();
        return RESULT_ANNOUNCEMENT + roundResultView + winnerResultView;
    }

    private List<RoundResultViewRender> createRoundResultViewRenders(final SimulationResponse response) {
        final List<Snapshot> snapshots = response.getSnapshots();
        return snapshots.stream()
                .map(Snapshot::getCars)
                .map(RoundResultViewRender::new)
                .collect(Collectors.toList());
    }
    
    private String createRoundResultView(final List<RoundResultViewRender> roundResultViewRenders) {
        return roundResultViewRenders.stream()
                .map(RoundResultViewRender::render)
                .collect(Collectors.joining());
    }
}
