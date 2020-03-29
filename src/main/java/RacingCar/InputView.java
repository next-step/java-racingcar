package RacingCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class InputView {

    private Scanner scanner = new Scanner(System.in);

    private List<String> names;
    private int stage;

    void showInput() {
        String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
        String STAGE_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";


        System.out.println(CAR_NAME_INPUT_MESSAGE);

        String input = scanner.nextLine();

        validateName(input);
        setNames(splitInputName(input));

        System.out.println(STAGE_INPUT_MESSAGE);

        int stage = scanner.nextInt();
        validateStage(stage);
        setStage(stage);
    }

    private List<String> splitInputName(String input) {
        return Arrays.asList(input.trim().split(","));
    }

    private void validateName(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("최소 2개의 자동차가 있어야 합니다.");
        }
    }

    private void validateStage(int stage) {
        if (!(stage > 0)) {
            throw new IllegalArgumentException("최소 1번 이상 시도해야 합니다.");
        }
    }

    List<String> getNames() {
        return names;
    }
    int getStage() {
        return stage;
    }

    private void setStage(int stage) {
        this.stage = stage;
    }

    private void setNames(List<String> names) {
        this.names = names;
    }


}