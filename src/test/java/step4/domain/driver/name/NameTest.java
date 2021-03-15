package step4.domain.driver.name;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.domain.startegy.name.NameLengthLessThanFive;
import step4.domain.startegy.name.NamingStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NameTest {

    private NamingStrategy strategy;

    @BeforeEach
    void setUp() {
        strategy = new NameLengthLessThanFive();
    }

    @DisplayName("Name 클래스의 인스턴스 생성시 부적절한 문자열 주입시 IllegalArgumentException 반환하는지 테스트")
    @ValueSource(strings = {"Youheeyeol's SketchBook", "Love Temperature", "nextstep"})
    @ParameterizedTest(name = "현재 반복 : {index} - 입력되는 값 : {arguments}")
    void createNameInstance_InValidationValue_IllegalArgumentException(String input) {
        // when and then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    assertThat(Name.from(input, strategy));
                }).withMessageMatching("이름에 사용되기에는 알맞은 값이 아닙니다.");
    }

    @DisplayName("Name 클래스의 인스턴스 생성시 유효한 문자열 주입시 알맞게 반환하는지 테스트")
    @ValueSource(strings = {"pobi", "brown", "jason"})
    @ParameterizedTest(name = "현재 반복 : {index} - 입력되는 값 : {arguments}")
    void getName_ValidationValue_Equal(String expected) {
        // given
        Name name = Name.from(expected, strategy);

        // when
        String actual = name.getName();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("Name 클래스의 인스턴스 생성시 유효한 문자열 주입시 알맞게 반환하는지 테스트")
    @ValueSource(strings = {"pobi", "brown", "jason"})
    @ParameterizedTest(name = "현재 반복 : {index} - 입력되는 값 : {arguments}")
    void equals_(String expected) {
        // given
        Name firstName = Name.from(expected, strategy);
        Name secondName = Name.from(expected, strategy);

        // when
        boolean actual = firstName.equals(secondName);

        // then
        assertThat(actual).isTrue();
    }

}