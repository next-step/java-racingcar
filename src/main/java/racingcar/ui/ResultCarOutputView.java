package racingcar.ui;

import racingcar.service.domain.Car;
import racingcar.service.dto.Record;
import racingcar.service.dto.RoundResult;
import racingcar.utils.OutputUtils;

public class ResultCarOutputView implements OutputView {
    private static final String DASH = "-";
    private static final String EMPTY = "";

    @Override
    public void output(RoundResult roundResult) {
        roundResult.getRecords().forEach(record -> {
            OutputUtils.println(String.format("%d 번째 경주", record.getCurrentRound()));
            print(record);
        });
        OutputUtils.println(String.format("%s가 최종 우승했습니다", roundResult.getFinalWinnerName()));
    }

    public void print(Record record) {
        record.getCars().forEach(ResultCarOutputView::print);
        OutputUtils.println(EMPTY);
    }

    public static void print(Car car) {
        OutputUtils.print(String.format("%s : ", car.getName()));
        for (int i = 0; i < car.currentPosition().getPosition(); i++) {
            OutputUtils.print(DASH);
        }
        OutputUtils.println(EMPTY);
    }
}
