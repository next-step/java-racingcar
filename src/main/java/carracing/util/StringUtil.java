package carracing.util;

import carracing.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtil {
    public static final String DELIMETER = ",";
    public static final int WORD_LENGTH = 5;

    public static List<String> split(final String inputString) {
        return Arrays.asList(inputString.split(DELIMETER));
    }

    public static String joinWithDelimeter(List<Car> cars) {
        List<String>nameList = new ArrayList<>();
        String joinString;
        for(Car car:cars){
            nameList.add(car.getName().toString());
        }
        joinString=String.join(",",nameList);
        return joinString;
    }
}
