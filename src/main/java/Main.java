import calculate.CalculateMain;
import racegame.RacingCarMain;
import racegame.RacingGame;

public class Main {
    public static void main(String[] args) {
//        new CalculateMain().main(); // 계산기 메인
//        new RacingCarMain().racemain(); // 레이싱 메인 < 리뷰받기전
        new RacingCarMain().reviewReflectMain(); // 레이싱 리뷰 받은 후 생성자로 구현
    }
}
