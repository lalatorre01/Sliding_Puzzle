package COSC526.q7;

public class Game {
    private final char[][] currentBoard;
    private final char[][] goalBoard;
    private final char BLANK = ' ';
    private int x, y; //location of empty slot in current board
    private final Generator generator;

    public Game() {
        //create generator
        generator = new Generator();
        currentBoard = generator.generateInitialBoard();
        goalBoard = generator.generateGoalBoard();

        //find the location of x and y
        for(int i = 0 ; i < currentBoard.length; i++){
            for(int j = 0; j < currentBoard[i].length;j++){
                if(currentBoard[i][j] == BLANK ){
                    x = i;
                    y = j;
                    return;

                }
            }
        }

    }
    public void up(){
        //swap the tile with the one above it, if x > 0
        if(x > 0){
            currentBoard[x][y] = currentBoard[x-1][y];
            currentBoard[x-1][y] = BLANK ;
            x--; //update the empty slot position
        }
    }
    public void down(){
        //swap the tile with the one below it, if x < the current board - 1
        if(x < currentBoard.length - 1){
            currentBoard[x][y] = currentBoard[x+1][y];
            currentBoard[x+1][y] = BLANK ;
            x++;//update the empty slot position

        }
    }
    public void right(){
        //swap the tile with the one below it, if y < the current board - 1
        if(y < currentBoard.length - 1){
            currentBoard[x][y] = currentBoard[x][y + 1];
            currentBoard[x][y + 1] = BLANK ;
            y++;
        }
    }
    public void left(){
        //swap the tile with the one below it, if y > 0
        if(y > 0){
            currentBoard[x][y] = currentBoard[x][y - 1];
            currentBoard[x][y - 1] = BLANK ;
            y--;
        }
    }

    public char[][] getCurrentBoard() {
        //returns current board
        return currentBoard;
    }

    public char[][] getGoalBoard() {
        //returns goal board
        return goalBoard;
    }
}
