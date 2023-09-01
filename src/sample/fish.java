package sample;

public abstract class fish {

private double x;
private double y;
private double mouth_x;
private double mouth_y;
private boolean alive;
private int direction;
private int size;

    //default constructor
public  fish()
{
this.alive=true;
}

    //Argument constructor
public fish(double x , double y, double mouthx, double mouthy,boolean alive,int direction, int size)
{
    this.x=x;
    this.y=y;
    this.mouth_x=mouthx;
    this.mouth_y=mouthy;
    this.alive=alive;
    this.direction= direction;
    this.size=size;
}
//copy constructor
    public fish(fish f)
    {
        this.x=f.x;
        this.y=f.y;
        this.mouth_x=f.mouth_x;
        this.mouth_y=f.mouth_y;
        this.alive=f.alive;
        this.direction=f.direction;
        this.size=f.size;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getMouth_x() {
        return mouth_x;
    }

    public double getMouth_y() {
        return mouth_y;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setMouth_x(double mouth_x) {
        this.mouth_x = mouth_x;
    }

    public void setMouth_y(double mouth_y) {
        this.mouth_y = mouth_y;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public abstract boolean Is_in_rangeX(fish f);

    public abstract boolean Is_inRangeY_axis(fish f);

    public abstract boolean compareSize(fish f);


}
