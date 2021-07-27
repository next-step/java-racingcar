package racing.view;

import racing.domain.car.Car;
import racing.domain.car.Cars;
import racing.domain.dto.GameResponse;

import java.util.ArrayList;
import java.util.List;

import static racing.view.DosResultView.Text.*;

public class DosResultView implements ResultView {
    private static final String LOCATION_REPEAT_UNIT = "-";

    public void printResultTitle() {
        System.out.println(RESULT_TITLE);
        System.out.println();
    }

    public void printWinners(Cars winners) {
        List<String> winnerNames = new ArrayList<>();
        for (Car iCar : winners)
            winnerNames.add(iCar.toString());
        System.out.println(
                WINNERS.formatString(winnerNames.toArray())
        );
    }

    @Override
    public void printResult(GameResponse response) {
        printResultTitle();

        for (Cars iCars : response) {
            printCarsLocation(iCars);
        }
        printWinners(response.lastValue().findWinners());
    }

    private void printCarsLocation(Cars cars) {
        for (Car iCar : cars) {
            System.out.println(
                    CAR_LOCATION.formatString(iCar, iCar.locationToRepeatString(LOCATION_REPEAT_UNIT))
            );
        }
        System.out.println();
    }

    @Override
    public void printException(Exception e) {
        System.out.println(EXCEPTION.formatString(e.getMessage()));
    }

    protected enum Text {
        CAR_LOCATION("%s : %s"),
        RESULT_TITLE("실행 결과"),
        EXCEPTION("[ERROR] %s"),
        WINNERS("%s가 최종 우승 했습니다.");

        private final String text;

        Text(String text) {
            this.text = text;
        }

        public String formatString(String... objs) {
            return formatString((Object[]) objs);
        }

        public String formatString(Object... objs) {
            return String.format(text, objs);
        }

        @Override
        public String toString() {
            return text;
        }
    }
}
