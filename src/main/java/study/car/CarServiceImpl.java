package study.car;

import java.util.List;

public class CarServiceImpl implements CarService {

    private MemoryCarRepository memoryCarRepository;

    public CarServiceImpl(MemoryCarRepository memoryCarRepository) {
        this.memoryCarRepository = memoryCarRepository;
    }

    @Override
    public long join(Car car) {
        long id = memoryCarRepository.save(car);
        return id;
    }

    @Override
    public Car findOneCar(Long id) {
        return memoryCarRepository.findCarById(id);
    }

    @Override
    public List<Car> findAllCars() {
        return memoryCarRepository.findCarAll();
    }

    @Override
    public void movingCar(Car car) {
        StringBuffer stringBuffer = new StringBuffer(car.getStatus());
        car.setStatus(String.valueOf(stringBuffer.append("-")));
    }
}
