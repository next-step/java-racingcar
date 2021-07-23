package racing.view;

import racing.car.Car;
import racing.car.Cars;

import static racing.view.DosResultView.Text.*;

public class DosResultView implements ResultView {
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


    protected enum Text {
        CAR_NAME("%s : "),
        RESULT_TITLE("실행 결과"),
        EXCEPTION("[ERROR] %s");

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
