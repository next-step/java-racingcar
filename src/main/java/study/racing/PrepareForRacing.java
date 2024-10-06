package study.racing;

import study.racing.strategy.RacingMoveStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrepareForRacing {

    private static RacingMoveStrategy racingMoveStrategy;

    public PrepareForRacing(RacingMoveStrategy racingMoveStrategy) {
        PrepareForRacing.racingMoveStrategy = racingMoveStrategy;
    }

    public int goAndStop() {
      return racingMoveStrategy.move();
    }

    public List<Map<Integer, Integer>> personalCarTotalCount(int tryCount, int carCount) {
        List<Map<Integer, Integer>> racingList = new ArrayList<>();
        Map<Integer, Integer> addMap = new HashMap<>();

        for(int i = 0; i < carCount; i++) {
            addMap.put(i, 0);
        }

        for(int i = 0; i < tryCount; i++) {
            Map<Integer, Integer> newMap = new HashMap<>();
            for(int j = 0; j < carCount; j++) {
                int moveCount = goAndStop();
                int addCount =  addMap.get(j) + moveCount;

                addMap.put(j, addCount);
                newMap.put(j, addCount);
            }
            racingList.add(newMap);
        }

        return racingList;
    }

}
