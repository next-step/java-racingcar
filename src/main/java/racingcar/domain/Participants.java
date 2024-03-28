package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Participants implements Iterable<Participant>{

    private static final String NAME_DELIMETER = ",";

    private List<Participant> participants;

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }
    public static Participants from(String names) {
        validateString(names);
        return new Participants(createParticipants(names.split(NAME_DELIMETER)));
    }

    private static List<Participant> createParticipants(String[] nameArray) {
        validateDuplicate(nameArray);
        return Arrays.stream(nameArray)
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    private static void validateDuplicate(String[] participantNames) {
        Set<String> nameSet = new HashSet<>(Stream.of(participantNames).collect(Collectors.toList()));
        if (participantNames.length > nameSet.size()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다. 참가자 이름을 다시 확인해주세요.");
        }
    }

    private static void validateString(String names) {
        if (null == names || names.trim().isEmpty()) {
            throw new IllegalArgumentException("전체 참가자 이름을 입력하세요.");
        }
    }

    @Override
    public Iterator<Participant> iterator() {
        return participants.iterator();
    }

    public int size() {
        return participants.size();
    }
}
