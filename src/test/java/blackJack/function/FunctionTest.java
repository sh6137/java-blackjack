package blackJack.function;

import blackJack.card.Card;
import blackJack.person.Person;
import blackJack.person.Player;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import study.Car;

import java.util.ArrayList;
import java.util.List;

class FunctionTest {

    @Test
    void splitTest() {
        Function function = new Function();

        List<Player> p = function.splitName("유재석, 강호동");
        Assertions.assertThat(p.get(0).getName()).isEqualTo("유재석");
    }

    @Test
    void cardTest(){
        Card card = new Card();
        List<String> cards = card.getCardList();

        Assertions.assertThat(cards.size()).isEqualTo(52);

    }
}
