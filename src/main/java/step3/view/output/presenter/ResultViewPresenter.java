package step3.view.output.presenter;

import step3.application.SimulationResult;
import step3.domain.RacingCar;
import step3.domain.RacingMap;
import step3.domain.Snapshot;
import step3.view.dto.CarDTO;

import java.util.List;
import java.util.stream.Collectors;

import static step3.view.ViewString.RESULT_ANNOUNCEMENT;

public class ResultViewPresenter implements Presenter {
    private final List<RoundResultViewPresenter> roundResultViewPresenters;
    private final WinnerResultViewPresenter winnerResultViewPresenter;

    public ResultViewPresenter(final SimulationResult simulationResult) {
        final List<Snapshot> snapshots = simulationResult.getSnapshots();
        final List<RacingCar> racingCars = simulationResult.getRacingCars();

        this.roundResultViewPresenters = snapshots.stream().map(snapshot -> {
            final RacingMap racingMap = snapshot.getRacingMap();
            final List<CarDTO> cars = racingCars.stream()
                    .map(racingCar -> new CarDTO(racingCar.getName(), racingMap.findPosition(racingCar)))
                    .collect(Collectors.toList());
            return new RoundResultViewPresenter(cars);
        }).collect(Collectors.toList());
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
