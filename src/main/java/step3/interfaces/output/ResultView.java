package step3.interfaces.output;

import step3.application.SimulationResult;
import step3.domain.RacingCar;
import step3.domain.RacingMap;
import step3.domain.Snapshot;

import java.util.List;

public class ResultView {
    private static final char MOVE_CHAR = '-' ;
    private static final String NEWLINE = "\n";
    private static final String RESULT_ANNOUNCEMENT = NEWLINE + "실행결과" + NEWLINE;
    private static final String ROUND_ANNOUNCEMENT = "라운드";
    private final String view;


    public ResultView(final SimulationResult simulationResult) {
        final StringBuilder viewBuilder = new StringBuilder(RESULT_ANNOUNCEMENT);
        final List<Snapshot> snapshots = simulationResult.getSnapshots();
        final List<RacingCar> racingCars = simulationResult.getRacingCars();

        for (Snapshot snapshot : snapshots) {
            final RacingMap racingMap = snapshot.getRacingMap();
            viewBuilder.append(createRoundView(snapshot));
            viewBuilder.append(NEWLINE);
            viewBuilder.append(createRoundResultView(racingCars, racingMap));
            viewBuilder.append(NEWLINE);
        }

        this.view = viewBuilder.toString();
    }

    private String createRoundView(final Snapshot snapshot) {
        return ROUND_ANNOUNCEMENT + " " + (snapshot.getNumber() + 1);
    }

    private String createRoundResultView(final List<RacingCar> racingCars, final RacingMap racingMap) {
        final StringBuilder roundResultViewBuilder = new StringBuilder();
        for (RacingCar racingCar : racingCars) {
            final int racingCarId = racingCar.getId();
            final int position = racingMap.findPosition(racingCarId);
            roundResultViewBuilder.append(createMoveView(position));
            roundResultViewBuilder.append(NEWLINE);
        }
        return roundResultViewBuilder.toString();
    }

    private String createMoveView(final int position) {
        return createMovingDistanceView(position);
    }

    private String createMovingDistanceView(final int position) {
        final StringBuilder movingDistanceViewBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            movingDistanceViewBuilder.append(MOVE_CHAR);
        }
        return movingDistanceViewBuilder.toString();
    }

    @Override
    public String toString() {
        return view;
    }
}
