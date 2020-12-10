package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String SPLIT_REGEX = ",";

    private final Scanner scanner = new Scanner(System.in);

    /**
     * 차의 대수를 입력받습니다.
     */
    public RacingCarDriver inputCarAmount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return new RacingCarDriver(this.scanner.nextInt());
    }

    /**
     * 몇 회차까지 진행 할 지 입력받습니다.
     * @return round
     */
    public int inputRacingRound() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return this.scanner.nextInt();
    }

    /**
     * 참가자 리스트를 받습니다.
     * @return round
     */
    public NamedRacingCarDriver inputParticipants() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return new NamedRacingCarDriver(this.makeParticipantsList(this.scanner.nextLine()));
    }

    /**
     * @param inputs
     * @return
     */
    public String[] makeParticipantsList(String inputs) {
        List<String> participants = new ArrayList<>();
        for (String input : inputs.split(InputView.SPLIT_REGEX)) {
            participants.add(input.trim());
        }
        return participants.toArray(new String[participants.size()]);
    }

}
