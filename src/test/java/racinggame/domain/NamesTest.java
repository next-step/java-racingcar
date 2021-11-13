package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class NamesTest {

    @DisplayName("이름 목록의 생성을 테스트")
    @Test
    void createNames() throws Exception {
        Names names = Names.from("jae");

        assertThat(names).isNotNull();
    }

    @DisplayName("이름 목록을 올바르게 출력하는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"jae,han", "han"})
    void printNames(String text) throws Exception {
        Names names = Names.from(text);

        assertThat(names.printNames()).isEqualTo(text);
    }
}
