package racing;

import racing.domain.CarGroup;
import racing.view.InputView;

public class Game {
    public static void main(String[] args) throws Exception {
        InputView inputView = new InputView();
        CarGroup carGroup = new CarGroup(inputView.getCarNames());
        carGroup.print(inputView.getrepeatCount());
    }
}
