package game.race.view;

import java.util.Scanner;

import game.race.dto.RaceDto;

public class InputView {

    private static final String ASK_VEHICLE_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String ASK_TRY_COUNT = "시도할 회수는 몇 회 인가요?";
    private static final Scanner SCANNER = new Scanner(System.in);

    public RaceDto showPrompt() {
        System.out.println(ASK_VEHICLE_COUNT);
        String vehicles = SCANNER.nextLine();
        checkInput(vehicles);

        System.out.println(ASK_TRY_COUNT);
        String trials = SCANNER.nextLine();
        checkInput(trials);

        return RaceDto.of(Integer.parseInt(vehicles),
                          Integer.parseInt(trials));
    }

    public void checkInput(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("값을 입력 하세요.");
        }

        if (number == 0) {
            throw new IllegalArgumentException("0보다 큰 수를 넣어 주세요.");
        }
    }
}
