package racingcar.ui;

import calculator.util.FormulaUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class RacingCarInput {

    public static List<String> getCarName() {
        String input = "";
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            input = bufferedReader.readLine();
        } catch (IllegalArgumentException | IOException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
        return Arrays.asList(input.split(","));
    }

    public static int getRaceCount() {
        int input = 0;
        System.out.println("시도할 횟수는 몇 회인가요?");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            input = Integer.parseInt(bufferedReader.readLine());
        } catch (IllegalArgumentException | IOException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
        return input;
    }
}
