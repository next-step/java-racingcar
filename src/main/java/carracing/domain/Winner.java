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
        String winnerName = "";
        for(Car car : cars) {
            if(maxPosition <= car.getPosition()) {
                winnerName += car.getCarName();
            }
        }

        //cars.stream().forEach( car -> maxPosition <= car.getPosition() );

        return  winnerName;
        
    }

    private void setPositions() {
        positions = new int[cars.size()];
        int idx = 0;
        for(Car car : cars) {
            positions[idx] = car.getPosition();
            idx++;
        }
    }

    //제일 큰 점수 가져오기
    private int getMaxPosition() {
        setPositions();
        return Arrays.stream(positions).max().getAsInt();
    }
}
