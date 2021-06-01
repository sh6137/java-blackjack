package study;
import RentCompany.RentCompany;
import RentCompany.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static org.assertj.core.api.Assertions.assertThat;
public class StreamTest {
    private List<Integer> numbers;
    @BeforeEach
    void setUp() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }
    @Test
    public void sumAll() {
        final int result = numbers.stream()
                .mapToInt(number -> number)
                .sum();
        assertThat(result).isEqualTo(21);
    }
    @Test
    public void sumAllEven() {
        final int result = numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(number -> number)
                .sum();
        assertThat(result).isEqualTo(12);
    }
    @Test
    public void sumAllOverThree() {
        final int result = numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(number -> number)
                .sum();
        assertThat(result).isEqualTo(15);
    }
    @Test
    public void sumOverThreeAndDouble() {
        final int result = numbers.stream()
                .filter(number -> number > 3)
                .map(number -> number * 2)
                .reduce(0, (number1, number2) -> number1 + number2);
        assertThat(result).isEqualTo(30);
    }
    @Test
    public void mapToDouble() {
        final List<Integer> actual = numbers.stream()
                .map(number -> number * 2)
                .collect(Collectors.toList());
        assertThat(actual).containsExactly(2, 4, 6, 8, 10, 12);
    }
}
