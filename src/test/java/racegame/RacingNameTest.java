package racegame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingNameTest {

    RacingName racingName = new RacingName();

    @Test
    void nameInput() {

    }

    @DisplayName(value = "배열로 문자열을 받아 5글자가 넘으면 false반환 안넘으면 true")
    @Test
    void nameCheckTest() {
        String[] nameListTest = new String[]{"car1", "car2", "car3", "car4"};
        assertThat(racingName.nameCheck(nameListTest)).isTrue();
    }


}
