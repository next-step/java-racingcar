package racing.core;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode
@RequiredArgsConstructor
@Builder
public class RacingDto {
    private final int carCount;
    private final int tryCount;
}
