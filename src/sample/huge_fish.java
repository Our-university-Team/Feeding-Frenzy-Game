package sample;

public final class huge_fish extends fish implements Enemies{

    private  static final double mouthoffset_x =400;//// Values to be added to mouth_x if the fish is in right position
    private  static final double mouthoffset_y=75;//Values to be added to mouth_y to know mouth location

//Default constructor
    public huge_fish() {
        setSize(24);
        setAlive(true);
    }
//Argument constructor
    public huge_fish(double x, double y, double mouthx, double mouthy, boolean alive,int direction,int size) {
        super(x, y, mouthx, mouthy, alive,direction,size);
    }
//copy constructor
    public huge_fish(fish f) {
        super(f);
    }

    public  static double getMouthoffset_x() {
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
            if(f.getMouth_x() - this.getMouth_x() <32 && f.getMouth_x() - this.getMouth_x() >-32)
                return true;
        }
        return false;
    }
    public boolean Is_inRangeY_axis(fish f)
    {
        if(f instanceof original_fish )
        {
            if(f.getMouth_y() - this.getMouth_y() <54 && f.getMouth_y() - this.getMouth_y() >-54)
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
