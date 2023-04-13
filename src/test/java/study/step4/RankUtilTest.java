package study.step4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RankUtilTest {

    @ParameterizedTest
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    void 랭킹_테스트(int input, String expected) {

        List positonList = Arrays.asList(5, 4, 3);
        List nameList = Arrays.asList("a", "b", "c");

        List[] ranks = RankUtil.ranking(positonList, nameList);

        assertThat(ranks[input].get(0)).isEqualTo(expected);

    }


    @ParameterizedTest
    @CsvSource(value = {"0:0:a", "0:1:b", "2:0:c"}, delimiter = ':')
    void 랭킹_동점자_테스트(int input, int input2, String expected) {

        List positonList = Arrays.asList(5, 5, 3);
        List nameList = Arrays.asList("a", "b", "c");

        List[] ranks = RankUtil.ranking(positonList, nameList);

        assertThat(ranks[input].get(input2)).isEqualTo(expected);

    }
}