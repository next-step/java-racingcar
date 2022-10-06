package racingcar.listener;

import racingcar.domain.Car;
import racingcar.view.ConsoleResultView;
import racingcar.view.ResultView;

import java.util.List;

public class ConsoleGameEventListener implements GameEventListener {
    private final ResultView resultView = new ConsoleResultView();

    @Override
    public void onStart() {
        resultView.printStart();
    }

    @Override
    public void afterRound(List<Car> cars) {
        resultView.printRoundResult(cars);
    }

    @Override
    public void afterGame(List<String> winners) {
        resultView.printWinner(winners);
    }
}
