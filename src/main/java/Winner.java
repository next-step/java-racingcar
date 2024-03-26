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
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            this.filterMaxLength(car);
        }
        return winners;
    }

    private void filterMaxLength(Car car) {
        int statusLength = car.getStatus().length();
        if (this.maxLength <= statusLength) {
            this.updateMaxLength(statusLength);
            this.addWinner(car.getName());
        }
    }
}
