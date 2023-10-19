package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MainHWTest {
    private MainHW mainHW;

    @BeforeEach
    void setUp() {
        mainHW = new MainHW();
    }

    @ParameterizedTest
    @ValueSource(ints = {-8, -4, -2, 0, 2, 4, 8})
    void numIsEvenTest(int num) {
        assertThat(mainHW.evenOddNumber(num)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {-7, -3, -1, 1, 3, 7})
    void numIsOddTest(int num) {
        assertThat(mainHW.evenOddNumber(num)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -5, -3, 0, 2, 10, 15, 25, 100, 10, 115, 120})
    void numOutRegionTest(int num){
        assertThat(mainHW.numberInInterval(num)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {26, 30, 40, 45, 50, 55, 75, 95, 99})
    void numInRegionTest(int num){
        assertThat(mainHW.numberInInterval(num)).isTrue();
    }

}
