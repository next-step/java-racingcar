package Calculater;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CalculaterMain {
    private static Map<String, calculater> stringCal = new HashMap<>();


    static{
        stringCal.put("+",new Sum());
        stringCal.put("-",new Sub());
        stringCal.put("*",new Mul());
        stringCal.put("/",new Div());
    }


    public static calculater getCal (String Op){
        return stringCal.get(Op);
    }

    public static int result(String operater, int number1 , int number2){
        return CalculaterMain.getCal(operater).cal(number1,number2);
    }
}
