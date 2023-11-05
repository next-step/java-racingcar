package study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputView {

    public static Map<String,String> input(){

        Map<String,String> inputValue = new HashMap<String,String>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        String carValue = scanner.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요?");
        String loopValue = scanner.nextLine();


        inputValue.put("carValue", carValue);
        inputValue.put("loopValue", loopValue);

        return inputValue;
    }
}
