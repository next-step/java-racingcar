package CarRacing;

public enum Direction {

    FORWARD{
        @Override
        public Position exec(Position position) {
            position.location++;
            return  position;
        }
    },
    BACK{
        @Override
        public Position exec(Position position) {
            position.location--;
            PositionValidator.validate(position);
            return position;
        }
    };

    public Position exec(Position position) { return position; };
}
