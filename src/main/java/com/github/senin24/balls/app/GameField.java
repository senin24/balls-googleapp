package com.github.senin24.balls.app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameField {

    static int sizeX;
    static int sizeY;
    private volatile static Set<Ball> balls = new HashSet<>();

    public synchronized Ball getBallByNumber(int i) {
        for (Ball ball: balls){
            if (ball.getNumber() == i) return ball;
        }
        return null;
    }

    public synchronized Ball getBallByXY(int x, int y) {
        for (Ball ball: balls){
            if (ball.getPositionX() == x && ball.getPositionY() == y) return ball;
        }
        return null;
    }

    public GameField(int sizeX, int sizeY, int players) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        Ball ball;
        for (int i = 0; i < players; i++) {
            while (true) {
                int x = Utils.getRandom(sizeX);
                int y = Utils.getRandom(sizeY);
                ball = new Ball(x, y, Utils.getRandom(1, 5) * 1000, i );
                if (!(balls.contains(ball))) {
                    balls.add(ball);
                    break;
                }
            }
        }
    }

    public static synchronized void newXY(Ball ball) {
        int x = ball.getPositionX(), y = ball.getPositionY();
        int x1, y1;
        List<Location> around = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            x1 = x + i;
            //check that x1 steel exist inside field
            if (x1 < 0 || x1 >= sizeX) continue;
            for (int j = -1; j < 2; j++) {
                y1 = y + j;
                //check that y1 steel exist inside field
                if (y1 < 0 || y1 >= sizeY) continue;
                //check that x1 and y1 not equals x and y of ball
                if (y1 == y && x1 == x) continue;
                //position x1,y1 is blank ?
                if (!(balls.contains(new Ball(x1, y1)))) {
                    around.add(new Location(x1, y1));
                }
            }
        }
        int i = Utils.getRandom(around.size());
        ball.setPositionX(around.get(i).getX());
        ball.setPositionY(around.get(i).getY());
    }

    public synchronized void printField() {
        Ball ball;
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                ball = getBallByXY(x, y);
                if (ball == null) {
                    System.out.print(" . ");
                } else {
                    System.out.print(ball.getNumber() + "-" + ball.getVelocity() / 1000);
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println();
        System.out.println("----------------------");
        System.out.println();
    }
    
    public synchronized String getField() {
        Ball ball;
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                ball = getBallByXY(x, y);
                if (ball == null) {
                    sb.append(" . ");
                } else {
                	sb.append(ball.getNumber() + "-" + ball.getVelocity() / 1000);
                }
            }
            sb.append("\r\n");
        }
        
		return sb.toString();
    }

    public static class Location {
        private final int x;
        private final int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
