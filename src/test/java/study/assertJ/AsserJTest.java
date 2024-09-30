package study.assertJ;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AsserJTest {

    @Test
    public void containsTest() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2));
        assertThat(list).contains(1);
        assertThat(list).contains(2);
        assertThat(list).contains(2, 1);
    }

    @Test
    public void containsOnlyTest() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2));
        assertThat(list).containsOnly(1, 2);
        assertThat(list).containsOnly(2, 1);

        //containsOnly는 contains와 달리 모든 값을 가지되 순서는 바뀔 수 있다.
//        assertThat(list).containsOnly(1);
    }

    @Test
    public void containsExactlyTest() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2));
        assertThat(list).containsExactly(1, 2);

        //containsExactly은 동일한 인덱스를 가져야만 한다.
//        assertThat(list).containsExactly(2,1);
    }

    @Test
    public void assertThatThrownByTest() {
        assertThatThrownBy(() -> {
            throw new Exception("Next Step 19기 화이팅!");
        }).isInstanceOf(Exception.class)
                .hasMessageContaining("Next Step 19기");
    }

    @Test
    public void assertThatExceptionOfTypeTest() {
        assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> {
                    throw new NullPointerException("is Null!");
                })
                .withMessage("%s!", "is Null")
                .withMessageContaining("Null")
                .withNoCause();
    }

    @Test
    public void assertThatNullPointerExceptionTest() {
        assertThatNullPointerException().isThrownBy(() -> {
                    throw new NullPointerException("is Null!");
                })
                .withMessage("%s!", "is Null")
                .withMessageContaining("Null")
                .withNoCause();
    }

    @Test
    public void assertThatExceptionOfTypeHasCauseTest() {
        assertThatExceptionOfType(Exception.class).isThrownBy(() -> {
                    throw new Exception(new NullPointerException("is Null!"));
                })
                .withMessageContaining("Null");
    }

    @Test
    public void assertThatCodeTest() {
        assertThatCode(() -> {
            throw new Exception("테스트!!");
        }).hasMessageEndingWith("스트!!");
    }
}
