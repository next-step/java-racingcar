package racing.model;

public class NamedRacingCar extends RacingCar {

    private String name;

    public NamedRacingCar(String name) {
        this.name = name;
    }

    @Override
    public CarDto mapToDto() {
        CarDto dto = super.mapToDto();
        dto.setName(name);
        return dto;
    }
}
