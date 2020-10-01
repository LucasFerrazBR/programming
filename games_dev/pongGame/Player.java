import java.awt.*;

public class Player {
	private double cx;
	private double cy;
	private double width;
	private double height;
	private Color color;
	private String id;
	private double[] v_limit;
	private double speed;

	public Player(double cx, double cy, double width, double height, Color color, String id, double [] v_limit, double speed){
		this.cx = cx;
		this.cy = cy;
		this.width = width;
		this.height = height;
		this.color = color;
		this.id = id;
		this.v_limit = v_limit;
		this.speed = speed;
	}

	public void draw(){
		GameLib.setColor(this.color);
		GameLib.fillRect(getCx(), getCy(), getWidth(), getHeight());
	}

	public void moveUp(long delta){
		if (GameLib.isKeyPressed(GameLib.KEY_A) || GameLib.isKeyPressed(GameLib.KEY_K)){
			if ((this.cy - (this.height / 2)) > v_limit[0]){ //Seta o limite que o retangulo do player tem para se movimentar
				this.cy -= delta * speed;
			}
		}
	}

	public void moveDown(long delta){
		if (GameLib.isKeyPressed(GameLib.KEY_Z) || GameLib.isKeyPressed(GameLib.KEY_M)){
			if ((this.cy + (this.height / 2)) < v_limit[1]){ //Seta o limite que o retangulo do player tem para se movimentar
				this.cy += delta * speed;
			}
		}
	}

//GETTERS
	public String getId() { 
		return this.id; 
	}

	public double getWidth() { 
		return this.width; 
	}

	public double getHeight() { 
		return this.height;
	}

	public double getCx() { 		
		return this.cx;
	}

	public double getCy() { 	
		return this.cy;
	}
}