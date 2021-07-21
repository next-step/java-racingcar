package Calculater;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StringCalculaterExcuteClass {
    private static final Map<String, Calculater> stringCalculater = new HashMap<>();
    private static final Map<String, Calculater> unmodifyStringCalculater = Collections.unmodifiableMap(stringCalculater);



    static{
        stringCalculater.put("+", new Plus());
        stringCalculater.put("-", new Subtract());
        stringCalculater.put("*", new Multiply());
        stringCalculater.put("/", new Division());
    }

    public static int result(String operater, int number1, int number2){
        Calculater calculater = unmodifyStringCalculater.get(operater);
        return calculater.resultCalculater(number1, number2);
    }
}
