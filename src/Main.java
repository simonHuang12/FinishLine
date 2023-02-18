import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_BLUE = "\u001B[34m";
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        int turn = 0;
        boolean p1Win;
        boolean p2Win;
        while ((game.getP1()[game.getP1().length-1] != 1)||(game.getP2()[game.getP2().length-1] != 1)){
            p1Win = (game.getP1()[game.getP1().length-1] == 1);
            p2Win = (game.getP2()[game.getP2().length-1] == 1);
            if (turn % 2 == 0){
                System.out.println(ANSI_BLUE+"Player 1's turn"+ANSI_RESET);
            }else {
                System.out.println(ANSI_RED+"Player 2's turn"+ANSI_RESET);
            }
            String input = scanner.nextLine();
            int dice1 = game.roll();
            int dice2 = game.roll();
            System.out.println("Dice 1: "+dice1+" Dice 2: "+dice2);
            if (turn % 2 == 0){
                game.movePos(1, dice1, dice2);
            }
            if (turn % 2 == 1){
                game.movePos(2, dice1, dice2);
            }
            turn++;
            if (p1Win){
                System.out.println(ANSI_BLUE+"Player 1 wins!"+ANSI_RESET);
                break;
            }else if (p2Win){
                System.out.println(ANSI_RED+"Player 2 wins!"+ANSI_RESET);
                break;
            }
        }

    }
}