package step3;

import step3.domain.RacingCar;
import step3.domain.RacingInformation;
import step3.domain.Repetitions;
import step3.strategy.move.MoveStrategy;
import step3.view.InputView;
import step3.view.PrintView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class RacingGame {
    private static final String FORCED_TERMINATION_USER_GUIDE = "사용자에 의해 프로그램이 종료되었습니다";

    private static final int ZERO = 0;
    private final InputView inputView;
    private final PrintView printView;
    private final MoveStrategy moveStrategy;

    private RacingGame(
            InputView inputView
            , PrintView printView
            , MoveStrategy moveStrategy
    ) {
        this.inputView = inputView;
        this.printView = printView;
        this.moveStrategy = moveStrategy;
    }

    public static RacingGame of(
            InputView inputView
            , PrintView printView
            , MoveStrategy moveStrategy
    ) {
        return new RacingGame(inputView, printView, moveStrategy);
    }

    public void execute() {
        RacingInformation racingInformation = inputView.execute();
        List<Repetitions> repetitionsList = play(makeRacingCarList(racingInformation), racingInformation);
        printView.printAll(repetitionsList);
    }

    public List<Repetitions> play(List<RacingCar> racingCarList, RacingInformation racingInformation) {
        List<Repetitions> repetitionsList = new ArrayList<>();
        IntStream.range(ZERO, racingInformation.getNumberOfReps())
                .forEach(reps -> {
                    racingCarList.forEach(RacingCar::move);
                    repetitionsList.add(Repetitions.recordOf(reps, Collections.unmodifiableList(racingCarList)));
                });

        return repetitionsList;
    }

    public void stop() {
        throw new RuntimeException(FORCED_TERMINATION_USER_GUIDE);
    }

    private List<RacingCar> makeRacingCarList(RacingInformation racingInformation) {
        List<RacingCar> racingCarList = new ArrayList<>();

        for (int racingCarIndex = ZERO; racingCarIndex < racingInformation.getNumberOfCars(); racingCarIndex++) {
            racingCarList.add(RacingCar.of(moveStrategy));
        }

        return racingCarList;
    }
}
