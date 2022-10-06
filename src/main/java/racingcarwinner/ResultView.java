package racingcarwinner;

import racingcarwinnerexception.CarMovingCountException;
import racingcarwinnerexception.NameIsEmptyNullException;
import racingcarwinnerexception.NameOutOfLengthException;

public class ResultView {
    public static void main(String[] args) throws NameOutOfLengthException, NameIsEmptyNullException, CarMovingCountException {
        InputView inputView = new InputView();
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String participantName = inputView.enterParticipantName();
        System.out.println("시도할 회수는 몇번인가요?");
        int carMovingCount = inputView.enterCarMovingCount();
        System.out.println();

        RacingCarWinner racingCarWinner = new RacingCarWinner(participantName, carMovingCount);
        System.out.println("실행결과");
        System.out.println(racingCarWinner.startGame());
    }
}
