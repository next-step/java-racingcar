package racing;

import racing.domain.CarGroup;
import racing.view.InputView;

public class Game {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        CarGroup carGroup = new CarGroup(inputView.getCarCount());
        carGroup.print(inputView.getrepeatCount());
    }
}
