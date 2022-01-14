
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.*;


public class GameFrame extends JFrame {
    private byte gameSize;
    private int row;
    private boolean[] xo = new boolean[9];
    private int col;
    TikTakToe game ;

    public void getGameSize() {
    }



    void buttonMaker() {

        JButton button1 = new JButton();
    }

    public void drawLine() {
    }

    GameFrame() {
        game = new TicTacToe();

        game.initializeBoard();
        System.out.println("Tic-Tac-Toe!");
        setSize(500, 350);
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();

        JButton[] btns = new JButton[9];
        for (Integer i = 0; i < 9; i++) {

            btns[i] = new JButton("");
            btns[i].setPreferredSize(new Dimension(300, 100));
            panel.add(btns[i]);
        }
        for (int i = 0; i < 9; i++) {

            xo[i] = false;



            btns[i].addActionListener(new MyListenerAction(i));




            //row = (int)(i/3);
            //col = i % 3;

        }



        GridLayout mygrid = new GridLayout(3, 3, 1, 1);
        panel.setLayout(mygrid);

        add(panel, BorderLayout.NORTH);
        setVisible(true);

    }
    public void play(){
        System.out.println("Current board layout:");
        game.printBoard();
        System.out.println("Player " + game.getCurrentPlayerMark() + ", enter an empty row and column to place your mark!");
        row = (int)(getIndex()/3);
        col = getIndex() % 3;
        game.placeMark(row, col);
        game.checkForWin();
        game.isBoardFull();



        if (game.isBoardFull() && !game.checkForWin())
        {
            System.out.println("Tie");
        }
        else
        {
            System.out.println("Current board layout:");
            game.printBoard();
            game.changePlayer();
            System.out.println(Character.toUpperCase(game.getCurrentPlayerMark()) + " Wins!");
        }

        game.changePlayer();
    }

    private int index;

    public int getIndex(){
        return index;
    }
    void setIndex(int k){
        index = k;
    }
    public static int btnPressed ( int i) {
        return i;
    }
    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }
}
class MyListenerAction implements ActionListener{
    private int index;
    public MyListenerAction (   int i      ){
        this.setIndex(i);
    }
    void setIndex(int k){
        index = k;
    }
    public void actionPerformed(ActionEvent event){
        GameFrame.btnPressed(index);
        System.out.println(index);



    }
    public int getIndex(){
        return index;
    }
}





