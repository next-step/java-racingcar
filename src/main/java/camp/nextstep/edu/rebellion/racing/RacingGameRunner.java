package camp.nextstep.edu.rebellion.racing;

import camp.nextstep.edu.rebellion.racing.domain.RacingGame;
import camp.nextstep.edu.rebellion.racing.domain.Record;
import camp.nextstep.edu.rebellion.racing.util.StringUtil;
import camp.nextstep.edu.rebellion.racing.view.InputView;
import camp.nextstep.edu.rebellion.racing.view.ResultView;

public class RacingGameRunner {
    public static void main(String[] args) {
        String cars = InputView.getCarNames();
        int rounds = InputView.getRounds();

        RacingGame game = new RacingGame(StringUtil.convertList(cars, ","), rounds);
        Record record = game.start();

        ResultView.showResult(record);
    }
}
