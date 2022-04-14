package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Cars 테스트")
class CarsTest {

    @Test
    void 각_Car들이_전진을_시도하게한다() {
        TryStrategy alwaysTrueStrategy = () -> true;
        int carCount = 3;
        Cars successCars = new Cars(carCount, alwaysTrueStrategy);

        successCars.tryOnceEach();

        assertThat(successCars.getSuccessCountEach()).containsExactly(1, 1, 1);
    }

}