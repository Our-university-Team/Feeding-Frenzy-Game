package sample;

public class original_fish extends fish implements Enemies{

    private static  double mouthoffset_x ;// Values to be added to mouth_x if the fish is in right position
    private static  double mouthoffset_y;//Values to be added to mouth_y to know mouth location


//default constructor
    public original_fish() {
        //default values
        setSize(6);
        original_fish.mouthoffset_x=80;
        original_fish.mouthoffset_y=25;
        setAlive(true);
        setDirection(0);//  original_fish.main_fish_direction=0; //defalt left direction
    }
//argument constructor
    public original_fish(double x, double y, double mouthx, double mouthy, boolean alive,int direction,int size) {
        super(x, y, mouthx, mouthy, alive,direction,size);
    }
///copy constructor
    public original_fish(fish f) {
        super(f);
    }

    public static double getMouthoffset_x() {
        return mouthoffset_x;
    }

    public static void setMouthoffset_x(double mouthoffset_x) {
        original_fish.mouthoffset_x = mouthoffset_x;
    }

    public static double getMouthoffset_y() {
        return mouthoffset_y;
    }

    public static void setMouthoffset_y(double mouthoffset_y) {
        original_fish.mouthoffset_y = mouthoffset_y;
    }

    public boolean Is_in_rangeX(fish f) {
      return false;}

    public boolean Is_inRangeY_axis(fish f) {
        return false;}

    public  boolean compareSize(fish f)
      {
        return false;
      }

    public double getWidth()
    {
        return original_fish.getMouthoffset_x();
    }
    public double getHeight()
    {
        return original_fish.getMouthoffset_y() *2;
    }

}
