package racingcar.ui;

import racingcar.service.domain.Car;
import racingcar.service.dto.Record;
import racingcar.service.dto.RoundResultDTO;

public class ResultCarOutputView implements OutputView {
    private static final String DASH = "-";

    @Override
    public void output(RoundResultDTO roundResultDTO) {
        roundResultDTO.getRecords().forEach(record -> {
            System.out.printf("%d 번째 경주%n", record.getRound());
            print(record);
        });
        System.out.printf("%s가 최종 우승했습니다.", roundResultDTO.getWinnerName());
    }

    public void print(Record record) {
        record.getCars().forEach(ResultCarOutputView::print);
        System.out.println();
    }

    public static void print(Car car) {
        System.out.printf("%s : ", car.getName());
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(DASH);
        }
        System.out.println();
    }
}
