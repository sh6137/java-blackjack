package blackJack.function;

import blackJack.card.Denomination;
import blackJack.person.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Function {

    public List<Player> splitName(String players) {
        List<Player> playerList = new ArrayList<>();
        for(String player : players.split(",")){
            playerList.add(new Player(player.trim()));
        }
        return playerList;
    }

    public int addNumber(List<String> cards) {
        int sum = 0;
        for (String card: cards) {
            String firstWord = card.substring(0, 1);
            sum += wordToNumber(firstWord);
        }

        return sum;
    }

    private int wordToNumber(String firstWord) {
        String pattern = "^[0-9]*$";

        if(Pattern.matches(pattern, firstWord)){
            return Integer.parseInt(firstWord);
        }

        return method(firstWord);
    }

    private int method(String firstWord) {
        if(firstWord.equals(Denomination.ACE.getViewNumber())){
            return 11;
        }

        return 10;
    }
}
