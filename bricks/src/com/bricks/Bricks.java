package com.bricks;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Bricks implements ApplicationListener, InputProcessor {
	SpriteBatch batch;
	Ball ball;
	TextureRegion ballRegion;
	Vector2 startDrag;
	Vector2 endDrag;
	float timeDragging;
	private boolean dragged;
	
	
	@Override
	public void create() {
		Texture ballText = new Texture(Gdx.files.internal("ball_32x32.png"));
		ballRegion = new TextureRegion(ballText);
		
		Gdx.input.setInputProcessor(this);
		
		timeDragging = 0;
		
		ball = new Ball();
		batch = new SpriteBatch();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		int xVel;
		int yVel;
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);		
		batch.begin();
		batch.draw(ballRegion, ball.pos.x, Gdx.graphics.getHeight() - ball.pos.y);
		batch.end();
		
		if (dragged) {
			xVel = (int) ((endDrag.x - startDrag.x) / timeDragging);
			yVel = (int) ((endDrag.y - startDrag.y) / timeDragging);
			ball.setVel(new Vector2(xVel, yVel));
			startDrag = null;
			endDrag = null;
			dragged = false;
			timeDragging = 0;
		}
		ball.update(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean keyDown(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
//		ball.pos.x = x;
//		ball.pos.y = Gdx.graphics.getHeight() - y;
		startDrag = new Vector2(x,y);
		Gdx.app.log("touchDown", "x: " + x + " y: " + y);
		return false;
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		timeDragging += Gdx.graphics.getDeltaTime();
		endDrag = new Vector2(x,y);
		Gdx.app.log("touchDragged", "x: " + x + " y: " + y);
		return false;
	}

	@Override
	public boolean touchMoved(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		if (endDrag != null) {
			dragged = true;
		}
		else
		{
			ball.setVel(new Vector2(0,0));
		}
		
		return false;
	}

}
