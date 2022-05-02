package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    Car mockCar1;
    Car mockCar2;
    StringBuilder sb;

    @BeforeEach
    void setUp() {
        sb = new StringBuilder();
        sb.append("---");

        mockCar1 = new Car("Tayo", new StringBuilder(), 0);
        mockCar2 = new Car("Tayo", sb, 3);
    }

    @Test
    void 자동차_이름을_넣었을때_객체_생성() {
        assertThat(Car.create("Tayo"))
                .usingRecursiveComparison()
                .isEqualTo(mockCar1);
    }

    @Test
    void 자동차_이름_가져오기() {
        assertThat(mockCar1.getName()).isEqualTo("Tayo");
    }

    @Test
    void 자동차_전진_상태_가져오기() {
        assertThat(mockCar2.getSteps()).contains("---");
    }

    @Test
    void 자동차_전진_횟수_가져오기() {
        assertThat(mockCar2.getForward()).isEqualTo(3);
    }

    @Test
    void 자동차_전진_추가_확인() {
        mockCar2.addForward();
        assertThat(mockCar2.getForward()).isEqualTo(4);
    }
}