package racingcar.view;

import java.util.Arrays;
import java.util.List;
import racingcar.util.Console;

public class RacingCarInput {

    public List<String> getCarName() {
        String input = "";
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        try {
            input = Console.readLine();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return getCarName();
        }
        return Arrays.asList(input.split(","));
    }

    public int getRaceCount() {
        String input = "";
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            input = Console.readLine();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return getRaceCount();
        }
        return Integer.parseInt(input);
    }
}
