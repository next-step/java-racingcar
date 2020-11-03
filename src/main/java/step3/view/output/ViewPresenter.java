package step3.view.output;

import step3.application.SimulationResult;
import step3.domain.RacingCar;
import step3.domain.RacingMap;
import step3.domain.Snapshot;
import step3.view.dto.CarDTO;
import step3.view.dto.RoundResultDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ViewPresenter implements Presenter {
    private static final String NEWLINE = "\n";
    private static final String RESULT_ANNOUNCEMENT = NEWLINE + "실행결과" + NEWLINE;

    private final List<RoundResultDTO> roundResults;

    public ViewPresenter(final SimulationResult simulationResult) {
        final List<Snapshot> snapshots = simulationResult.getSnapshots();
        final List<RacingCar> racingCars = simulationResult.getRacingCars();

        this.roundResults = snapshots.stream().map(snapshot -> {
            final RacingMap racingMap = snapshot.getRacingMap();
            final List<CarDTO> cars = racingCars.stream()
                    .map(racingCar -> new CarDTO(racingCar.getName(), racingMap.findPosition(racingCar)))
                    .collect(Collectors.toList());
            return new RoundResultDTO(snapshot.getNumber(), cars);
        }).collect(Collectors.toList());
    }

    @Override
    public String present() {
        final String result = roundResults.stream()
                .map(roundResult -> roundResult.createRoundAnnounceView() + NEWLINE + roundResult.createRoundResultView() + NEWLINE)
                .collect(Collectors.joining());
        return RESULT_ANNOUNCEMENT + result;
    }
}
