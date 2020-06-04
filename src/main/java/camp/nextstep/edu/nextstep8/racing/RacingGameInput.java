package camp.nextstep.edu.nextstep8.racing;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingGameInput {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String SEPARATOR = ",";

    public int getRoundTimes() {
        System.out.println("시도할 회 수는 몇 회 인가요?");
        if(SCANNER.hasNextInt()) {
            return SCANNER.nextInt();
        }
        throw new IllegalArgumentException("숫자를 입력해 주세요");
    }

    public List<RacingCar> getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
        if(SCANNER.hasNextLine()) {
            return Arrays.stream(
                    SCANNER.nextLine()
                            .trim()
                            .split(SEPARATOR))
                    .map(RacingCar::new)
                    .collect(Collectors.toList());
        }
        throw new IllegalArgumentException("입력된 자동자 이름이 없습니다");
    }

}
