package study.step3;

import study.step3.constant.RacingConst;
import study.step3.ui.InputView;
import study.step3.utils.Printer;

public class RacingService {
    private InputView inputView;

    public RacingService() {
        inputView = new InputView();
    }

    public void play() {
        int carCount = inputView.inputCount(RacingConst.MESSAGE_INPUT_CAR);
        int round = inputView.inputCount(RacingConst.MESSAGE_INPUT_ROUND);

        Racing racing = new Racing();
        racing.setUp(carCount);

        Printer.println(RacingConst.MESSAGE_RACING_START);
        for(int i=0; i<round; i++) {
            Printer.println((i+1) + RacingConst.MESSAGE_ROUND);
            racing.run();
        }
    }
}
