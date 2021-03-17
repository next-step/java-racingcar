package carRacing.view;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    final static String DELIMITER = ",";

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return getStringInput();
    }

    public int getRacingCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return getIntInput();
    }

    private String getStringInput() {
        String carNames;
        try {
            carNames = scanner.nextLine();
            if(StringUtils.isBlank(carNames))
                throw new IllegalArgumentException("자동차 이름을 입력하세요.");
        } catch (Exception e) {
            throw new IllegalArgumentException("유효한 자동차 이름을 입력하세요.");
        }
        if(Arrays.stream(carNames.split(DELIMITER)).anyMatch(s -> s.length()>5)){
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        return carNames;
    }

    private int getIntInput() {
        int count;
        try {
            count = scanner.nextInt();
            if(count <= 0)
                throw new IllegalArgumentException("유효한 양의 정수를 입력하세요");
        } catch (InputMismatchException ime) {
            throw new IllegalArgumentException("정수를 입력하세요");
        }
        return count;
    }

}
