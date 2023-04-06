package step3;

import step3.domain.Position;
import step3.domain.RacingCar;
import step3.domain.Repetitions;
import step3.strategy.MoveStrategy;
import step3.view.InputView;
import step3.view.PrintView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final boolean CONTINUE_FLAG = true;
    private static final boolean FINISH_FLAG = false;
    private static final int RACING_CAR_FIRST_INDEX = 0;
    private final InputView inputView;
    private final PrintView printView;
    private final MoveStrategy moveStrategy;
    private boolean flag;


    public RacingGame(
            InputView inputView
            , PrintView printView
            , MoveStrategy moveStrategy
    ) {
        this.inputView = inputView;
        this.printView = printView;
        this.moveStrategy = moveStrategy;
    }

    public void execute() {
        play(prepare());
    }

    public List<RacingCar> prepare() {
        showIntro();
        switchFlag(CONTINUE_FLAG);
        return makeRacingCarList();
    }

    public void play(List<RacingCar> racingCarList) {

        while (flag) {
            racingCarList.forEach(RacingCar::move);
            Repetitions repetitions = Repetitions._INSTANCE.record(racingCarList);
            printView.print(repetitions);
            isContinue(repetitions);
        }
    }

    public void stop() {
        switchFlag(FINISH_FLAG);
    }

    public void isContinue(Repetitions repetitions) {
        if (repetitions.isLastReps(inputView.getNumberOfReps())) {
            stop();
        }
    }

    private void showIntro() {
        inputView.requestNumberOfCar();
        inputView.requestNumberOfTry();
    }

    private void switchFlag(boolean flag) {
        this.flag = flag;
    }

    private List<RacingCar> makeRacingCarList() {
        ArrayList<RacingCar> racingCarList = new ArrayList<>();

        for (int index = RACING_CAR_FIRST_INDEX; index < inputView.getNumberOfCars(); index++) {
            racingCarList.add(RacingCar.of(moveStrategy, new Position()));
        }
        return racingCarList;
    }
}
