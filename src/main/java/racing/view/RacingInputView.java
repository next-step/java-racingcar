package racing.view;

import lombok.Getter;
import racing.service.GranPrixService;
import racing.view.to.RacingInputTO;

import java.util.Scanner;

@Getter
public class RacingInputView {
    private final GranPrixService granPrixService = new GranPrixService();

    public RacingInputTO getRacingInput() {
        int maxMachines;
        int maxRounds;

        try (Scanner in = new Scanner(System.in)) {
            System.out.println("자동차 대수는 몇 대 인가요?");
            maxMachines = Integer.parseInt(in.nextLine());

            System.out.println("시도할 회수는 몇 회 인가요?");
            maxRounds = Integer.parseInt(in.nextLine());
        }
        return new RacingInputTO(maxMachines, maxRounds);
    }

}
