package carRacingWinner.test;

import carRacingWinner.entity.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputTest {
    @Test
    @DisplayName("들어오는 이름 구분")
    public void divisionName() {
        List<String> list = new ArrayList<>();
        list.add("pobi");
        list.add("crong");
        list.add("honux");

        assertThat(new Name("pobi,crong,honux").getName()).isEqualTo(list);
    }
}
