package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.view.ResultView;

import java.util.Arrays;

public class CarGroupTest {
    CarGroup carGroup;

    @BeforeEach
    public void onLoad() {
        carGroup = new CarGroup(new String[]{"str", "text", "java"});
    }

    @ParameterizedTest
    @ValueSource(strings = {"str,test,java", "ho,gi,do", "py,xx,wr"})
    public void nameSplit(String names) {
        String[] arrName = names.split(",");
        Arrays.stream(arrName).forEach(name -> {
                Assertions.assertThat(names).contains(name);
        });
    }

    @Test
    public void getTopLocation() {
        Assertions.assertThat(carGroup.getTopLocation()).isEqualTo(0);
    }
    @Test
    public void getWinnerNames() {
        Assertions.assertThat(carGroup.getWinnerNames()).isEqualTo("str, text, java");
    }

}
