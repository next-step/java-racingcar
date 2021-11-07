package car_racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingResultTest {

    @Test
    void update() {
        // given
        RacingResult racingResult = new RacingResult();
        String firstResult = racingResult.getResult();
        Car[] arrCars = new Car[2];
        arrCars[0] = new Car("--");
        arrCars[1] = new Car("---");

        Cars cars = new Cars(arrCars);

        // when
        racingResult.update(cars);
        String updatedResult = racingResult.getResult();

        // then
        assertThat(updatedResult).isNotEqualTo(firstResult);
        assertThat(updatedResult).isEqualTo("--\n---\n\n");
    }

    @Test
    void getResult() {
        // given
        RacingResult racingResult = new RacingResult("--\n---\n\n");

        // when
        String result = racingResult.getResult();

        // then
        assertThat(result).isEqualTo("--\n---\n\n");
    }


}