package racing.utils;

import com.racing.domain.Car;
import com.racing.domain.Cars;
import com.racing.utils.CarHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CarHelperTest {

    @Test
    @DisplayName("구분자(,)를 기준으로 String으로 분리")
    public void isEquals_SplitStringFromDelegate() {
        List<String> expectedValue = Arrays.asList("pobi", "crong", "honux");

        assertThat(CarHelper.splitCarName("pobi,crong,honux")).isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("모든 이름이 유효하지 않을 때 빈 리스트 반환")
    public void splitAndValidateCarNames_ShouldReturnEmptyList_WhenAllNamesAreInvalid() {
        assertThat(CarHelper.splitCarName("   ,toolongname,anotherlong")).isEmpty();
    }

    @Test
    @DisplayName("이름 앞뒤의 공백을 제거하고 유효한 이름만 반환")
    public void splitAndValidateCarNames_ShouldTrimAndReturnValidNames() {
        List<String> expectedValue = Arrays.asList("pobi", "crong");

        assertThat(CarHelper.splitCarName(" pobi , crong ,  toolongname "))
                .isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("우승자가 한 명일 경우 정확히 결정되는지 테스트")
    void isEquals_SingleWinner() {
        Car car1 = new Car(3, "car1");
        Car car2 = new Car(2, "car2");
        Car car3 = new Car(1, "car3");
        Cars cars = new Cars(Arrays.asList(car1, car2, car3));

        Cars winners = cars.determineWinners();

        assertThat(winners.getItems()).hasSize(1);
        assertThat(winners.getItems().get(0).displayCarName()).isEqualTo("car1");
    }

    @Test
    @DisplayName("여러 명의 우승자가 있을 경우 모두 선정되는지 테스트")
    void isEquals_MultipleWinner() {
        Car car1 = new Car(3, "car1");
        Car car2 = new Car(3, "car2");
        Car car3 = new Car(1, "car3");
        Cars cars = new Cars(Arrays.asList(car1, car2, car3));

        Cars winners = cars.determineWinners();

        assertThat(winners.getItems()).hasSize(2);
        assertThat(winners.getItems()).extracting("name").containsExactlyInAnyOrder("car1", "car2");
    }
}
