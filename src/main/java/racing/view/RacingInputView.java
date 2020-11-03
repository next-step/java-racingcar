package racing.view;

import lombok.Getter;

import java.util.Scanner;

@Getter
public class RacingInputView {
    private Integer maxMachines;
    private Integer maxRounds;

    public void view(){
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("자동차 대수는 몇 대 인가요?");
            maxMachines = Integer.parseInt(in.nextLine());

            System.out.println("시도할 회수는 몇 회 인가요?");
            maxRounds = Integer.parseInt(in.nextLine());
        }
    }

}
