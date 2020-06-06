package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    private OutputView outputView;

    @BeforeEach
    public void setUp() {
        outputView = new OutputView();
    }

    @DisplayName("출력 문자 확인 테스트")
    @Test
    public void drawRepeatTest() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        Method method = outputView.getClass().getDeclaredMethod("makeResultString", int.class, String.class);
        method.setAccessible(true);

        String result = (String) method.invoke(outputView, 3, "ho");

        assertThat(result).isEqualTo("ho: ---");

    }


}