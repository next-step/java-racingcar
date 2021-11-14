package com.rick.racing.core;

import com.rick.racing.model.CarRecordHistory;
import com.rick.racing.model.RacingPlayData;
import com.rick.racing.model.RacingResult;
import com.rick.racing.ui.InputView;
import com.rick.racing.ui.ResultView;
import java.util.Random;
import java.util.function.Supplier;

public class CarRacingCore {

    public static final int RANDOM_BOUND = 10;
    public static final int GO_THRESHOLD = 4;
    private final InputView inputView;
    private final ResultView resultView;
    private final Random random;

    public CarRacingCore() {
        inputView = new InputView();
        resultView = new ResultView();
        random = new Random();
    }

    public void start() {
        RacingPlayData racingPlayData = inputView.getGameDataFromUser();
        resultView.showResult(racingPlayData, doGame(racingPlayData, this::isGo));
    }

    public RacingResult doGame(RacingPlayData racingPlayData, Supplier<Boolean> goOrStopSupplier) {
        RacingResult racingResult = new RacingResult();

        for (int carIndex = 0; carIndex < racingPlayData.getCarCount(); carIndex++) {
            CarRecordHistory carRecordHistory = new CarRecordHistory();
            for (int tryIndex = 0; tryIndex < racingPlayData.getTryCount(); tryIndex++) {
                carRecordHistory.addHistory(goOrStopSupplier.get());
            }
            racingResult.addRecord(carRecordHistory);

        }
        return racingResult;
    }

    private boolean isGo() {
        return random.nextInt(RANDOM_BOUND) >= GO_THRESHOLD;
    }
}
