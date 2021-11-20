package Week11;

public class TokenPass {
    private int[] tokens;
    private int currentPlayer;
    public TokenPass(int playerCount){
        tokens = new int[playerCount];
        currentPlayer = (int) (Math.random()*playerCount);
        for(int i = 0; i < tokens.length; i++){
            tokens[i] = (int) (Math.random()*10)+1;
        }
    }
    public void distributeCurrentPlayerToken(){
        int tokensLeft = tokens[currentPlayer];
        tokens[currentPlayer] = 0;

        int player = currentPlayer+1;
        while(tokensLeft>0){
            if(player==tokens.length){
                player = 0;
            }
            tokens[player]++;
            tokensLeft--;
        }
    }
}
