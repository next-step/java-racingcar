package step4.view;


import step4.domain.dto.RacingCarRequestDto;
import step4.domain.request.Participants;
import step4.domain.request.Round;
import utils.StringUtils;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static InputView instance;

    private InputView() {
    }

    public static InputView getInstance() {
        if (isInstanceNull()) {
            instance = new InputView();
        }
        return instance;
    }

    private static boolean isInstanceNull(){
        return instance == null;
    }

    public String getParticipantsValue() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.next();
    }

    public int getRoundValue() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public RacingCarRequestDto getRacingCarRequestDto() {
        return RacingCarRequestDto.of(getParticipants(), getRound());
    }

    private Participants getParticipants() {
        return Participants.from(splitSentenceByComma(getParticipantsValue()));
    }

    private String[] splitSentenceByComma(String sentence) {
        return StringUtils.splitByComma(sentence);
    }

    private Round getRound() {
        return Round.from(getRoundValue());
    }

}
