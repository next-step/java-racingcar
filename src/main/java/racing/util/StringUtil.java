package racing.util;

import racing.model.Car;

import java.util.List;

public class StringUtil {
    private static final String COMMA = ",";
    private static final String REMOVE_LAST_COMMA_REGEX = ",$";
    private static final String BLANK = "";

    public static String getNameInCarList(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getName());
            sb.append(COMMA);
        }
        return removeComma(sb.toString());
    }

    private static String removeComma(String string) {
        return string.replaceAll(REMOVE_LAST_COMMA_REGEX, BLANK);
    }
}
