package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TryNoTest {

    TryNo tryNo;
    private static final int TRY_NUM = 3;

    @BeforeEach
    void setUp(){
        tryNo = new TryNo(TRY_NUM);
    }

    @Test
    void createTryNo(){
        assertThat(tryNo).isEqualTo(new TryNo(TRY_NUM));
    }

    @Test
    void validTryNo(){
        assertThatThrownBy(() ->{
            new TryNo(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isZeroTest(){
        assertThat(tryNo.isZero()).isFalse();
        assertThat(new TryNo(0).isZero()).isTrue();
    }

    @Test
    void nextTest(){
        assertThat(tryNo.next()).isTrue();
        assertThat(tryNo.next()).isTrue();
        assertThat(tryNo.next()).isTrue();
        assertThat(tryNo.next()).isFalse();
    }
}
