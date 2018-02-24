package com.github.senin24.balls.app;

public class App {
	
	public static final App INSTANCE = new App();	
	private static boolean flag = false;
	private GameField gameField;

    public void start() throws InterruptedException {
    	
    	if (flag) return;

        int sizeX = 10, sizeY = 10, amount = 10;
        gameField = new GameField(sizeX, sizeY, amount);

        for (int i = 0; i < amount; i ++) {
            new Thread(new Player(gameField.getBallByNumber(i))).start();
        }
        
        flag = true;
    }
    
    public String print() {
    	return gameField.getField();    	
    }

}
