package com.jaeyeonling.racingcar.view;

import com.jaeyeonling.racingcar.utils.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class VisualRecorderTest {

    private VisualRecorder recorder;

    @BeforeEach
    void setUp() {
        recorder = new VisualRecorder();
    }

    @DisplayName("저장한 내용을 출력한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "asdsad",
            "sdge43g4343wg",
            "sdzfgdegrgWIHF3iur23ry2783t92fouh983OHU",
            "dsf3232\n"
    })
    void stringRecord(final String recodeData) {
        recorder.recode(recodeData);
        assertThat(recorder.visualize()).isEqualTo(recodeData + StringUtils.NEW_LINE);
    }

    @DisplayName("저장한 내용을 출력한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "asdsad",
            "sdge43g4343wg",
            "sdzfgdegrgWIHF3iur23ry2783t92fouh983OHU",
            "dsf3232\n"
    })
    void visualRecord(final String recodeData) {
        recorder.recode(() -> recodeData);
        assertThat(recorder.visualize()).isEqualTo(recodeData + StringUtils.NEW_LINE);
    }
}
