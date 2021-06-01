package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class CarTest {
    @Test
    public void  이동(){
        final Car car = new Car("dklfj",1);
        final Car actual = car.move(() -> true);
        Assertions.assertThat(actual.getPosition()).isEqualTo(1);

    }
    @Test
    public void 정지(){
        final Car car = new Car("dklfj",0);
        final Car actual = car.move(new MoveStrategy() {
            @Override
            public boolean isMovable() {
                return false;
            }
        });
        Assertions.assertThat(actual.getPosition()).isEqualTo(0);
    }
}
