package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarNamesTest {
    private CarNames names;

    @BeforeEach
    public void setUp() {
        names = new CarNames("BMW,KIA,HONDA");
    }

    @Test
    @DisplayName("경주용 자동차 생성 개수 확인")
    public void createCarRaceCount() {
        assertThat(names.count()).isEqualTo(3);
    }

    @Test
    @DisplayName("경주용 자동차 이름확인")
    public void checkRaceCarName() {
        CarNames carNames = new CarNames("BMW,KIA,HONDA");
        assertAll(
                () -> assertThat(carNames.name(0)).isEqualTo("BMW"),
                () -> assertThat(carNames.name(1)).isEqualTo("KIA"),
                () -> assertThat(carNames.name(2)).isEqualTo("HONDA")
        );
    }
}
