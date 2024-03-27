import java.util.ArrayList;
import java.util.List;

/**
 * @author jeongheekim
 * @date 3/26/24
 */
public class Winner {
    private List<String> winners = new ArrayList<>();
    private int maxLength;

    public void addWinner(String name) {
        this.winners.add(name);
    }

    public void updateMaxLength(int length) {
        this.maxLength = length;
    }

    public List<String> getWinners(Car[] cars) {
        this.filterMaxLength(cars);
        for (Car car : cars) {
            this.checkWinnerCondition(car);
        }
        return this.winners;
    }

    private void filterMaxLength (Car[] cars) {
        for (Car car : cars) {
            int carStatusLength = car.getStatus().length();
            this.compareMaxLength(carStatusLength);
        }
    }

    private void compareMaxLength(int carStatusLength) {
        if (this.maxLength <= carStatusLength) {
            this.updateMaxLength(carStatusLength);
        }
    }

    private void checkWinnerCondition(Car car) {
        int statusLength = car.getStatus().length();
        if (this.maxLength <= statusLength) {
            this.addWinner(car.getName());
        }
    }
}
