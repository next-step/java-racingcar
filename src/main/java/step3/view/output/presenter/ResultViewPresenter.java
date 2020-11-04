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

    private final List<RoundResultViewPresenter> roundResults;

    public ResultViewPresenter(final SimulationResult simulationResult) {
        final List<Snapshot> snapshots = simulationResult.getSnapshots();
        final List<RacingCar> racingCars = simulationResult.getRacingCars();

        this.roundResults = snapshots.stream().map(snapshot -> {
            final RacingMap racingMap = snapshot.getRacingMap();
            final List<CarDTO> cars = racingCars.stream()
                    .map(racingCar -> new CarDTO(racingCar.getName(), racingMap.findPosition(racingCar)))
                    .collect(Collectors.toList());
            return new RoundResultViewPresenter(snapshot.getNumber(), cars);
        }).collect(Collectors.toList());
    }

    @Override
    public String present() {
        final String result = roundResults.stream()
                .map(RoundResultViewPresenter::present)
                .collect(Collectors.joining());
        return RESULT_ANNOUNCEMENT + result;
    }
}
