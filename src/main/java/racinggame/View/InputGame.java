package racinggame.View;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class InputGame {
    public List<Object> inputData() {
        Scanner scanner = new Scanner(System.in);
        List<Object> input = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        input.add(scanner.nextLine());
        System.out.println("자동차 대수는 몇 대 인가요?");
        input.add(scanner.nextInt());
        System.out.println("시도할 횟수는 몇 회 인가요?");
        input.add(scanner.nextInt());

        for(Object input_value : input) {
            nullCheck(input_value);
        }

        input.add(String.valueOf(input.get(0)).trim());

        return input;
    }

    public void nullCheck(Object input_value) {
        if (StringUtils.isEmpty(String.valueOf(input_value))) {
            throw new IllegalArgumentException();
        }
    }
}
