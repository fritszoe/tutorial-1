package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CarServiceImplTest {
    @InjectMocks
    CarServiceImpl carService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreateAndFindAll(){
        Car car = new Car();
        car.setProductQuantity(10);
        car.setProductId("ef558e9f-1a39-460f-8860-71av6cd63bd6");
        car.setCarColor("brown");
        car.setProductName("Volvo");
        carService.create(car);

        List<Car> carList = carService.findAll();

        Car getCar = carList.get(0);

        assertEquals("ef558e9f-1a39-460f-8860-71av6cd63bd6", getCar.getProductId());
        assertEquals("brown", getCar.getCarColor());
        assertEquals("Volvo", getCar.getProductName());
        assertEquals(10, getCar.getProductQuantity());
    }

    @Test
    void testCreateAndFindById(){
        Car car = new Car();
        car.setProductQuantity(10);
        car.setProductId("ef558e9f-1a39-460f-8860-71av6cd63bd6");
        car.setCarColor("brown");
        car.setProductName("Volvo");
        carService.create(car);

        Car car2 = new Car();
        car2.setProductName("Mercedez");
        car2.setCarColor("Silver");
        car2.setProductQuantity(2);
        car2.setProductId("9b3a6703-565f-45af-85e8-5a2b343a2f46");
        carService.create(car2);

        assertNotNull(carService.findById("9b3a6703-565f-45af-85e8-5a2b343a2f46"));
        assertNotNull(carService.findById("ef558e9f-1a39-460f-8860-71av6cd63bd6"));
    }

    @Test
    void testUpdate() {
        Car car = new Car();
        car.setProductQuantity(10);
        car.setProductId("ef558e9f-1a39-460f-8860-71av6cd63bd6");
        car.setCarColor("brown");
        car.setProductName("Volvo");
        carService.create(car);

        Car updatedCar = new Car();
        updatedCar.setProductQuantity(8);
        updatedCar.setProductName("Volkswagen");
        updatedCar.setCarColor("black");
        updatedCar.setProductId("9b3a6703-565f-45af-85e8-5a2b343a2f46");
        carService.update("ef558e9f-1a39-460f-8860-71av6cd63bd6", updatedCar);

        car = carService.findById("ef558e9f-1a39-460f-8860-71av6cd63bd6");
        assertNotNull(car);
        assertEquals(car.getProductId(), "ef558e9f-1a39-460f-8860-71av6cd63bd6");
        assertEquals(car.getCarColor(), "black");
        assertEquals(car.getProductQuantity(), 8);
        assertEquals(car.getProductName(), "Volkswagen");
        assertNotEquals(car.getProductId(), "9b3a6703-565f-45af-85e8-5a2b343a2f46");
    }
}
