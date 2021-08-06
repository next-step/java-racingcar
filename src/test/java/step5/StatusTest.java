package step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StatusTest {

    @Test
    @DisplayName("상태값 증가를 확인한다")
    public void 상태값_증가를_확인한다(){
        //given
        Status status = new Status(0);
        //when
        status.increase();
        //then
        assertThat(status).isEqualTo(new Status(1));
    }

    @Test
    @DisplayName("상태값이 음수로 초기화되면 익셉션이 발생한다")
    public void 상태값이_음수로_초기화되면_익셉션이_발생한다(){
        //given
        //when
        //then
        assertThatThrownBy(() -> new Status(-1)).isInstanceOf(IllegalArgumentException.class);
    }
}
