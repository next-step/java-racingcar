package step3.model;

import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Cars 테스트")
class CarsTest {

    private final TryStrategy alwaysTrueStrategy = () -> true;
    private Map<String, Integer> map;

    @BeforeEach
    void setUp() {
        map = new HashMap<>();
        map.put("가", 1);
        map.put("나", 1);
    }

    @Test
    void 각_Car들이_전진을_시도하게한다() {
        Names names = new Names("가,나");
        EachTryResult expect = new EachTryResult(map);
        Cars successCars = new Cars(names, alwaysTrueStrategy);

        successCars.tryOnceEach();

        assertThat(successCars.getEachTryResult()).usingRecursiveComparison().isEqualTo(expect);
    }

}