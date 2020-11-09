package racing.view;

import lombok.Getter;
import racing.view.to.RacingInputTO;

import java.util.Scanner;

@Getter
public class RacingInputView {

    private RacingInputView() {
    }

    public static RacingInputTO getRacingInput() {
        String drivers;
        String maxRounds;

        try (Scanner in = new Scanner(System.in)) {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            drivers = in.nextLine();

            System.out.println("시도할 회수는 몇 회 인가요?");
            maxRounds = in.nextLine();
        }
        System.out.println();
        return new RacingInputTO(drivers, maxRounds);
    }

}
