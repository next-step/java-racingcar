package carracing.domain.race.point;

import carracing.utils.RandomUtils;

public class RandomPointProvider implements PointProvider {
    public static final int THRESHOLD = 10;

    @Override
    public int getPoint() {
        return RandomUtils.getPoint(THRESHOLD);
    }
}
