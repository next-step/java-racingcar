package racingcar;

public class Racing {

    private InputView inputView;
    private OutputView outputView;
    private CarGroup carGroup;

    public Racing() {
        inputView = new InputView();
        outputView = new OutputView();
        carGroup = new CarGroup(inputView.names());
    }

    public void race() {
        int opportunity = inputView.opportunity();
        outputView.printCarGroupPosition(carGroup);


        for (int i = 0; i < (opportunity - 1); i++) {
            carGroup.updateCarGroupPosition();
            outputView.printCarGroupPosition(carGroup);
        }

        outputView.printWinner(carGroup);
    }
}
