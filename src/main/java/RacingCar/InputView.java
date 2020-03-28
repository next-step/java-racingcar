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
        String expression = scanner.nextLine();
        String[] splitedNames = expression.split(",");

        setNames(splitedNames);

        System.out.println(getNames());

        System.out.println(STAGE_INPUT_MESSAGE);
        setStage(scanner.nextInt());
    }


    private void setStage(int stage) {
        this.stage = stage;
    }


    private void setNames(String[] names) {
        this.names = new ArrayList<>(Arrays.asList(names));
    }

    List<String> getNames() {
        return names;
    }
    int getStage() {
        return stage;
    }
}