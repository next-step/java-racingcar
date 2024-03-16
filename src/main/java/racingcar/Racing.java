package racingcar;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Racing {
    InputView inputView;
    OutputView outputView;
    CarArray carArray;

    public Racing(CarArray carArray) {
        this.carArray = carArray;
        outputView = new OutputView(carArray);
    }

    public void race() {
        InputStream userInputNumOfCar = new ByteArrayInputStream("2".getBytes());
        System.setIn(userInputNumOfCar);
        carArray.resizeCarArray(inputView.numberOfCar());

        InputStream userInputOpportunity = new ByteArrayInputStream("3".getBytes());
        System.setIn(userInputOpportunity);
        int opportunity = inputView.opportunity();


        for(int i = 0; i < opportunity; i++)
        {
            outputView.printCarArrayPosition();
            carArray.updateCarArrayPosition();
        }
    }
}
