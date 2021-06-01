package blackJack;

import blackJack.card.Card;
import blackJack.function.Function;
import blackJack.person.Dealer;
import blackJack.person.Player;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        Scanner scanner = new Scanner(System.in);
        String strplayers = scanner.nextLine();

        Function function = new Function();
        List<Player> players = function.splitName(strplayers);
        Card card = new Card();

        Collections.shuffle(card.getCardList());
        Dealer dealer = new Dealer("dealer");
        for (int i = 0; i < 2; i++) {
            dealer.received(card.getCardList().get(0));
            card.getCardList().remove(0);
        }
        for(Player player : players){
            for(int i = 0; i < 2; i++){
                player.received(card.getCardList().get(0));
                card.getCardList().remove(0);
            }
            System.out.println(player.getCards());
        }
        System.out.println(dealer.getCards());

        function.addNumber(dealer.getCards());


//        Player player = new Player(players.get(0),)



//        for(String str : card.getCardList()){
//            System.out.println(str);
//        }

    }
}
