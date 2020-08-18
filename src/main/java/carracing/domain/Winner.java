package carracing.domain;

import java.util.Arrays;
import java.util.List;

public class Winner {
    private List<Car> cars;
    int[] positions;

    public Winner(List<Car> cars) {
        this.cars = cars;
    }

    protected String getWinner() {
        int maxPosition = getMaxPosition();
        String winnerName = null;
        for(Car car : cars) {
            if(maxPosition >= car.getPosition()) {
                winnerName += car.getCarName();
            }
        }
        
    }

    private void setPositions() {
        int idx = 0;
        for(Car car : cars) {
            positions[idx++] = car.getPosition();
        }
    }

    //제일 큰 점수 가져오기
    private int getMaxPosition() {
        setPositions();
        return Arrays.stream(positions).sorted().findFirst().getAsInt();
    }
}
