package step3;

//  게임 생성 함수
class GameGenerator {

    public static void main(String[] args) {
        //  racingGame 내부의 함수를 실행시키는 일만 수행
        //  1. 게임 선언
        RacingGame racingGame = new RacingGame();
        //  2. 게임 설정
        racingGame.initRacingGame();
        //  3. 게임 실행
        racingGame.startRacingGame();

    }
}
