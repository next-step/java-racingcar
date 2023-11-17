package racing.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.Names;
import racing.model.RacingCar;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NamesTest {
    String[] names;
    
    @BeforeEach
    void init(){
        names = new String[1];
    }
    @Test
    @DisplayName("공백 입력 불가")
    void test1() throws Exception {
        names[0] = "";
        assertThatThrownBy(() -> new Names(names))
                .hasMessageContaining("공백");
    }

    @Test
    @DisplayName("이름 5글자 초과 불과")
    void test2() throws Exception {
        names[0] = "qweadzs";
        assertThatThrownBy(() -> new Names(names))
                .hasMessageContaining("이름은 최대 5글자");
    }
}