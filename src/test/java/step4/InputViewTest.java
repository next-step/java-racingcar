package step4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    private InputView inputView;

    @DisplayName("입력 받은 자동차 이름을 ,로 자른다")
    @Test
    void splitUserCarName() {
        String carNames = "soojung,crystal,han";
        int moveCount = 7;
        inputView = new InputView(carNames, moveCount);
        assertThat(inputView.splitCarName()).containsExactly("soojung", "crystal", "han");
    }

    @DisplayName("자동차 이름을 부여하면 유저를 해당 이름으로 생성해준다.")
    @Test
    void checkUserCarname() {
        List<Car> compareCars = Stream.of(new Car("pobi", ""), new Car("crong", ""), new Car("honux", ""))
                                      .collect(
                                              Collectors.toList());
        String carNames = "pobi,crong,honux";
        int moveCount = 5;
        inputView = new InputView(carNames, moveCount);
        inputView.setCars();
        List<Car> cars = inputView.getCars();

        assertAll(() -> assertThat(cars).hasSameSizeAs(compareCars),
                  () -> assertThat(cars.get(0).getName()).isEqualTo(compareCars.get(0).getName()),
                  () -> assertThat(cars.get(1).getName()).isEqualTo(compareCars.get(1).getName()),
                  () -> assertThat(cars.get(2).getName()).isEqualTo(compareCars.get(2).getName())
        );

    }
}
