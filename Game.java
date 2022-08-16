public class Game {

    //prints board
     char[][] board = {
            {' ','|',' ','|',' '},
            {'-','+','-','+','-'},
            {' ','|',' ','|',' '},
            {'-','+','-','+','-'},
            {' ','|',' ','|',' '},
    };

    //Array to keep track of the positions
    private final char [] placements = {' ',' ',' ',' ',' ',' ',' ',' ',' '};


    //Function that prints the board
    public void printBoard(){
        int count = 0;
        for ( char[] row : this.board){
            for(char col : row){
                if (col == ' '){
                    System.out.print(this.placements[count]);
                    count++;
                } else{
                    System.out.print(col);
                }
            }
            System.out.println();
        }
    }

    //Function that shows all the options
    public void showOptions(){
        int count = 1;
        for(char[]row : this.board){
            for(char col : row){
                if (col == ' '){
                    System.out.print(count);
                    count++;
                } else{
                    System.out.print(col);
                }
            }
            System.out.println();
        }
    }





}





