package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    String NAME = "names";
    Name name;

    @BeforeEach
    void setUp(){
        name = new Name(NAME);
    }

    @Test
    void createName(){
        assertThat(name).isEqualTo(new Name(NAME));
    }

    @Test
    void validName(){
        assertThatThrownBy(() -> {
            new Name("OverName");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void validEmptyName(String input){
        assertThatThrownBy(() -> {
            new Name(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
