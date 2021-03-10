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

        validateNames(names);
        validateRound(round);

        List<Car> carList = names.stream()
                                 .map(s -> new Car(new RandomMovement(), s))
                                 .collect(Collectors.toList());

        Racing racing = new Racing(carList, round);
        RacingReport racingReport = racing.start();

        resultView.printRacingReport(racingReport);
    }

    private void validateNames(List<String> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("이름을 입력해주세요.");
        }
    }

    private void validateRound(int round) {
        if (round <= 0) {
            throw new IllegalArgumentException("최소 한 번 이상은 움직여야 합니다.");
        }
    }

}
