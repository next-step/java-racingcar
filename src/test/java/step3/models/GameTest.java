package step3.models;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameTest {
    List<Car> carList;

    @BeforeEach
    void initCarList() {
        carList = List.of(
                Car.init("a"),
                Car.init("b"),
                Car.init("c")
        );
    }

    @Test
    void Given_Numbers_When_PlayGame_Then_Equals_ResultSize() {
        int tryNumber = 5;
        Game game = new Game(carList, tryNumber);

        List<List<Car>> results = game.play();

        assertThat(results.size()).isEqualTo(tryNumber);
        results.forEach(result -> assertThat(result.size()).isEqualTo(carList.size()));
    }

    @Test
    void Given_NegativeTryNumber_When_CreateGame_Then_ThrowError() {
        assertThatThrownBy(() -> new Game(carList, -1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
