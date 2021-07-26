package racing.view;

import org.jetbrains.annotations.NotNull;
import racing.domain.Car;
import racing.domain.Cars;
import racing.utils.RecordPrinter;

public class GameResultView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    private final Cars cars;
    private final int count;

    public GameResultView(Cars cars, int count) {
        this.cars = cars;
        this.count = count;
    }

    public void printResult() {
        RecordPrinter.print(makeGameResult());
    }

    private String makeGameResult() {
        StringBuilder messageBuilder = new StringBuilder();
        messageBuilder.append(RESULT_MESSAGE);
        messageBuilder.append("\n");
        for (int i = 0; i < count; i++) {
            makeCarRecordResult(messageBuilder, i);
            messageBuilder.append("\n");
        }
        messageBuilder.append(makeWinnerString());

        return messageBuilder.toString();
    }

    private void makeCarRecordResult(StringBuilder messageBuilder, int index) {
        for (Car car : cars.getCars()) {
            String record = new PositionRecordView(car.getPlayerName(), car.getPositionRecord(index))
                    .createMessage();
            messageBuilder.append(record);
            messageBuilder.append("\n");
        }
    }

    @NotNull
    private String makeWinnerString() {
        return String.join(",", cars.getWinnerCarsName()) + WINNER_MESSAGE;
    }
}
