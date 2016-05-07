package com.fogodev.frogger;

/**
 * Criado por ericson em 06/05/16.
 *
 * https://github.com/fogodev
 */
public class Car
{
    private double positionX;
    private double positionY;
    private double velocityX;
    private Cor color = new Cor(Math.random(), Math.random(), Math.random());
    private int weight;
    private int height = 100;
    private Hitbox hitbox;

    public Car(double positionX, double positionY, double velocityX, int weight)
    {
        this.positionX = positionX;
        this.positionY = positionY;
        this.velocityX = velocityX;
        this.weight = weight;

        this.hitbox = new Hitbox(this.positionX, this.positionY, this.positionX + this.weight, this.positionY + this.height);
    }

    public void draw(Tela canvas)
    {
        canvas.retangulo(this.positionX, this.positionY, this.weight, this.height, this.color);
    }

    public void move(double dTime)
    {
        this.positionX += this.velocityX * dTime;
        if(this.positionX >= Jogo.getLargura() + this.weight){
            this.positionX = - this.weight;
        }

        this.adjustHitbox();
    }

    public Hitbox getHitbox()
    {
        return this.hitbox;
    }

    private void adjustHitbox(){
        this.hitbox = new Hitbox(this.positionX, this.positionY, this.positionX + this.weight, this.positionY + this.height);
    }
}
