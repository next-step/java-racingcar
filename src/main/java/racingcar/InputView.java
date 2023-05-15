package racingcar;

import java.util.Scanner;

public class InputView {

    private InputViewDto inputViewDto;


    InputView() {
        Scanner scanner = new Scanner(System.in);

        inputViewDto = new InputViewDto();
        inputViewDto.setCarNames(getCarNames(scanner));
        inputViewDto.setTrialCount(getTrialCount(scanner));
    }

    private String getCarNames(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    private static Integer getTrialCount(Scanner scanner) {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    public String getCarNames() {
        return inputViewDto.getCarNames();
    }

    public int getTrialCount() {
        return inputViewDto.getTrialCount();
    }
}
