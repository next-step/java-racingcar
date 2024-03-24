package racingcar.controller;

import racingcar.domain.CarGroup;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Racing {

    private InputView inputView;
    private OutputView outputView;
    private CarGroup carGroup;

    public Racing() {
        inputView = new InputView();
        outputView = new OutputView();
        carGroup = new CarGroup(inputView.names());
    }

    public int opportunity() {
        int opportunity = inputView.opportunity();
        if (opportunity <= 0) {
            throw new IllegalArgumentException("경주 진행 횟수는 0보다 커야 합니다.");
        }
        outputView.printCarGroupPosition(carGroup);

        return opportunity;
    }

    public void race() {
        int opportunity = opportunity();
        outputView.printCarGroupPosition(carGroup);

        for (int i = 0; i < (opportunity - 1); i++) {
            carGroup.updateCarGroupPosition();
            outputView.printCarGroupPosition(carGroup);
        }

        outputView.printWinner(carGroup.findWinners());
    }
}
