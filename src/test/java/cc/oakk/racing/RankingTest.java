package cc.oakk.racing;

import cc.oakk.racing.predicate.CarForwardCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RankingTest {

    @Test
    @DisplayName("각 등수에 맞는 리스트가 불러와지는 가?")
    public void getRankAt() {
        List<Car> cars = createCarList(new int[] { 0, 1, 1, 3, 3 });
        Ranking ranking = new Ranking(cars);

        assertThat(ranking.getRankAt(1)).contains(cars.get(3), cars.get(4));
        assertThat(ranking.getRankAt(2)).contains(cars.get(1), cars.get(2));
        assertThat(ranking.getRankAt(3)).contains(cars.get(0));
    }

    @Test
    @DisplayName("일등 리스트가 불러와지는 가?")
    public void getWinner() {
        List<Car> cars = createCarList(new int[] { 0, 1, 1, 3, 3 });
        Ranking ranking = new Ranking(cars);

        assertThat(ranking.getWinner()).contains(cars.get(3), cars.get(4));
    }

    @Test
    @DisplayName("총 등수의 수가 맞는 가?")
    public void size() {
        List<Car> cars = createCarList(new int[] { 0, 1, 1, 3, 3 });
        Ranking ranking = new Ranking(cars);

        assertThat(ranking.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("0 이하, 총 등수 이상의 수를 입력받았을 때 예외발생")
    public void getRankAt_ShouldThrow_IndexOutOfBoundsException() {
        List<Car> cars = createCarList(new int[] { 0, 0, 0 });
        Ranking ranking = new Ranking(cars);

        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> ranking.getRankAt(-1));
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> ranking.getRankAt(0));
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> ranking.getRankAt(ranking.size() + 1));
    }

    private List<Car> createCarList(int[] distances) {
        List<Car> cars = new ArrayList<>();
        for (int distance : distances) {
            cars.add(createCar(distance));
        }
        return cars;
    }

    private Car createCar(int distance) {
        Car car = new Car(new CarForwardCondition<>(c -> true, c -> c));
        for (int i = 0; i < distance; i++) {
            car.tryMoveForward();
        }
        return car;
    }
}
