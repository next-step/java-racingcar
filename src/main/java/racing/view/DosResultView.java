package racing.view;

import racing.domain.car.Car;
import racing.domain.Location;
import racing.domain.Turn;
import util.RepeatString;

import java.util.Map;

import static racing.view.DosResultView.Text.*;

public class DosResultView implements ResultView {
    private static final String LOCATION_REPEAT_UNIT = "-";

    @Override
    public void printResultTitle() {
        System.out.println(RESULT_TITLE);
        System.out.println();
    }

    @Override
    public void printTurn(Turn turn) {
        for (Map.Entry<Car, Location> iEntry : turn.entrySet()) {
            Car iCar = iEntry.getKey();
            Location iLocation = iEntry.getValue();

            System.out.println(
                    CAR_LOCATION.formatString(iCar, new RepeatString(iLocation, LOCATION_REPEAT_UNIT))
            );
        }
        System.out.println();
    }

    @Override
    public void printWinners(Turn turn) {
        System.out.println(WINNERS.formatString(turn.findWinnerNames().toArray()));
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
