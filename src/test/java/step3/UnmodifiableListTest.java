package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author : 0giri
 * @since : 2023/04/18
 */
public class UnmodifiableListTest {

    private List<State> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
        list.add(new State(true));
        list.add(new State(true));
        list.add(new State(true));
    }

    @Test
    void unmodifiableList_변경시_예외() {
        List<State> unmodifiableList = Collections.unmodifiableList(list);
        assertThatThrownBy(() -> unmodifiableList.add(new State(true)))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void unmodifiableList_요소_변경_가능() {
        List<State> unmodifiableList = Collections.unmodifiableList(list);
        assertThat(unmodifiableList.get(0).state).isTrue();
        unmodifiableList.get(0).state = false;
        assertThat(unmodifiableList.get(0).state).isFalse();
    }

    @Test
    void unmodifiableList_요소_변경시_원본_리스트_요소도_함께변경() {
        List<State> unmodifiableList = Collections.unmodifiableList(list);
        assertThat(list.get(0).state).isTrue();
        unmodifiableList.get(0).state = false;
        assertThat(list.get(0).state).isFalse();
    }

    static class State {
        boolean state;

        public State(boolean state) {
            this.state = state;
        }
    }
}
