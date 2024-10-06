package carracing.view;

import carracing.domain.car.Car;
import carracing.domain.record.RoundRecord;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public void showCarRacingResult(List<RoundRecord> roundRecords) {
        System.out.println("\n실행 결과");

        for (RoundRecord roundRecord : roundRecords) {
            showRoundResult(roundRecord);
        }

    }

    private void showRoundResult(RoundRecord roundRecord) {

        for (Car carRecord : roundRecord.getCars()) {
            System.out.printf("%-5s : %s%n", carRecord.getName(), "-".repeat(carRecord.getPosition().getValue()));
        }

        System.out.println();
    }

    public void showWinnerNames(List<Car> cars) {
        List<String> winnerNames = cars.stream()
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList());

        System.out.printf("%s가 최종 우승했습니다.", String.join(", ", winnerNames));
    }
}
