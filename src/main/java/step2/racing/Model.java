package step2.racing;

import java.util.Objects;

public class Model {
    private String model;

    public Model(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model1 = (Model) o;
        return Objects.equals(model, model1.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model);
    }
}
