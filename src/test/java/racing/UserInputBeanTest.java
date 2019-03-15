package racing;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class UserInputBeanTest {
    @Test
    public void 클래스초기화() {
        UserInputValueObject user = new UserInputValueObject("jypwebac,asdkf,wejhfas", 3);
        assertThat(user.getInputCarNames().size()).isEqualTo(3);
        assertThat(user.getInputCarTime()).isEqualTo(3);
    }
}