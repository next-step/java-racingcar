package step3.view.output.presenter;

import step3.application.SimulationResult;
import step3.domain.Snapshot;

import java.util.List;
import java.util.stream.Collectors;

import static step3.view.ViewString.RESULT_ANNOUNCEMENT;

public class ResultViewPresenter implements Presenter {
    private final List<RoundResultViewPresenter> roundResultViewPresenters;
    private final WinnerResultViewPresenter winnerResultViewPresenter;

    public ResultViewPresenter(final SimulationResult simulationResult) {
        final List<Snapshot> snapshots = simulationResult.getSnapshots();

        this.roundResultViewPresenters = snapshots.stream()
                .map(Snapshot::getCarRacingResults)
                .map(RoundResultViewPresenter::new)
                .collect(Collectors.toList());
        this.winnerResultViewPresenter = new WinnerResultViewPresenter(simulationResult.getWinners());
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
