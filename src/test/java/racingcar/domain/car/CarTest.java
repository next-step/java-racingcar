package racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {

    @Nested
    @DisplayName("자동차 생성 성공 케이스")
    class SuccessCondition {

        private Car car;

        @BeforeEach
        void init() {
            this.car = new Car("엄태권");
        }

        @Test
        @DisplayName("5글자 미만의 이름으로 생성된 자동차는 해당이름과 0이라는 출발 포지션을 가진다.")
        void createNewCar() {
            assertThat(this.car.getPosition()).isZero();
            assertThat(this.car.getCarName()).isEqualTo("엄태권");
        }

        @Test
        @DisplayName("움직일 수 있는 조건이 된다면 자동차는 1칸 이동하게 된다.")
        void randomMove() {
            this.car.move(() -> true);

            assertThat(this.car.getPosition()).isEqualTo(1);
        }
    }

    @Nested
    @DisplayName("자동차 생성 실패 케이스")
    class FailCondition {

        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("비어있는 이름이나, 이름을 입력하지 않을 경우 이름 생성에 실패한다.")
        void createName_null_empty(String inputName) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Car(inputName))
                    .withMessage("이름은 비어있을 수 없습니다.");
        }

        @Test
        @DisplayName("5글자를 초과한 이름을 생성할 경우 이름 생성에 실패한다.")
        void createName_5글자초과() {
            String inputName = "ServerWizard";

            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Car(inputName))
                    .withMessage("이름은 5글자를 초과할 수 없습니다. 초과된 이름 : " + inputName);
        }
    }
}
