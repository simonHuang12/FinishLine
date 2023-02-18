import java.util.Arrays;

public class Game {
    private int[] p1 = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] p2 = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    private int p1pos = 1;
    private int p2pos = 1;
    public Game(){
        System.out.println("Player 1's board");
        System.out.println(Arrays.toString(p1));
        System.out.println("Player 2's board");
        System.out.println(Arrays.toString(p2));
    }
    public int[] getP1(){
        return p1;
    }
    public int[] getP2(){
        return p2;
    }

    public int roll() {
        return (int) (Math.random() * 6) + 1;
    }

    public void movePos(int player, int dice1, int dice2) {
        boolean matchPosOne1 = dice1 == p1pos+1 || dice2 == p1pos+1;
        boolean matchPosTotal1 = dice1 + dice2 == p1pos+1;
        boolean matchPosOne2 = dice1 == p2pos+1 || dice2 == p2pos+1;
        boolean matchPosTotal2 = dice1 + dice2 == p2pos+1;
        if (player == 1) {
            if (matchPosOne1 || matchPosTotal1){
                p1[p1pos-1] = 0;
                p1[p1pos] = 1;
                p1pos++;
                System.out.println(Arrays.toString(p1));
            }else {
                System.out.println("Miss! Next turn...");
                System.out.println(Arrays.toString(p1));
            }
        }else if (player == 2) {
            if (matchPosOne2 || matchPosTotal2){
                p2[p2pos-1] = 0;
                p2[p2pos] = 1;
                p2pos++;
                System.out.println(Arrays.toString(p2));
            }else {
                System.out.println("Miss! Next turn...");
                System.out.println(Arrays.toString(p2));
            }
        }
    }
}
