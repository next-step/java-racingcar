package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSplitterTest {

    @Test
    @DisplayName("쉼표(,)를 기준으로 차 이름이 나오나?")
    void split_car_name_based_on_commas() {
        //given
        //when
        String[] result = StringSplitter.splitBasedOn("santa,sona,corna", ",");

        //then
        assertThat(result).containsExactly("santa", "sona", "corna");
    }
}
