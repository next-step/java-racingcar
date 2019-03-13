package racing;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserInputBeanTest {

    @Test
    public void 클래스초기화() {
        UserInputValueObject user = new UserInputValueObject("5", "3");
        assertThat(user.getInputCarCount()).isEqualTo("5");
        assertThat(user.getInputCarTime()).isEqualTo("3");
    }


}