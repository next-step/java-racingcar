package carracing.domain.car;

public enum Direction {

    FORWARD{
        @Override
        public Position exec(Position position) {
            position.move(ONE_STEP_VALUE);
            return  position;
        }
    },
    BACK{
        @Override
        public Position exec(Position position) {
            position.move(-ONE_STEP_VALUE);
            PositionValidator.validate(position);
            return position;
        }
    };

    private static final int ONE_STEP_VALUE = 1;
    public Position exec(Position position) { return position; };
}
