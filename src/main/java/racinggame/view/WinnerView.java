package racinggame.view;

import racinggame.domain.entity.Contest;
import racinggame.domain.entity.Participants;

import java.util.stream.Collectors;

public class WinnerView implements Contest.ReportingWinner {
    @Override
    public void report(Participants participants) {
        System.out.printf("우승자는 %s 입니다.", participants.rankTop().stream().map(l -> l.getName()).collect(Collectors.joining(",")));
    }
}
