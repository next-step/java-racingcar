package racing;

import java.util.ArrayList;
import java.util.List;

public class PlayHistory {
    private final List<CarPositions> positions;

    public PlayHistory(List<CarPositions> positions) {
        this.positions = positions;
    }
    public List<CarPositions> getPositions(){
        return this.positions;
    }

    public List<String> findWinners(List<String> carNames){
        int maxPosition = findMaxPosition();
        CarPositions lastPositions = this.positions.get(this.positions.size()-1);
        return findMaxPositionNames(carNames, lastPositions, maxPosition);
    }

    private int findMaxPosition(){
        CarPositions lastPositions = this.positions.get(this.positions.size()-1);
        int maxPosition = 0;
        for (Integer lastPosition : lastPositions.getCarPositions()) {
            maxPosition = Math.max(maxPosition, lastPosition);
        }
        return maxPosition;
    }

    private List<String> findMaxPositionNames(List<String> carNames, CarPositions lastPositions, int maxPosition){
        List<String> lastPositionCarNames = new ArrayList<>();
        for (int i=0; i<carNames.size(); i++) {
            insertIfMaxPosition(carNames.get(i), lastPositions.getCarPosition(i), maxPosition, lastPositionCarNames);
        }
        return lastPositionCarNames;
    }

    private void insertIfMaxPosition(String carName, int nowPosition, int maxPosition, List<String> lastPositionCarNames){
        if (nowPosition == maxPosition) {
            lastPositionCarNames.add(carName);
        }
    }
}
