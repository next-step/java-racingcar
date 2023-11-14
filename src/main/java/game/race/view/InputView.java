package game.race.view;

import static java.lang.Integer.parseInt;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import game.race.dto.RaceDto;

public class InputView {

    private static final String ASK_VEHICLE_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ASK_TRY_COUNT = "시도할 회수는 몇 회 인가요?";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static RaceDto showPrompt() {
        System.out.println(ASK_VEHICLE_NAME);
        String vehicleNames = SCANNER.nextLine();

        System.out.println(ASK_TRY_COUNT);
        String trials = SCANNER.nextLine();
        List<String> names = getNames(vehicleNames);

        checkNames(names);
        checkTryCount(trials);

        return RaceDto.of(parseInt(trials), names);
    }

    public static List<String> getNames(String vehicleNames) {
        if (vehicleNames == null || vehicleNames.isBlank()) {
            throw new IllegalArgumentException("값을 입력 하세요. - " + vehicleNames);
        }

        return Arrays.stream(vehicleNames.split(","))
                     .collect(Collectors.toList());
    }

    public static void checkTryCount(String input) {
        int number;
        try {
            number = parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("0이 아닌 숫자를 입력 하세요. - " + input);
        }

        if (number == 0) {
            throw new IllegalArgumentException("0이 아닌 숫자를 입력 하세요. - " + input);
        }
    }

    public static void checkNames(List<String> names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 다섯자를 넘을 수 없습니다. - " + name);
            }
        }
    }
}
