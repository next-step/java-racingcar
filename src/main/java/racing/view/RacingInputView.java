package racing.view;

import lombok.Getter;
import racing.domain.GrandPrix;
import racing.service.RacingService;

import java.util.Scanner;

@Getter
public class RacingInputView {
    RacingService racingService = new RacingService();
    private int grandPrixId;

    public void view() {
        int maxMachines;
        int maxRounds;

        try (Scanner in = new Scanner(System.in)) {
            System.out.println("자동차 대수는 몇 대 인가요?");
            maxMachines = Integer.parseInt(in.nextLine());

            System.out.println("시도할 회수는 몇 회 인가요?");
            maxRounds = Integer.parseInt(in.nextLine());
        }
        GrandPrix grandPrix = racingService.createGrandPrix(maxMachines, maxRounds);
        grandPrixId = grandPrix.getId();
    }

}
