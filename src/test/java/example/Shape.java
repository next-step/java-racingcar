package example;
public class Shape {
    private final int numberOfSides;

    public Shape(int numberOfSides) {
        if (numberOfSides < 3 || numberOfSides == Integer.MAX_VALUE) {
            throw new IllegalArgumentException();
        }
        this.numberOfSides = numberOfSides;
    }

    public int numberOfSides() {
        return numberOfSides;
    }

    public String description() {
        if (numberOfSides == 3)
        {
            return "Triangle";
        } else if (numberOfSides == 4) {
            return "Square";
        } else if (numberOfSides == 5) {
            return "Pentagon";
        } else {
            return "Shape with " + numberOfSides + " sides";
        }
    }
}
