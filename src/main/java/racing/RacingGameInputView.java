package racing;

import java.util.HashMap;
import java.util.Scanner;

public class RacingGameInputView {
    public static HashMap<String,String> racingGameInput(){
        Scanner io = new Scanner(System.in);
        HashMap<String,String> inputMap = new HashMap<>();

        System.out.println("자동차 대수는 몇대인가요?");
        inputMap.put("CAR_COUNT",io.nextLine()) ;

        System.out.println("시도할 회수는 몇 회 인가요?");
        inputMap.put("TIME",io.nextLine()) ;

        return inputMap;
    }
}
