package step5;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingGameInputData racingGameInputData = inputView.init();//초기 데이터 입력 받기
        RacingGame racingGame = new RacingGame(racingGameInputData);//레이싱 게임에 데이터 입력
        ResultDto resultDto = racingGame.race(new CarMovingStrategy());//레이싱게임 진행
        ResultView resultView = new ResultView(resultDto);//레이싱 게임 결과 데이터 입력
        resultView.printResult();//레이싱 결과 출력
    }
}
