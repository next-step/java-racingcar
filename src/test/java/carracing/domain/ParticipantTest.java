package carracing.domain;

import carracing.domain.entity.Name;
import carracing.domain.entity.Participant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantTest {

  static Stream<Arguments> generateArray() {
    return Stream.of(
            Arguments.of("james,kevin,tune", Arrays.asList("james","kevin","tune"),
            Arguments.of("matt,shell,kid", Arrays.asList("matt","shell","kid"))));

  }

  @ParameterizedTest
  @MethodSource("generateArray")
  @DisplayName("문자열로 이름 목록을 받아 파싱한뒤 List형태로 이름을 각각 반환한다.")
  void ofTest(String names, List<String> nameList) {
    Participant participant = Participant.parse(names);
    for(Name name : participant.getParticipant()) {
      assertThat(nameList.contains(name.getName())).isTrue();
    }
  }


}