package racing;

import racing.car.Car;
import racing.car.RandomMovement;
import racing.dto.RacingReport;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingController {

    private final InputView inputView;
    private final ResultView resultView;

    public RacingController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        List<String> names = inputView.getNames();
        int round = inputView.getRound();

        List<Car> carList = names.stream()
                                 .map(s -> new Car(new RandomMovement(), s))
                                 .collect(Collectors.toList());

        Racing racing = new Racing(carList, round);
        RacingReport racingReport = racing.start();

        resultView.printRacingReport(racingReport);
    }

}
