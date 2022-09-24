
import java.util.List;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarPlayTest {

    private static CarPlay carPlay;
    private static InputReview inputReview;
    private static int cars;
    private static int attempts;

    @BeforeEach
    void setTest() {
        inputReview = new InputReview(cars, attempts);
        carPlay = new CarPlay(inputReview);
    }

    @Test
    @DisplayName("0과 1만 포함된 랜덤 자동차 리스트를 출력하는지 확인")
    void randomCarListContainsOnlyOneAndZero() {

        cars = 3;
        attempts = 5;
        int maxNumber = 2;

        List<Integer> randomList = carPlay.carMovement();

        for (Integer randomElement : randomList) {
            assertThat(randomElement).isLessThan(maxNumber);
        }
    }

}