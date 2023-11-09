package game.race.view;

import java.util.Scanner;

import game.race.dto.RaceDto;

public class InputView {

    private static final String ASK_VEHICLE_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ASK_TRY_COUNT = "시도할 회수는 몇 회 인가요?";
    private static final Scanner SCANNER = new Scanner(System.in);

    public RaceDto showPrompt() {
        System.out.println(ASK_VEHICLE_NAME);
        String vehicleNames = SCANNER.nextLine();
        checkInput(vehicleNames);

        System.out.println(ASK_TRY_COUNT);
        String trials = SCANNER.nextLine();
        checkInput(trials);

        return RaceDto.of(vehicleNames, Integer.parseInt(trials));
    }

    public void checkInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("값을 입력 하세요.");
        }
    }
}
