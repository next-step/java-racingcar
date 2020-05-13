package racing.view;

import racing.domain.Car;
import racing.dto.RacingGameResult;

import java.util.List;

public class OutputView {
    private static final String HYPHEN = "-";
    private static final String COLON = " : ";

    public void printGuidance() {
        System.out.println("실행 결과");
    }

    public void printRacingResult(RacingGameResult racingGameResult) {
        List<Car> cars = racingGameResult.getCars();
        cars.forEach(car -> this.outputCarPosition(car.getName(), car.findCurrentPosition()));
        System.out.println();
    }

    private void outputCarPosition(String name, int position) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(COLON);
        for (int i = 0; i < position; i++) {
            stringBuilder.append(HYPHEN);
        }
        System.out.println(stringBuilder);
    }

    public void printRacingWinners(RacingGameResult racingGameResult) {
        List<Car> winners = racingGameResult.calculateWinners();
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : winners) {
            stringBuilder.append(car.getName());
            stringBuilder.append(", ");
        }
        stringBuilder = this.removeLastColon(stringBuilder);
        stringBuilder.append("가 최종 우승했습니다.");
        System.out.println(stringBuilder);
    }

    private StringBuilder removeLastColon(StringBuilder stringBuilder) {
        int lastColonIndex = stringBuilder.lastIndexOf(", ");
        if (lastColonIndex != -1) {
            stringBuilder.replace(lastColonIndex, lastColonIndex + 1, "");
        }
        return stringBuilder;
    }
}
