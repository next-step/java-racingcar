package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingInputCarView {

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scan = new Scanner(System.in);

        return getCarObjects(scan.nextLine());
    }

    public static List<String> getCarObjects(String input) {
        return Arrays.asList(input.split(",")).stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static int getTargetDistance() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        Scanner scan = new Scanner(System.in);
        return Integer.parseInt(scan.nextLine());
    }

}
