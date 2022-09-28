package step3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnterGameConfig {
    private final Scanner scanner = new Scanner(System.in);

    private final String ENTER_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private final String ENTER_ITERATE_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public String[] enterCarNames() {
        System.out.println(ENTER_CAR_NAME_MESSAGE);
        String nameInput = this.scanner.nextLine();
        this.emptyInputCheck(nameInput);
        String[] carNames = this.nameInputParse(nameInput);
        this.carNameValidate(carNames);
        return carNames;
    }

    public int enterIterate() {
        System.out.println(ENTER_ITERATE_MESSAGE);
        int iterate = Integer.parseInt(this.scanner.nextLine());
        this.iterateValidate(iterate);
        this.inputClose();
        return iterate;
    }

    private void iterateValidate(int iterate) {
        if (iterate < 1) {
            throw new RuntimeException("라운드 수는 양수여야 합니다.");
        }
    }

    private void emptyInputCheck(String nameInput) {
        if (nameInput.length() == 0) {
            throw new RuntimeException("입력한 자동차 이름이 없습니다.");
        }
    }

    private String[] nameInputParse(String nameInput) {
        String[] split = nameInput.split(",");
        return split;
    }

    private void carNameValidate(String[] carNames) {
        List<String> invalidCarNames = Arrays.stream(carNames)
                .filter(carName -> carName.length() > 5)
                .collect(Collectors.toList());
        if (invalidCarNames.size() > 0) {
            String joinedInvalidCarNames = String.join(",", invalidCarNames);
            throw new RuntimeException("invalid input names: " + joinedInvalidCarNames + " | name은 5글자를 초과할 수 없습니다.");
        }
    }

    private void inputClose() {
        this.scanner.close();
    }
}
