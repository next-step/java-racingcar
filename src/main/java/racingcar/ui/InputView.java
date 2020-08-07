package racingcar.ui;

import resource.StringResources;

public class InputView {

    private final InputAvailable inputAvailable;

    private String names;
    private int numberOfCars;
    private int tryCount;

    public InputView(InputAvailable inputAvailable) {
        this.inputAvailable = inputAvailable;
        printInputView();
    }

    private void printInputView() {
        System.out.println(StringResources.INPUT_CAR_NAME);
        names = inputAvailable.inputNames();

        System.out.println(StringResources.INPUT_NUMBER_OF_CARS);
        numberOfCars = inputAvailable.inputNumberOfCars();

        System.out.println(StringResources.INPUT_TRY_COUNT);
        tryCount = inputAvailable.inputTryCount();
    }

    public String getNames() {
        return names;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getTryCount() {
        return tryCount;
    }
}
