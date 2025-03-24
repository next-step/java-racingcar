package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {
    @Test
    public void name이_null이거나_empty일경우_exception을_던진다(){
        assertThatThrownBy(() -> new CarName(""))
            .hasMessageContaining("name은 null이거나 빈 값일 수 없습니다.");

        assertThatThrownBy(() -> new CarName(null))
            .hasMessageContaining("name은 null이거나 빈 값일 수 없습니다.");
    }

    @Test
    public void name이_5자초과할경우_exception을_던진다(){
        assertThatThrownBy(() -> new CarName("charles"))
            .hasMessageContaining("name은 5자를 초과할 수 없습니다.");
    }
}
