package racing.view;

import racing.car.Car;
import racing.car.Cars;

import java.util.Iterator;

import static racing.view.DosResultView.Text.*;

public class DosResultView implements ResultView {
    private static final String NAME_DELIMITER = ",";
    private static final char LOCATION_UNIT = '-';
    @Override
    public void printResultTitle() {
        System.out.println(RESULT_TITLE);
        System.out.println();
    }

    @Override
    public void printAllCarLocation(Cars cars) {
        for (Car iCar : cars)
            printCarLocation(iCar);
        System.out.println();
    }

    @Override
    public void printCarLocation(Car car) {
        int locationValue = car.getLocation().getValue();
        System.out.print(
                CAR_NAME.formatString(car.getName())
        );
        for (int i = 0; i < locationValue; i++) {
            System.out.print(LOCATION_UNIT);
        }
        System.out.println();
    }

    @Override
    public void printException(Exception e) {
        System.out.println(EXCEPTION.formatString(e.getMessage()));
    }

    @Override
    public void printWinners(Cars cars) {
        StringBuilder builder = new StringBuilder();
        for (Car iCar : cars.bestCars()) {
            builder.append(iCar.getName())
                    .append(NAME_DELIMITER);
        }
        String strWinners = builder.substring(0, builder.length() - 1); // 우승자는 반드시 나온다.

        System.out.println(WINNERS.formatString(strWinners));
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
