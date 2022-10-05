package racing.core;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode
@RequiredArgsConstructor
@Getter
@Builder
public class RacingDto {
    private final int carCount;
    private final int tryCount;
}
