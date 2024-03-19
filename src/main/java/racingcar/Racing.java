package racingcar;

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
        for (int i = 0; i < (opportunity - 1); i++) {
            carGroup.updateCarArrayPosition();
            outputView.printCarGroupPosition(carGroup);
        }
        outputView.printWinner(carGroup);
    }

    public static void main(String[] args) {
        Racing racing = new Racing();
        racing.race();
    }


}
