import java.awt.*;

public class Score {
	private String playerId;
	private int score = 0;

	public Score(String playerId){
		this.playerId = playerId;
	}

	public void draw(){

		if (playerId == "Player 1"){
			GameLib.setColor(Color.GREEN);
			GameLib.drawText(playerId + ": " + score, 70, GameLib.ALIGN_LEFT);
		}
		if (playerId == "Player 2"){
			GameLib.setColor(Color.BLUE);
			GameLib.drawText(playerId + ": " + score, 70, GameLib.ALIGN_RIGHT);
		} 			
	}

	public void inc(){
		this.score++;		
	}

	public int getScore(){
		return this.score;
	}
}