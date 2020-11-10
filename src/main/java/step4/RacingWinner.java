package step4;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingWinner {
    private int position;
    private List<String> winners;
    private static final String COMMA = ",";

    public RacingWinner(List<Car> cars) {
        this.setWinnerPosition(cars);
        this.setWinners(cars);
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setWinners(List<Car> cars) {
        this.winners = IntStream.range(0, cars.size())
                .filter(i -> cars.get(i).getPosition() == this.position)
                .mapToObj(i -> cars.get(i).getCarName())
                .collect(Collectors.toList());
    }

    public String getWinners() {
        return String.join(COMMA, this.winners);
    }

    public void setWinnerPosition(List<Car> cars) {
        int winnerPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .filter(car -> car >= 0)
                .max()
                .orElse(0);

        this.setPosition(winnerPosition);
    }

    @Override
    public String toString() {
        return String.format("%s가 최종 우승했습니다.", this.getWinners());
    }
}
