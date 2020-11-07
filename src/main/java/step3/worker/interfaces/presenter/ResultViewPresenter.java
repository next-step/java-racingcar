package step3.worker.interfaces.presenter;

import step3.worker.application.SimulationResponse;
import step3.worker.domain.Snapshot;

import java.util.List;
import java.util.stream.Collectors;

import static step3.worker.interfaces.presenter.ViewString.RESULT_ANNOUNCEMENT;

public class ResultViewPresenter implements Presenter {
    private final List<RoundResultViewPresenter> roundResultViewPresenters;
    private final WinnerResultViewPresenter winnerResultViewPresenter;

    public ResultViewPresenter(final SimulationResponse simulationResponse) {
        final List<Snapshot> snapshots = simulationResponse.getSnapshots();

        this.roundResultViewPresenters = snapshots.stream()
                .map(Snapshot::getCars)
                .map(RoundResultViewPresenter::new)
                .collect(Collectors.toList());
        this.winnerResultViewPresenter = new WinnerResultViewPresenter(simulationResponse.getWinners());
    }

    @Override
    public String present() {
        final String roundResultView = roundResultViewPresenters.stream()
                .map(RoundResultViewPresenter::present)
                .collect(Collectors.joining());
        final String winnerResultView = winnerResultViewPresenter.present();
        return RESULT_ANNOUNCEMENT + roundResultView + winnerResultView;
    }
}
