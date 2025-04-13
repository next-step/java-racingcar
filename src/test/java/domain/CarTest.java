package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("차량 생성 테스트")
    public void createCarTest() {
        Car pobi = new Car("pobi");
        Car brown = new Car("brown");
        Car pobi2 = new Car("pobi");
        assertAll(
            () -> assertThat(pobi).isEqualTo(pobi2),
            () -> assertThat(pobi).isNotEqualTo(brown),
            () -> assertThat(pobi.compareTo(brown)).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("차량 생성 테스트 2 - 위치 비교")
    public void createCarTest2() {
        Car pobi = new Car("pobi", new Position(5));
        Car brown = new Car("brown", new Position(4));
        Car honux = new Car("honux", new Position(6));
        assertAll(
            () -> assertThat(pobi.compareTo(brown)).isEqualTo(1),
            () -> assertThat(pobi.compareTo(honux)).isEqualTo(-1)
        );
    }

    @Test
    @DisplayName("차량 생성 실패 테스트 - 이름 5글자 이내, 0글자 초과")
    public void createCarTest3() {
        assertAll(
            () -> assertThatIllegalArgumentException().isThrownBy(() -> new Car("pobi123")),
            () -> assertThatIllegalArgumentException().isThrownBy(() -> new Car(""))
        );
    }

    @Test
    @DisplayName("차량 이동 테스트")
    public void moveCarTest() {
        Car pobi = new Car("pobi");
        pobi.moveWithCondition(true);
        assertThat(pobi.getPositionValue()).isEqualTo(1);
    }

    @Test
    @DisplayName("조건에 따른 이동 테스트 - 이동 성공")
    public void moveCarWithConditionTest() {
        Car pobi = new Car("pobi");
        pobi.moveWithCondition(true);
        assertThat(pobi.getPositionValue()).isEqualTo(1);
    }

    @Test
    @DisplayName("조건에 따른 이동 테스트 - 이동 실패")
    public void moveCarWithConditionTest2() {
        Car pobi = new Car("pobi");
        pobi.moveWithCondition(false);
        assertThat(pobi.getPositionValue()).isEqualTo(0);
    }

    @Test
    @DisplayName("랜덤 결과에 따른 차량 이동 - 무조건 실패")
    public void moveCarWithRandomResult() {
        Car pobi = new Car("pobi");
        CustomizedRandom random = new CustomizedRandom(3);
        pobi.moveWithCondition(random.getResult());
        assertThat(pobi.getPositionValue()).isEqualTo(0);
    }
}
