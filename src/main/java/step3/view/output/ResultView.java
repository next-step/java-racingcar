package step3.view.output;

import step3.application.SimulationResult;
import step3.domain.RacingCar;
import step3.domain.RacingMap;
import step3.domain.Snapshot;

import java.util.List;

public class ResultView {
    private static final char MOVE_CHAR = '-';
    private static final String NEWLINE = "\n";
    private static final String RESULT_ANNOUNCEMENT = NEWLINE + "실행결과" + NEWLINE;
    private static final String ROUND_ANNOUNCEMENT = "라운드";
    
    private ResultView() {
        throw new AssertionError();
    }

    public static void print(final SimulationResult simulationResult) {
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

        Printer.print(viewBuilder.toString());
    }

    private static String createRoundView(final Snapshot snapshot) {
        return ROUND_ANNOUNCEMENT + " " + (snapshot.getNumber() + 1);
    }

    private static String createRoundResultView(final List<RacingCar> racingCars, final RacingMap racingMap) {
        final StringBuilder roundResultViewBuilder = new StringBuilder();
        for (RacingCar car : racingCars) {
            final int position = racingMap.findPosition(car);
            roundResultViewBuilder.append(createMoveView(position));
            roundResultViewBuilder.append(NEWLINE);
        }
        return roundResultViewBuilder.toString();
    }

    private static String createMoveView(final int position) {
        return createMovingDistanceView(position);
    }

    private static String createMovingDistanceView(final int position) {
        final StringBuilder movingDistanceViewBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            movingDistanceViewBuilder.append(MOVE_CHAR);
        }
        return movingDistanceViewBuilder.toString();
    }
}
