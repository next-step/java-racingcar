package race.datamapper;

import race.car.dto.CarInfoDto;

public class RaceDataMapper {
    private RaceDataMapper() {
    }

    public static CarInfoDto toCarInfoDto(int location, String name) {
        return new CarInfoDto(location, name);
    }
}
