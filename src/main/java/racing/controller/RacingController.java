package racing.controller;

import racing.model.CarNameParser;
import racing.model.RacingCar;
import racing.model.RacingCarDto;
import racing.model.RacingGame;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class RacingController {

    private final RacingGame racingGame;
    private final GameTurn gameTurn;

    public RacingController() {
        InputView inputView = new InputView();
        this.gameTurn = new GameTurn(inputView.getTurnCount());
        CarNameParser carNameParser = new CarNameParser(inputView.getParticipationList());
        this.racingGame = new RacingGame(carNameParser.parse());
    }

    /**
     * 게임 시작 메서드 1 턴씩 진행하며 게임이 끝날때까지 반복된다.
     */
    public void play() {
        ResultView resultView = new ResultView();
        for (int i = 0; i < gameTurn.getGameTurn(); i++) {
            turn(resultView);
        }
        finish(resultView);
    }

    /**
     * 매 게임 턴 마다 자동차를 움직이고 결과를 보여주는 메서드
     */
    public void turn(ResultView resultView) {
        List<Integer> randomValue = racingGame.createRandomValue();
        List<RacingCar> movedCarList = racingGame.moveAndStop(randomValue);
        List<RacingCarDto> carDtoList = createDtoList(movedCarList);
        resultView.turnResultView(carDtoList);
    }

    public List<RacingCarDto> createDtoList(List<RacingCar> racingCarList) {
        return racingCarList.stream()
                .map((car) -> new RacingCarDto(car.getRacingCarName(), car.getPosition()))
                .collect(toList());
    }

    private void finish(ResultView resultView) {
        resultView.drawWinner(racingGame.setWinner());
    }

    public static void main(String[] args) {
        RacingController racingController = new RacingController();
        racingController.play();
    }

}
