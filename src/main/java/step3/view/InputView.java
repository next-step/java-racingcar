package step3.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputView {

    public int inputValue(String question) {
//        Map<String, Integer> inputMap = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        return scanner.nextInt();
//        System.out.println("시도할 회수는 몇 회인가요");
//        inputMap.put("period", scanner.nextInt());
//
//        return inputMap;
    }
}
