package racingcar.controller;

import java.util.logging.Logger;

public class ResultView {

    private static final Logger logger = Logger.getLogger(ResultView.class.getName());

    private ResultView() {

    }

    public static ResultView INSTANCE = null;

    public static ResultView getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ResultView();
        }
        return INSTANCE;
    }

    public void printRacingCarsStatus(String racingCarsStatus) {
        logger.info(racingCarsStatus);
    }
}
