package racing;

import racing.domain.Car;
import racing.domain.CarGroup;
import racing.message.ViewMsg;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.stream.IntStream;

public class Game {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        CarGroup carGroup = new CarGroup(inputView.getCarCount());
        carGroup.print(inputView.getrepeatCount());
    }
}
