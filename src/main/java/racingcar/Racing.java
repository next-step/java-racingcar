package racingcar;

public class Racing {
    InputView inputView;
    OutputView outputView;
    CarGroup carGroup;

    public Racing(CarGroup carGroup) {
        this.carGroup = carGroup;
        outputView = new OutputView(carGroup);
    }

    public void race() {
        carGroup.resizeCarArray(inputView.numberOfCar());
        int opportunity = inputView.opportunity();

        for(int i = 0; i < opportunity; i++)
        {
            outputView.printCarArrayPosition();
            carGroup.updateCarArrayPosition();
        }
    }

    public static void main(String[] args) {
        CarGroup carGroup = new CarGroup();

        Racing racing = new Racing(carGroup);
        racing.race();
    }
}
