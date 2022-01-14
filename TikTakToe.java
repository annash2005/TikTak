
public class TikTakToe{

    private char[][] board;
    private byte x = 3;
    private byte y = 3;
    private char currentPlayerMark;
    public TicTacToe(){
        board = new char[3][3];
        currentPlayerMark = 'x';
        initializeBoard();

        MyListenerAction a = new MyListenerAction();
    }

    public char getCurrentPlayerMark(){

        return currentPlayerMark;


    }
    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

    }
    public void printBoard(){
        System.out.println("_____________");

        for (int i = 0; i < x; i++) {
            System.out.print("| ");
            for (int j = 0; j < y; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("_____________");
        }
    }

    public boolean checkForWin() {

        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());

    }

    private boolean check(char x, char y, char z){

        if ((x == y) && (y == z) && (x == z) && (x != '-')){return true;}
        else {return false;}
    }
    private boolean checkRowsForWin(){

        boolean flag = false;
        for(int a = 0; a < x; a ++){
            if(check (board[a][0],board [a][1],board [a][2])){
                flag = true;
                break;
            }
        }
        return flag;
    }

    private boolean checkColumnsForWin(){

        boolean flag = false;
        for(int a = 0; a < x; a ++){
            if(check (board[0][a],board [1][a],board [2][a])){
                flag = true;
                break;
            }


        }
        return flag;
    }
    private boolean checkDiagonalsForWin() {

        if(check(board[0][0], board[1][1], board[2][2]) || (check(board[0][2], board[1][1], board[2][0]))){
            return true;
        }
        else{return false;}
    }


    public boolean isBoardFull() {

        boolean isFull = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    isFull = false;
                }
            }
        }

        return isFull;
    }

    public void changePlayer() {
        if (currentPlayerMark == 'x') {
            currentPlayerMark = 'o';
        }
        else {
            currentPlayerMark = 'x';
        }
    }

    public boolean placeMark(int row, int col) {

        // Make sure that row and column are in bounds of the board.
        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (board[row][col] == '-') {
                    board[row][col] = currentPlayerMark;
                    if( currentPlayerMark == 'x'){
                        System.out.printf("x", board[row][col]);
                    }else{
                        System.out.printf("o", board[row][col]);
                    }

                    return true;
                }
            }
        }

        return false;
    }
}