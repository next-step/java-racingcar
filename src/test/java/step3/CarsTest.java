package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Cars;
import step3.domain.Sepatation;

import static org.assertj.core.api.Assertions.assertThat;


class CarsTest {

    @Test
    @DisplayName("입력받은 문자 split 테스트")
    void splitTest() {
        Sepatation sepatation = new Sepatation();
        String[] names = sepatation.nameSepatation("pobi,crong,honux");
        assertThat(names).containsExactly("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("split 된 입력받은 문자로 자동차 그룹 생성 테스트")
    void createCarList() {
        String input = "pobi,crong,honux";
        String[] names = input.split(",");

        Cars cars = new Cars(names);
        assertThat(cars.getCarList().get(0).getName()).isEqualTo("pobi");
        assertThat(cars.getCarList().get(1).getName()).isEqualTo("crong");
        assertThat(cars.getCarList().get(2).getName()).isEqualTo("honux");
    }
}