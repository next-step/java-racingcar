package carRacingWinner.test;

import carRacingWinner.domain.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    @DisplayName("이름 반환")
    public void getName() {

        List<String> list = List.of("pobi","crong","honux");

        assertThat(new Name("pobi,crong,honux").getName()).isEqualTo(list);
    }
}