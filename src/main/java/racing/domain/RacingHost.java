package racing.domain;

import java.util.List;

public interface RacingHost {

    Racing holdRacing(List<String> participants, int round);

}
