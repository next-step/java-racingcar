package step3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    @ParameterizedTest
    @CsvSource(value = {"2:3", "0:2", "3:0", "0:0"}, delimiter = ':')
    void start(int participantNumber, int iterate) {
        //when
        Racing racing = new Racing(participantNumber, iterate);
        racing.start();
        List<List<Integer>> participantsRecords = racing.getParticipantsRecord();

        //then
        assertThat(participantsRecords.size()).isEqualTo(participantNumber);
        for (int i = 0; i < participantsRecords.size(); i++) {
            assertThat(participantsRecords.get(i).size()).isEqualTo(iterate);
        }
        for (List<Integer> participantsRecord : participantsRecords) {
            if (participantsRecord.size() < 2) {
                break;
            }
            for (int i = 1; i < participantsRecord.size(); i++) {
                assertThat(participantsRecord.get(i - 1)).isLessThanOrEqualTo(participantsRecord.get(i));
            }
        }
    }
}