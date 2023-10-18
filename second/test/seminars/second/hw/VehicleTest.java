package seminars.second.hw;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import seminars.second.hw.Car;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class VehicleTest {

    private Car car;
    private Motorcycle motorcycle;

    @BeforeAll
    void setUp() {
        car = new Car("Audi", "TT", 2020);
        motorcycle = new Motorcycle("Honda", "Adventure", 2020);
    }

    // Проверить, что экземпляр объекта Car также является экземпляром транспортного средства (используя оператор instanceof).
    @Test
    void carIsVehicle() {
        assertTrue(car instanceof Vehicle);
    }

    // Проверить, что объект Car создается с 4-мя колесами.
    @Test
    void carCountWheels(){
        assertEquals(car.getNumWheels(), 4);
    }

    // Проверить, что объект Motorcycle создается с 2-мя колесами.
    @Test
    void motoCountWheels(){
        assertEquals(motorcycle.getNumWheels(), 2);
    }

    // Проверить, что объект Car развивает скорость 60 в режиме тестового вождения (используя метод testDrive()).
    @Test
    void carTestSpeed(){
        car.testDrive();
        assertEquals(car.getSpeed(), 60);
    }

    // Проверить, что объект Motorcycle развивает скорость 75 в режиме тестового вождения (используя метод testDrive()).
    @Test
    void motoTestSpeed(){
        motorcycle.testDrive();
        assertEquals(motorcycle.getSpeed(), 75);
    }
    // Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта) машина останавливается (speed = 0).
    @Test
    void carParkSpeed(){
        car.testDrive();
        car.park();
        assertEquals(car.getSpeed(), 0);
    }

    // Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта) мотоцикл останавливается (speed = 0).
    @Test
    void motoParkSpeed(){
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(motorcycle.getSpeed(), 0);
    }

}