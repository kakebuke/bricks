package com.bricks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Ball {
	public Vector2 pos;
	private float velX;
	private float velY;
	private float stateTime;

	public Ball() {
		super();
		this.pos = new Vector2();
		this.velX = this.velY = 0;
		this.stateTime = (float)Math.random();
		this.setPos(1,1);
	}
	
	public void setPos(Vector2 pos) {
		this.pos.x = pos.x;
		this.pos.y = pos.y + 32;
	}
	
	public void setPos(int x, int y) {
		this.setPos(new Vector2(x,y));
	}
	
	public void update(float deltaTime)
	{
		this.stateTime += deltaTime;
		borderHitControl();
		pos.x = pos.x + (velX*deltaTime);
		pos.y = pos.y + (velY*deltaTime);
		
	}
	
	private void borderHitControl() {
		if (pos.x + 32 >= Gdx.graphics.getWidth() || pos.x <= 0)
		{
			this.velX *= -1;
		}
		
		if (pos.y >= Gdx.graphics.getHeight() || pos.y - 32 <= 0)
		{
			this.velY *= -1;
		}
	}

	public void setVel(Vector2 vel)
	{
		this.velX = vel.x;
		this.velY = vel.y;
		Gdx.app.log("BALL:", "new velx: "+vel.x +" new vely:" + vel.y);
	}
	
}
