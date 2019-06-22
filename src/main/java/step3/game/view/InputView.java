package step3.game.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import step3.game.domain.CarName;
import step3.game.dto.RacingGameInputModel;

public class InputView {
    public static RacingGameInputModel inputModel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputCarNames = scanner.nextLine();
        List<CarName> carNames = Arrays.stream(inputCarNames.split(","))
                                       .map(CarName::new)
                                       .collect(Collectors.toList());

        System.out.println("시도할 회수는 몇 회 인가요?");
        int times = scanner.nextInt();

        return new RacingGameInputModel(carNames, times);
    }
}
