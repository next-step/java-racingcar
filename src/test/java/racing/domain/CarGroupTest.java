package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

public class CarGroupTest {
    CarGroup carGroup;

    @ParameterizedTest
    @ValueSource(strings = {"str,test,java", "ho,gi,do", "py,xx,wr"})
    public void nameSplit(String names) {
        String[] arrName = names.split(",");
        Arrays.stream(arrName).forEach(name -> {
                Assertions.assertThat(names).contains(name);
        });
    }
}
