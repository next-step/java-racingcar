package study.record;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class UserTest {
    @Test
    void create() {
        User pobi = new User("pobi", "포비", 52);
        assertThat(pobi.id()).isEqualTo("pobi");
        assertThat(pobi.name()).isEqualTo("포비");
        assertThat(pobi.age()).isEqualTo(52);
        assertThat(pobi).isEqualTo(new User("pobi", "포비", 52));
    }
}