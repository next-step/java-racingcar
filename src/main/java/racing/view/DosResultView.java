package racing.view;

import racing.domain.car.entity.Car;
import racing.domain.car.entity.Cars;
import racing.domain.game.entity.RacingGame;
import racing.domain.game.vo.turn.Turn;

import static racing.view.DosResultView.Text.*;

public class DosResultView implements ResultView {
    private static final String NAME_DELIMITER = ",";
    private static final char LOCATION_UNIT = '-';

    private void printResultTitle() {
        System.out.println(RESULT_TITLE);
        System.out.println();
    }

    private void printCarLocation(Car car) {
        int locationValue = car.location().value();
        System.out.print(
                CAR_NAME.formatString(car.name())
        );
        for (int i = 0; i < locationValue; i++)
            System.out.print(LOCATION_UNIT);
        System.out.println();
    }

    private void printAllCarLocation(Cars cars) {
        for (Car iCar : cars)
            printCarLocation(iCar);
        System.out.println();
    }

    private void printWinners(Cars cars) {
        StringBuilder builder = new StringBuilder();
        for (Car iCar : cars.bestCars()) {
            builder.append(iCar.name())
                    .append(NAME_DELIMITER);
        }
        String strWinners = builder.substring(0, builder.length() - 1); // 우승자는 반드시 나온다.

        System.out.println(WINNERS.formatString(strWinners));
    }

    @Override
    public void printResult(RacingGame game) {
        printResultTitle();
        for (Turn iTurn : game.endedTurns()) {
            printAllCarLocation(iTurn.snapshot());
        }
        printWinners(game.bestCars());
    }

    @Override
    public void printException(Exception e) {
        System.out.println(EXCEPTION.formatString(e.getMessage()));
    }

    protected enum Text {
        CAR_NAME("%s : "),
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
