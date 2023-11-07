package racing.car;


public class Car {

    private Name name;
    private int THRESHOLD = 4;
    private Position position;

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public Name name() {
        return this.name;
    }

    public Position position() {
        return this.position;
    }

    public void move(int input) {
        if (isOverThreshHold(input)) {
            Position currentPosition = this.position();
            this.position = currentPosition.move(1);
        }
    }

    private boolean isOverThreshHold(int input) {
        return THRESHOLD <= input;
    }


    public static class Name {

        private static final int NAME_LENGTH_LIMIT = 5;
        private final String name;

        public Name(String name) {
            this.validateNameLength(name);
            this.name = name;
        }

        public String toString() {
            return this.name;
        }

        private void validateNameLength(String name) {
            boolean overNameLengthLimit = NAME_LENGTH_LIMIT < name.length();
            if (overNameLengthLimit) {
                throw new ValidationException("name can't over 5 letters");
            }
        }
    }
}
