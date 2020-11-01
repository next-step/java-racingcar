package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }


    /*
        흠.. private 메소드는 어떤식으로 테스트하죠 ..ㅠㅠ 리플렉션까지 사용해서 테스트 를 해야하나요..?
        항상 이런 부분에서 테스트 공부를 실패했는데 ㅠㅠ; 궁금합니다..
        리플렉션이나 다른 방벙을 이용해서 테스트를 진행하는 글도있고
        public 으로 외부로 노출된 메소드만 테스트 해야 한다. 라는 글도 있는데
        리뷰어님은 어떻게 생각하시나요..?
        흑흑 ㅠㅠ 너무 슬픕니다.
     */
    @DisplayName("자동차 상태 테스트 전진 or 대기")
    @ParameterizedTest
    @CsvSource(value = {
            "1:False",
            "2:False",
            "3:False",
            "4:False",
            "5:True",
            "6:True",
            "7:True",
            "8:True",
            "9:True",
    }, delimiter = ':')
    public void test1(int value, boolean expected) {
        assertThat(car.goOrStay(value)).isEqualTo(expected);
    }

    @DisplayName("자동차 상태 테스트 전진 or 대기 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {
            "-1",
            "-2",
            "10"
    })
    public void test2(int value) {
        assertThatThrownBy(()->{
            car.goOrStay(value);
                }

        ).isInstanceOf(IllegalArgumentException.class);
    }
}
