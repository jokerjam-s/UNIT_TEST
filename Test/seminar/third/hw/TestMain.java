package seminar.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import seminars.third.hw.MainHW;

public class TestMain {

    private MainHW mainHW;

    @BeforeEach
    void setUp(){
        mainHW = new MainHW();
    }

    @ParameterizedTest
    @ValueSource(ints = {-7, -5, 0, 1, 5, 7} )
    void numIsOdd(int num){
        mainHW.numIsEven();
    }

    @ParameterizedTest
    @ValueSource(ints = {-6, -4, 0, 2, 4, 6} )
    void numIsEven(int num){

    }
}
