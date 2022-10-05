package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private Separation separation = new Separation();
    private List<String> names = new ArrayList<>();

    @BeforeEach
    void beforeEach() {
        names = separation.nameSeparation("pobi,crong,honux");
    }

    @Test
    @DisplayName("입력받은 문자 split 테스트")
    void splitTest() {
        assertThat(names).containsExactly("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("split 된 입력받은 문자로 자동차 그룹 생성 테스트")
    void createCarList(String initValue) {
        Cars cars = new Cars(names);
        assertThat(cars.getCarList().get(0).getName()).isEqualTo("pobi");
        assertThat(cars.getCarList().get(1).getName()).isEqualTo("crong");
        assertThat(cars.getCarList().get(2).getName()).isEqualTo("honux");
    }
}