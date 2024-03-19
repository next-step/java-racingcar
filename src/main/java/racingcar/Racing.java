package racingcar;

import java.util.Random;

public class Racing {

    InputView inputView;
    OutputView outputView;
    CarGroup carGroup;

    public Racing() {
        inputView = new InputView();
        outputView = new OutputView();
        carGroup = new CarGroup(inputView.CarNames());
    }

    public void race() {
        int opportunity = inputView.opportunity();
        outputView.printCarGroupPosition(carGroup);

        Random random = new Random();
        int randomValue = random.nextInt(10);

        for (int i = 0; i < (opportunity - 1); i++) {
            carGroup.updateCarArrayPosition(randomValue);
            outputView.printCarGroupPosition(carGroup);
        }

        outputView.printWinner(carGroup);
    }
}
