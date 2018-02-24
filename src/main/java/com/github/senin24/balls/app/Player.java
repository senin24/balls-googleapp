package com.github.senin24.balls.app;

class Player implements Runnable {
    Ball ball;

    public Player(Ball ball) {
        this.ball = ball;
    }

    @Override
    public void run() {
        while(true) {

            try {
                Thread.sleep(ball.getVelocity());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            GameField.newXY(ball);
        }

    }

}
