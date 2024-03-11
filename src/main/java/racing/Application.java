package racing;

import racing.domain.CarGame;
import racing.domain.GameBoard;
import racing.view.ResultView;

import static racing.view.InputView.inputCarCount;
import static racing.view.InputView.inputGameCount;

public class Application {
    public static void main(String[] args) {
        //입력부
        int participants = inputCarCount();
        int rounds = inputGameCount();
        // 로직 실행부
        //1. 인풋값을 받는다
        //2. 게임을 실행해줄 도메인에 값을 넘긴다.
        CarGame carGame = new CarGame(participants, rounds);
        GameBoard gameBoard = carGame.start(rounds);
        // 출력부
        //3. 결과값을 받는다
        //4. 화면에 뿌린다.
        ResultView.showResult(gameBoard);
    }
}
