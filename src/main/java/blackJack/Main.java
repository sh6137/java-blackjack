package blackJack;

import blackJack.card.Card;
import blackJack.function.Function;
import blackJack.person.Dealer;
import blackJack.person.Person;
import blackJack.person.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        Scanner scanner = new Scanner(System.in);
        String strplayers = scanner.nextLine();
        Person p = new Dealer("dealer");
        Function function = new Function();
        List<Player> players = function.splitName(strplayers);
        Card card = new Card();
        List<String> cardList = card.getCardList();

        Collections.shuffle(cardList);
        Dealer dealer = new Dealer("dealer");
        for (int i = 0; i < 2; i++) {
            dealer.received(cardList.get(0));
            cardList.remove(0);
        }

        System.out.println("딜러와 " + strplayers + " 에게 2장의 카드를 나누었습니다.");
        System.out.println("딜러 : " + dealer.getCards());
        for (Player player : players) {
            for (int i = 0; i < 2; i++) {
                player.received(cardList.get(0));
                cardList.remove(0);
            }
            System.out.println(player.getName() + " : " + player.getCards());
        }

        for (Player player : players) {
            player.updateSum(function.addNumber(player.getCards()));

            cardList = function.isLessThanBlackJack(player, cardList);
        }

        dealer.updateSum(function.addNumber(dealer.getCards()));

        function.isLessThanSIXTEEN(dealer, cardList.get(0));
        cardList.remove(0);
        dealer.updateSum(function.addNumber(dealer.getCards()));

        System.out.println(dealer.getName() + " 카드 : " + dealer.getCards() + " - 결과 : " + dealer.getSum());
        for(Player player : players){
            System.out.println(player.getName() + " 카드 : " + player.getCards() + " - 결과 : " + player.getSum());
            function.compareSum(dealer, player);
        }

        System.out.println("## 최종 승패");
        System.out.println(dealer.getName() + " : " + dealer.getWinCount() + "승 " + dealer.getLoseCount() + "패");
        for(Player player : players){
            System.out.println(player.getName() + " : " + player.getWin());
        }


    }
}
