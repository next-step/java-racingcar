import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public List<Car> makeCars(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            cars.add(new Car(strArr[i], 0));
        }
        return getCars();
    }

    public String judgeWinner(List<Car> cars) {
        int maxPosition = getMaxPosition();
        StringBuilder winnerNames = new StringBuilder();

        for (Car car : cars) {
            selectWinnerName(winnerNames, car, maxPosition);
        }

        return winnerNames.toString();
    }

    private void selectWinnerName(StringBuilder winnerNames, Car car, int maxPosition) {
        if (car.getPosition() == maxPosition) {
            winnerNames.append(car.getCarName()).append(" ");
        }
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public List<Car> getCars() {
        return cars;
    }
}