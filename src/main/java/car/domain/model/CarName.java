package car.domain.model;

public class CarName {

    private String text;

    public CarName(String text) {
        textValidate(text);
        this.text = text;
    }

    private void textValidate(final String carName) {
        if (carName.length() > 5) throw new RuntimeException();
    }

    public String getText() {
        return text;
    }

}
