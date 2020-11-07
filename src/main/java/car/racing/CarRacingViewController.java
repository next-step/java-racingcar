package car.racing;


import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class CarRacingViewController {

    private static final String DELIMITER = ",";

    private final ResultViewContract resultView;
    private final CarRacingManager carRacingManager;

    public CarRacingViewController(ResultViewContract resultView, CarRacingManager carRacingManager) {
        this.resultView = resultView;
        this.carRacingManager = carRacingManager;
    }

    public void input(String names, int tryCount) {
        String[] carNames = names.split(DELIMITER);
        if (!isValidInput(carNames)) {
            throw new IllegalArgumentException("잘못된 이름 입니다.");
        }

        carRacingManager.setupCars(carNames);
        showRacingResult(tryCount);
        showRacingWinners();
    }

    private void showRacingResult(int tryCount) {
        resultView.resultTitle();
        IntStream.range(0, tryCount)
                .forEach(i -> {
                    resultView.forward(carRacingManager.forwardEachCar());
                    resultView.newLine();
                });
    }

    private void showRacingWinners() {
        StringBuilder winnersStrBuilder = new StringBuilder();

        List<String> winnerNames = carRacingManager.racingWinners();
        IntStream.range(0, winnerNames.size())
                .forEach(i -> winnersStrBuilder
                        .append(winnerNames.get(i))
                        .append(delimiterOrNot(i, winnerNames.size())));
        resultView.winners(winnersStrBuilder.toString());
    }

    private String delimiterOrNot(int index, int size) {
        if (index == size -1) {
            return "";
        }
        return ", ";
    }

    private boolean isValidInput(String[] carNames) {
        return Arrays.stream(carNames).allMatch(carName -> carName.length() <= 5);
    }
}