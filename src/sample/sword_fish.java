package sample;

public final class sword_fish extends fish implements Enemies{

    private  static final double mouthoffset_x =200;//// Values to be added to mouth_x if the fish is in right position
    private  static final double mouthoffset_y=50;//Values to be added to mouth_y to know mouth location


    //Default constructor
    public sword_fish() {
        setSize(12);
        setAlive(true);
    }
    //Argument constructor
    public sword_fish(double x, double y, double mouthx, double mouthy, boolean alive,int direction,int size) {
        super(x, y, mouthx, mouthy, alive,direction,size);
    }
    //copy constructor
    public sword_fish(fish f) {
        super(f);
    }

    public  static  double getMouthoffset_x() {
        return mouthoffset_x;
    }

    public  static double getMouthoffset_y() {
        return mouthoffset_y;
    }

    public double getWidth( )
    {
        return getMouthoffset_x();
    }

    public  double getHeight()
    {
        return getMouthoffset_y()*2;
    }

    public boolean Is_in_rangeX(fish f)
    {
        if(f instanceof original_fish )
        {
            if(f.getMouth_x() - this.getMouth_x() <23.5 && f.getMouth_x() - this.getMouth_x() >-23.5)
                return true;
        }
        return false;
    }
    public boolean Is_inRangeY_axis(fish f)
    {
        if(f instanceof original_fish )
        {
            if(f.getMouth_y() - this.getMouth_y() <53 && f.getMouth_y() - this.getMouth_y() >-53)
                return true;
        }
        return false;
    }

    public  boolean compareSize(fish f)
    {
        if(f instanceof original_fish)
        {
            if(f.getSize() >= this.getSize())
                return true;
        }
        return false;

    }
}
