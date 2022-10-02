package RacingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RacingTest {

    @Test
    @DisplayName("자동차 리스트 초기화 테스트")
    void nameValidateTest() {
        Racing racing = new Racing("jason,tom,jane", 5);
        String[] result = new String[]{"jason", "tom", "jane"};
        List<Car> list = racing.getCarList();

        for (int i = 0; i < list.size(); i++) {
            assertThat(list.get(i).getName()).isEqualTo(result[i]);
        }
    }
}
