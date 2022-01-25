package racingcar.ui;

import calculator.util.FormulaUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import racingcar.util.Console;

public class RacingCarInput {

    public static List<String> getCarName() {
        String input = "";
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        try {
            input = Console.readLine();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    public static int getRaceCount() {
        String input = "";
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            input = Console.readLine();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
        return Integer.parseInt(input);
    }
}
