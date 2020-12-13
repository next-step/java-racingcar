package racingcar.view;

import racingcar.RacingCarDriver;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final String SPLIT_REGEX = ",";

    private final Scanner scanner = new Scanner(System.in);

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
    public RacingCarDriver inputParticipants() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return new RacingCarDriver(this.makeParticipantsList(this.scanner.nextLine()));
    }

    /**
     * 참가자 명단을 쪼개어 리스트로 반환
     * @param inputs
     * @return
     */
    public List<String> makeParticipantsList(String inputs) {
        return Stream.of(inputs.split(InputView.SPLIT_REGEX))
                .map(String::trim)
                .collect(Collectors.toList())
                ;
    }

}
