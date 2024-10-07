package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RaceWinner {

    List<String> nameList;
    int longestMovingDistance;

    public RaceWinner(List<RaceRecord> records) {
        nameList = new ArrayList<>();
        longestMovingDistance = -1;

        for(RaceRecord record : records) {
            decideWinner(record);
        }
    }

    private void decideWinner(RaceRecord record) {
        int movingDistance = record.getDashCharacterString().length();

//        System.out.println(movingDistance + " " + longestMovingDistance + " " + record.getCarName());

        if(movingDistance == longestMovingDistance) {
            nameList.add(record.getCarName());
            return;
        }

        if(movingDistance > longestMovingDistance ) {
            longestMovingDistance = movingDistance;
            nameList.clear();
            nameList.add(record.getCarName());
        }
    }

    private StringBuilder stringListToStringBuilderForPrint() {
        StringBuilder winnerName = new StringBuilder();

        for(int i = 0; i < nameList.size(); i++) {
            winnerName.append(i == nameList.size() - 1 ? nameList.get(i) : nameList.get(i) + ", ");
        }

        winnerName.append("가 최종 우승했습니다.");

        return winnerName;
    }

    public String getName() {
        return stringListToStringBuilderForPrint().toString();
    }
}
