import java.io.IOException;
import java.util.List;
import racing.Cars;
import racing.RacingUI;
import racing.Racing;

public class Application {

    public static void main(String[] args) throws IOException {
        // 사용자 입력
        String[] names = RacingUI.readCarName();
        int roundNumber = RacingUI.readRoundNumber();

        // 레이싱 로직
        Cars cars = new Cars(names);
        Racing racing = new Racing(cars, roundNumber);
        racing.race();
        List<String> winners = racing.getWinner();

        // 레이싱 결과 출력
        RacingUI.printRacing(cars, roundNumber);
        RacingUI.printWinners(winners);
    }
}
