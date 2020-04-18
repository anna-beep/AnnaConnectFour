public class Board {
    String[][] grid = new String[8][8];

    public Board() {
        for(int row = 0; row < 8; row++) {
            for(int col = 0; col <8; col++) {
                grid[row][col] = "_";
            }
        }
    }

    public void printBoard() {
        System.out.println("New board:");
        for(int row = 0; row < 8; row++) {
            for(int col = 0; col < 8; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.print("\n"); // why add this part?
        }
    }

    //makes a move on the board - changes a position to "token value"
    public void makeMove(int col, String token) {
        for(int i = 7; i>=0;i--) {
            if (grid[i][col].equals("_")) {
                grid[i][col] = token;
                break;
            }
        }
    }

    public boolean colHasSpace(int col){
        if(grid[0][col].equals("_")){
            return true;
        }
        return false;
    }
    //win check routine with basic "algorithm" for now
    //any move at 0,0 ends game
    //why? what does this function mean/ what does it do?
    public boolean checkWin(String token) {
        if(grid[0][0] != "_") {
            return true;
        }
        return false;
    }
    public boolean checkWins(String token) {

        boolean v = checkWinV(token);
        boolean h = checkWinH(token);
        return v || h;
    }

    public boolean checkWinV(String token){
        for(int col=0; col<8; col++){
            for(int row =0; row<5; row++){
                if(grid[row][col].equals(token)&&
                grid[row+1][col].equals(token)&&
                grid[row+2][col].equals(token)&&
                grid[row+3][col].equals(token)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkWinH(String token){
        for(int col = 0; col<8; col++){
            for(int row =0; row<5; row++){
                if(grid[row][col].equals(token)&&
                        grid[row+1][col].equals(token)&&
                        grid[row+2][col].equals(token)&&
                        grid[row+3][col].equals(token)){
                    return true;
                }
            }
        }
        return false;
    }


    //how to find out who went last and their token
    //how to find where token was just last placed and then find its row and its array and search
    //through those to find if "win"
   /* public boolean determineWin(String token){
        int count = 0;
        for(int i=0; i<7; i++){
            for(int a=0; a<4; i++){
                if(grid[i][a].equals(token)){
                    count+=1;
                    if(count >= 4){
                        return true;
                    }
                }else{
                    count=0;
                }
            }
        }
        return false;
    } // find a way to get this to return outside of if statements
*/
    /* not sure where the code below goes...
    if(hasNextInt()){
        int move = sc.nextInt0;
        if(move>0 && move<8){
            //? dunno what goes here
        }
    }
    */

}
