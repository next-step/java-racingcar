package fourth_racing_ranking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGameResult {

    public void announceRank(List<Car> car){
        String firstCarName = setRank(car);
        System.out.println(firstCarName + "가 최종 우승했습니다.");
    }

    public String setRank(List<Car> car) {
        String firstCarName = "";

        Collections.reverse(car);

        return firstCarName;
    }
}
