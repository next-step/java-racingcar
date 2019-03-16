package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SessionTest {
    @Test
    public void put_data() {
        Session.put("key", "value");
        assertThat(Session.get("key")).isEqualTo("value");
    }

    @Test
    public void has_no_data() {
        Session.put("key", "value");
        Session.clear();

        assertThat(Session.get("key")).isNull();
    }
}
