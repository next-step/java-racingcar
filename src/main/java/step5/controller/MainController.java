package step5.controller;

import step5.domain.CarList;
import step5.domain.InputValidator;
import step5.domain.Position;
import step5.domain.RacingGame;
import step5.dto.InputDto;
import step5.view.InputView;
import step5.view.ResultView;

public class MainController {

    // 다른건 어느정도 리팩터링 했다 생각하는데.. 클라이언트 코드가 깔끔해보이지 않는 느낌이네요 ㅠ,ㅠ
    public static void main(String[] args) {
        try {
            InputDto input = InputView.input();
            int tryCount = input.getTryCount();

            System.out.println();

            ResultView.ResultMessage();

            // 자동차 객체들 생성
            CarList carList = new CarList();
            carList.create(input.getCarNameList());

            RacingGame racingGame = new RacingGame(carList);
            racingGame.start(tryCount);

            Position position = carList.maxDistance(carList.getCarList());
            int maxPosition = position.getPosition();

            String winner = carList.findWinner(carList.getCarList(), maxPosition);
            ResultView.printWinner(winner);
        } catch (IllegalArgumentException e) {
            System.out.println("에러는 -> " + e);
        }
    }
}
