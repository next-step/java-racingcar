package racing.module;

import java.util.List;
import racing.module.map.RacingMap;

public class OutputView {

    private static final String GAME_RESULT = "실행 결과";
    private RacingMap racingMap;

    public OutputView(RacingMap racingMap) {
        this.racingMap = racingMap;
    }

    public void printResult(){
        System.out.println(GAME_RESULT);
        List<String> map = racingMap.getMap();
        map.forEach(System.out::println);
    }
}
