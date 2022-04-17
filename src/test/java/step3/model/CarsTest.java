package step3.model;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Cars 테스트")
class CarsTest {

    private EachTryResult allSuccessResult;
    private Names names;

    @BeforeEach
    void setUp() {
        allSuccessResult = new EachTryResult(Arrays.asList(1, 1, 1));
        names = new Names("가,나,다");
    }

    @Test
    void 각_Car들이_전진을_시도하게한다() {
        TryStrategy alwaysTrueStrategy = () -> true;
        Cars successCars = new Cars(names, alwaysTrueStrategy);

        successCars.tryOnceEach();

        assertThat(successCars.getEachTryResult()).usingRecursiveComparison().isEqualTo(allSuccessResult);
    }

}