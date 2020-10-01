import java.awt.*;

public class Ball {
	private double cx;
	private	double cy;
	private	double width;
	private	double height;
	private Color color;
	private	double speed;
	private double direcaoX = 1; //
	private double direcaoY = 1; // Direção de movimentação da bola
	private double reset1 = 400; //
	private double reset2 = 300; // Reseta a bola a posição inicial quando um ponto é feito

	public Ball(double cx, double cy, double width, double height, Color color, double speed){
		this.cx = cx;
		this.cy = cy;
		this.width = width;
		this.height = height;
		this.color = color;
		this.speed = speed;
	}

	public void draw(){
		GameLib.setColor(color);
		GameLib.fillRect(getCx(), getCy(), this.width, this.height);
	}

	public void update(long delta){
		this.cx += (speed * delta * direcaoX); // * 0.5;
		this.cy += (speed * delta * direcaoY); // * 0.5;
	}

	public void onPlayerCollision(String playerId){
		this.direcaoY *= -1;
		this.direcaoX *= -1;
	}

	public void onWallCollision(String wallId){
		if (wallId == "Top" || wallId == "Bottom") this.direcaoY *= -1; //Muda a direção da bola ao colidir com a parede de cima ou de baixo
		if (wallId == "Left"){
			this.direcaoX *= -1;
			this.cx = reset1; //
			this.cy = reset2; //Reseta
		}
		if (wallId == "Right"){
			this.direcaoX *= -1;
			this.cx = reset1; //
			this.cy = reset2; //Reseta
		} 
	}
	
	public boolean checkCollision(Wall wall){
		if (wall.getId() == "Bottom" && getCy() >= (wall.getCy() - wall.getHeight())) return true; //Verifica se a bola atingiu os limites das paredes
		if (wall.getId() == "Top" && getCy() <= (wall.getCy() + wall.getHeight())) return true;
		if (wall.getId() == "Left" && getCx() <= (wall.getCx() + wall.getWidth())) return true;
		if (wall.getId() == "Right" && getCx() >= (wall.getCx() - wall.getWidth())) return true;
		return false;
	}

	public boolean checkCollision(Player player){
		if (getCx() < (player.getWidth() + player.getCx()) && (getCx() + this.width) > player.getCx()){
			if ((getCy() - this.height) > (player.getCy() - player.getHeight() + this.height) && (getCy() + this.height) < (player.getCy() + player.getHeight())){
				this.direcaoY *= -1;
			}
			if ((getCy() + this.height) < (player.getCy() + player.getHeight() - this.height) && (getCy() + this.height) > (player.getCy() - this.height)){
				return true;
			}
		}
		return false;
	}

//GETTERS	
	public double getCx(){
		return this.cx;
	}

	public double getCy(){
		return this.cy;
	}

	public double getSpeed(){
		return this.speed;
	}
}