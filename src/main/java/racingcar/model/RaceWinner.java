package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RaceWinner {

    private String names;
    private int longestMovingDistance;

    public RaceWinner(List<RaceRecord> records) {
        longestMovingDistance = -1;
        List<String> nameList = new ArrayList<>();

        findLongestMovingDistance(records);

        for (RaceRecord record : records) {
            decideWinner(record, nameList);
        }

        nameListToString(nameList);
    }

    private void decideWinner(RaceRecord record, List<String> nameList) {
        int movingDistance = record.getCarMovingDistance();

        if (longestMovingDistance == movingDistance) {
            nameList.add(record.getCarName());
        }
    }

    private void findLongestMovingDistance(List<RaceRecord> records) {
        for (RaceRecord record : records) {
            longestMovingDistance = Math.max(longestMovingDistance, record.getCarMovingDistance());
        }
    }

    private void nameListToString(List<String> nameList) {
        names = String.join(", " , nameList);
        names += "가 최종우승했습니다.";
    }

    public String getNames() {
        return names;
    }
}
