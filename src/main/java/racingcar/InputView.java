package racingcar;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputView {
    public Map<String, Integer> setInput(){
        Map<String, Integer> inputs = new HashMap<String, Integer>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        inputs.put("counts",scanner.nextInt());

        System.out.println("시도할 회수는 몇 회 인가요?");
        inputs.put("attempts",scanner.nextInt());

        return inputs;
    }
}
