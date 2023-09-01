package sample;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.util.Duration; 
import java.io.FileInputStream;

public class Main extends Application {


                    //Delay function//
    public static void delay(long delayMs, Runnable toRun){
        Thread t = new Thread(new Runnable(){
            public void run(){
                try { Thread.sleep(delayMs); }catch(InterruptedException ignored){}
                Platform.runLater(toRun);
            }
        });
        t.setDaemon(true);
        t.start();
    }

                 //General Curve Method//
    public void GeneralCurveFish_path(ImageView i,int x,int y, int x1, int y1,int x2 , int y2 , int x3,int y3,int time,int delay)
    {
        Path path = new Path();
        MoveTo moveto= new MoveTo(x,y); //
        CubicCurveTo cubiccurve= new CubicCurveTo(x1,y1,x2,y2,x3,y3);

        path.getElements().add(moveto);
        path.getElements().add(cubiccurve);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(time)); //time of movement
        pathTransition.setDelay(Duration.millis(delay));
        pathTransition.setPath(path);

        pathTransition.setNode(i);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(Timeline.INDEFINITE);

        pathTransition.play();
    }

                 //The Rotation of images//
    public void Rotate(ImageView i )
    {

        i.setRotationAxis(Rotate.Y_AXIS);
        i.setRotate(180);

    }

                //Start Image buttons Settings//
    public void StartImage_buttons(Button Start_btn ,Button Exit_btn,Button Exit_btn1,Button  Restart_btn)
{
    Start_btn.setLayoutX(800);
    Start_btn.setLayoutY(500);
    Start_btn.setStyle("-fx-font: 30 arial; -fx-base: #ee2211;"); //fx-font for font name
    Start_btn.setPrefSize(250,75);             //fx-base changes button colour

    Exit_btn.setLayoutX(800);
    Exit_btn.setLayoutY(620);
    Exit_btn.setStyle("-fx-font: 30 arial; -fx-base: #ee2211;");
    Exit_btn.setPrefSize(250,75);

    Exit_btn1.setLayoutX(1600);
    Exit_btn1.setLayoutY(100);
    Exit_btn1.setStyle("-fx-font: 30 arial; -fx-base: #ee2211;");
    Exit_btn1.setPrefSize(250,75);

    Restart_btn.setLayoutX(70);
    Restart_btn.setLayoutY(100);
    Restart_btn.setStyle("-fx-font: 30 arial; -fx-base: #ee2211;");
    Restart_btn.setPrefSize(250,75);
}

                //Updating Fish x and y and mouthx and mouth y values(Fish pos update) ..//
      public void FishPosition_update(fish[]Fish_Array, ImageView[]Images_Array)
{


    for(int i=0 ;i<12 ; i++)
    {
        if(Fish_Array[i].isAlive())//Is alive
        {
            Fish_Array[i].setX(Images_Array[i].getTranslateX() + Images_Array[i].getX());
            Fish_Array[i].setY(Images_Array[i].getTranslateY() + Images_Array[i].getY());
        }
        if(Fish_Array[i].isAlive() && Fish_Array[i].getDirection()==0)
        {
            Fish_Array[i].setMouth_x(Fish_Array[i].getX() ); //Mouth x same for fish in left position
        }
    }
    //Fish in right position Mouth x is different

    if(Fish_Array[0].isAlive() && Fish_Array[0].getDirection()==1) { //Nemo right

        Fish_Array[0].setMouth_x( Fish_Array[0].getX() + ((nemo_fish) Fish_Array[0]).getMouthoffset_x());
        Fish_Array[0].setMouth_y(Fish_Array[0].getY() + ((nemo_fish) Fish_Array[0]).getMouthoffset_y());
    }
    if(Fish_Array[1].isAlive())  //Nemo left
    {

        Fish_Array[1].setMouth_y(Fish_Array[1].getY() +((nemo_fish) Fish_Array[1]).getMouthoffset_y());
    }
    if(Fish_Array[2].isAlive() && Fish_Array[2].getDirection()==1) //Right Yellow fish
    {
        Fish_Array[2].setMouth_x(Fish_Array[2].getX() + ((yellow_fish) Fish_Array[2]).getMouthoffset_x());
        Fish_Array[2].setMouth_y(Fish_Array[2].getY() + ((yellow_fish) Fish_Array[2]).getMouthoffset_y());
    }

    if(Fish_Array[3].isAlive())  //yellow fish left
    {

        Fish_Array[3].setMouth_y(Fish_Array[3].getY() +((yellow_fish) Fish_Array[3]).getMouthoffset_y());
    }

    if(Fish_Array[4].isAlive() && Fish_Array[4].getDirection()==1) //pink right fish
    {
        Fish_Array[4].setMouth_x(Fish_Array[4].getX() + ((pink_fish) Fish_Array[4]).getMouthoffset_x());
        Fish_Array[4].setMouth_y(Fish_Array[4].getY() + ((pink_fish) Fish_Array[4]).getMouthoffset_y());
    }

    if(Fish_Array[5].isAlive())  //pink fish left
    {

        Fish_Array[5].setMouth_y(Fish_Array[5].getY() +((pink_fish) Fish_Array[5]).getMouthoffset_y());
    }

    if(Fish_Array[6].isAlive() && Fish_Array[6].getDirection()==1) //sword right fish
    {
        Fish_Array[6].setMouth_x(Fish_Array[6].getX() + ((sword_fish) Fish_Array[6]).getMouthoffset_x());
        Fish_Array[6].setMouth_y(Fish_Array[6].getY() + ((sword_fish) Fish_Array[6]).getMouthoffset_y());
    }

    if(Fish_Array[7].isAlive() && Fish_Array[7].getDirection()==1) //sword right fish
    {
        Fish_Array[7].setMouth_x(Fish_Array[7].getX() + ((sword_fish) Fish_Array[7]).getMouthoffset_x());
        Fish_Array[7].setMouth_y(Fish_Array[7].getY() + ((sword_fish) Fish_Array[7]).getMouthoffset_y());
    }

    if(Fish_Array[8].isAlive())  //Sword fish left
    {

        Fish_Array[8].setMouth_y(Fish_Array[8].getY() +((sword_fish) Fish_Array[8]).getMouthoffset_y());
    }

    if(Fish_Array[9].isAlive())  //Sword fish left
    {

        Fish_Array[9].setMouth_y(Fish_Array[9].getY() +((sword_fish) Fish_Array[9]).getMouthoffset_y());
    }


    if(Fish_Array[10].isAlive() && Fish_Array[10].getDirection()==1) //Huge right fish
    {
        Fish_Array[10].setMouth_x(Fish_Array[10].getX() + ((huge_fish) Fish_Array[10]).getMouthoffset_x());
        Fish_Array[10].setMouth_y(Fish_Array[10].getY() + ((huge_fish) Fish_Array[10]).getMouthoffset_y());
    }

    if(Fish_Array[11].isAlive())  //Huge fish left
    {

        Fish_Array[11].setMouth_y(Fish_Array[11].getY() +((huge_fish) Fish_Array[11]).getMouthoffset_y());
    }

}
                 //Fish Array constructors
     public void ArrayofFish_constructors(fish[] Fish_Array)
      {
          for(int i=0;i<2;i++)
          {
              Fish_Array[i]=new nemo_fish();
          }

          for(int i=2;i<4;i++)
          {
              Fish_Array[i]=new yellow_fish();

          }

          for(int i=4;i<6;i++)
          {
              Fish_Array[i]=new pink_fish();
          }

          for(int i=6;i<10;i++)
          {
              Fish_Array[i]=new sword_fish();
          }

          for(int i=10;i<12;i++)
          {
              Fish_Array[i]=new huge_fish();
          }
      }

                 //Array of image veiws constructor//
    public void ArrayofImageView_constructors(ImageView[] Images_Array, ImageView nemo_image, ImageView nemo1_image,ImageView yellow_r_image,
                                              ImageView yellow_r1_image, ImageView pink_r_image , ImageView pink_r1_image, ImageView sword_r_image,
                                              ImageView sword_r1_image,ImageView sword_r2_image, ImageView sword_r3_image,ImageView huge_image, ImageView huge1_image )
    {
        Images_Array[0]=nemo_image;
        Images_Array[1]= nemo1_image;

        Images_Array[2]=yellow_r_image;
        Images_Array[3]=yellow_r1_image;

        Images_Array[4]=pink_r_image;
        Images_Array[5]=pink_r1_image;

        Images_Array[6]=sword_r_image;
        Images_Array[7]=sword_r1_image;
        Images_Array[8]=sword_r2_image;
        Images_Array[9]=sword_r3_image;

        Images_Array[10]=huge_image;
        Images_Array[11]=huge1_image;
    }

                //Default enemy fish Directions//
    public void SetEnemyFish_directions(fish [] Fish_Array)
    {
        Fish_Array[4].setDirection(1); //right direction
        Fish_Array[5].setDirection(0); //left direction
        Fish_Array[0].setDirection(1); //right direction
        Fish_Array[1].setDirection(0); //left direction
        Fish_Array[2].setDirection(1); //right direction
        Fish_Array[3].setDirection(0); //left direction
        Fish_Array[6].setDirection(1); //right direction
        Fish_Array[7].setDirection(1); //right direction
        Fish_Array[8].setDirection(0); //left direction
        Fish_Array[9].setDirection(0); //left direction
        Fish_Array[10].setDirection(1); //right direction
        Fish_Array[11].setDirection(0); //left direction
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        //////////////////////////Fish Array///////////////////////////

                //Main fish Started in left postion//
        original_fish Main_fish= new original_fish();
        Main_fish.setX((Screen.getPrimary().getVisualBounds().getWidth()) /2);  //at the centre
        Main_fish.setY((Screen.getPrimary().getVisualBounds().getHeight()) /2);
        Main_fish.setMouth_x(Main_fish.getX()); //Started in left position so its x position is its mouth_x position
        Main_fish.setMouth_y( (Main_fish.getY()) +(original_fish.getMouthoffset_y())) ;

        //Array of fish//
        fish []Fish_Array = new fish[12];
        ArrayofFish_constructors(Fish_Array);

        ////////////////////////IMAGES//////////////////////////////

        //start image
        FileInputStream input = new FileInputStream("images/13.jpeg");
        ImageView Start_image = new ImageView(new Image(input));
        Start_image.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());   //full screen
        Start_image.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());

         //Game Start image
         input = new FileInputStream("Images/12.jpg");
        ImageView Game_image = new ImageView(new Image(input));
        Game_image.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());   //full screen
        Game_image.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());

        //Game over Image
        input= new FileInputStream("Images/15.jpg");
        ImageView GameOver_image = new ImageView(new Image(input));
        GameOver_image.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());   //full screen
        GameOver_image.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());

        //Winner Image
        input= new FileInputStream("Images/28.png");
        ImageView Winner_image = new ImageView(new Image(input));
        Winner_image.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());   //full screen
        Winner_image.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());

        //Original fish image ( closed mouth)
         input = new FileInputStream("Images/4 .png");
        ImageView Original_cm_image = new ImageView(new Image(input));
        Original_cm_image.setFitWidth(Main_fish.getWidth());
        Original_cm_image.setFitHeight(Main_fish.getHeight());
        Original_cm_image.setX(Main_fish.getX());
        Original_cm_image.setY(Main_fish.getY());

        //original fish image  (open mouth)
         input = new FileInputStream("Images/6.png");
        ImageView Original_om_image = new ImageView(new Image(input));
        Original_om_image.setFitWidth(80);
        Original_om_image.setFitHeight(50);

        //pink fish right
         input = new FileInputStream("Images/2.png");
         Image image7= new Image(input);
        ImageView pink_r_image = new ImageView(image7);
        pink_r_image.setFitWidth(50);
        pink_r_image.setFitHeight(50);
        pink_r_image.setX(-400);  //Initial position to be out of the screen

        //pink fish Right 1
        ImageView pink_r1_image = new ImageView(image7);
        pink_r1_image.setFitWidth(50);
        pink_r1_image.setFitHeight(50);
        pink_r1_image.setX(-400);  //Initial position to be out of the screen

        //nemo fish right
        input = new FileInputStream("Images/9.png");
        Image image1 = new Image(input);
        ImageView nemo_image = new ImageView(image1);
        nemo_image.setFitWidth(50);
        nemo_image.setFitHeight(50);
        nemo_image.setX(-400);  //Initial position to be out of the screen

       // nemo fish right(2)
        ImageView nemo1_image = new ImageView(image1);
        nemo1_image.setFitWidth(50);
        nemo1_image.setFitHeight(50);
        nemo1_image.setX(-400);  //Initial position to be out of the screen

        //yellow fish right
         input = new FileInputStream("Images/10.png");
         Image image5= new Image(input);
        ImageView yellow_r_image = new ImageView(image5);
        yellow_r_image.setFitWidth(50);
        yellow_r_image.setFitHeight(50);
        yellow_r_image.setX(-400);  //Initial position to be out of the screen

        //yellow fish Right(1)
        ImageView yellow_r1_image = new ImageView(image5);
        yellow_r1_image.setFitWidth(50);
        yellow_r1_image.setFitHeight(50);
        yellow_r1_image.setX(-400);  //Initial position to be out of the screen

        //sword fish right
        input = new FileInputStream("Images/8.png");
        Image image2 = new Image(input);
        ImageView sword_r_image = new ImageView(image2);
        sword_r_image.setFitWidth(200);
        sword_r_image.setFitHeight(100);
        sword_r_image.setX(-400);  //Initial position to be out of the screen

       //sword fish right(1)
        ImageView sword_r1_image = new ImageView(image2);
        sword_r1_image.setFitWidth(200);
        sword_r1_image.setFitHeight(100);
        sword_r1_image.setX(-400);  //Initial position to be out of the screen

        //sword fish Right(2)
        ImageView sword_r2_image = new ImageView(image2);
        sword_r2_image.setFitWidth(200);
        sword_r2_image.setFitHeight(100);
        sword_r2_image.setX(-400);  //Initial position to be out of the screen

        //sword fish Right(3)
        ImageView sword_r3_image = new ImageView(image2);
        sword_r3_image.setFitWidth(200);
        sword_r3_image.setFitHeight(100);
        sword_r3_image.setX(-400);  //Initial position to be out of the screen

        //huge fish Right
         input = new FileInputStream("Images/14.png");
        Image image4= new Image(input);
        ImageView huge_image = new ImageView(image4);
        huge_image.setFitWidth(400);
        huge_image.setFitHeight(150);
        huge_image.setX(-400);  //Initial position to be out of the screen

        //huge fish Right(2)
        ImageView huge1_image = new ImageView(image4);
        huge1_image.setFitWidth(400);
        huge1_image.setFitHeight(150);
        huge1_image.setX(-400); //Initial position to be out of the screen

        //Growth Bar Images
        input=new FileInputStream("Images/17.png");
        Image image10=new Image(input);
        ImageView arrow=new ImageView(image10);
        arrow.setFitWidth(30);
        arrow.setFitHeight(30);
        arrow.setX(115);
        arrow.setY(85);

        //Growth Bar Images
        ImageView arrow1=new ImageView(image10);
        arrow1.setFitWidth(30);
        arrow1.setFitHeight(30);
        arrow1.setX(235);
        arrow1.setY(85);

        //Growth Bar Images
        input=new FileInputStream("Images/9.png");
        Image image11=new Image(input);
        ImageView nemoIcon=new ImageView(image11);
        nemoIcon.setFitWidth(30);
        nemoIcon.setFitHeight(30);
        nemoIcon.setX(50);
        nemoIcon.setY(40);

        //Growth Bar Images
        input=new FileInputStream("Images/2.png");
        Image image12=new Image(input);
        ImageView pinkIcon=new ImageView(image12);
        pinkIcon.setFitWidth(30);
        pinkIcon.setFitHeight(30);
        pinkIcon.setX(80);
        pinkIcon.setY(40);

        //Growth Bar Images
        input=new FileInputStream("Images/10.png");
        Image image13=new Image(input);
        ImageView yellowIcon=new ImageView(image13);
        yellowIcon.setFitWidth(30);
        yellowIcon.setFitHeight(30);
        yellowIcon.setX(100);
        yellowIcon.setY(40);

        //Growth Bar Images
        input=new FileInputStream("Images/8.png");
        Image image14=new Image(input);
        ImageView swordIcon=new ImageView(image14);
        swordIcon.setFitWidth(70);
        swordIcon.setFitHeight(35);
        swordIcon.setX(160);
        swordIcon.setY(35);

        //Growth Bar Images
        input=new FileInputStream("Images/14.png");
        Image image15=new Image(input);
        ImageView hugeIcon=new ImageView(image15);
        hugeIcon.setFitWidth(70);
        hugeIcon.setFitHeight(45);
        hugeIcon.setX(300);
        hugeIcon.setY(30);

        //Setting Enemy Fish Default Directions//
        SetEnemyFish_directions(Fish_Array);

        //The Array of images Views//
        ImageView [] Images_Array=  new ImageView[12];
        ArrayofImageView_constructors(Images_Array,nemo_image,nemo1_image,yellow_r_image,yellow_r1_image,pink_r_image,pink_r1_image,sword_r_image,
                sword_r1_image,sword_r2_image,sword_r3_image,huge_image,huge1_image);

        //Start Button
        Button Start_btn =  new Button("Start");
        //Start Button
        Button Restart_btn =  new Button("Restart");
        //Exit Button
        Button Exit_btn =  new Button("Exit"); //exit button
        //Exit Button 1
        Button Exit_btn1 =  new Button("Exit"); //exit button
        //Resizing and Coloring The 2 buttons//
        StartImage_buttons(Start_btn,Exit_btn, Exit_btn1, Restart_btn);

        //Start  group
        Group Start_group = new Group();
        Start_group.getChildren().addAll(Start_image,Start_btn,Exit_btn);

        //Growth Bar(black Rectangle)
        Rectangle barFrame=new Rectangle();
        barFrame.setX(60);
        barFrame.setY(50);
        barFrame.setWidth(360);
        barFrame.setHeight(50);
        barFrame.setFill(Color.BLACK);

        //Growth Bar(Orange Rectangle)
        Rectangle orangeBar=new Rectangle();
        orangeBar.setX(70);
        orangeBar.setY(60);
        orangeBar.setWidth(0);
        orangeBar.setHeight(30);
        orangeBar.setFill(Color.ORANGERED);

        //Game group
        Group Game_group= new Group();
        Game_group.getChildren().addAll(Game_image,Original_cm_image,pink_r_image,pink_r1_image,yellow_r1_image
                ,yellow_r_image,sword_r_image,sword_r1_image,sword_r2_image,
                sword_r3_image,huge_image,huge1_image,nemo_image,nemo1_image,barFrame,orangeBar,arrow,arrow1,
                nemoIcon,pinkIcon,yellowIcon,swordIcon,hugeIcon);


        //Creating Game scene
        Scene Game_scene = new Scene(Game_group,200,200);

        //Exit the Game Event Handler(button)
        Exit_btn.setOnAction(( e) -> { //exit the game
            primaryStage.close();
        } );

        //Restart the Game Event Handler(button)
        Restart_btn.setOnAction(( e) -> { //exit the game

            //Reset The Main fish
            Main_fish.setAlive(true);
            Main_fish.setX((Screen.getPrimary().getVisualBounds().getWidth()) /2);  //at the centre
            Main_fish.setY((Screen.getPrimary().getVisualBounds().getHeight()) /2);
            Original_cm_image.setX(Main_fish.getX());
            Original_cm_image.setY(Main_fish.getY());
            original_fish.setMouthoffset_x(80);
            original_fish.setMouthoffset_y(25);
            Main_fish.setSize(6); //initial size
            Main_fish.setDirection(0);
            Original_cm_image.setRotationAxis(Rotate.Y_AXIS);
            Original_cm_image.setRotate(360);
            Original_cm_image.setFitWidth(Main_fish.getWidth());
            Original_cm_image.setFitHeight(Main_fish.getHeight());
            orangeBar.setWidth(0);

            Main_fish.setMouth_x(Main_fish.getX()); //Started in left position so its x position is its mouth_x position
            Main_fish.setMouth_y( (Main_fish.getY()) +(original_fish.getMouthoffset_y())) ;

            for (int i=0; i<12;i++) {
                if(Fish_Array[i].isAlive()==false)
                {
                    Game_group.getChildren().add(Images_Array[i]);
                    Fish_Array[i].setAlive(true);
                }
            }
            primaryStage.setScene(Game_scene);
            primaryStage.setFullScreen(true);
            primaryStage.show();

        } );

        //Exit the Game Event Handler(button) Game over button
        Exit_btn1.setOnAction(( e) -> { //exit the game
            primaryStage.close();
        } );

        //Start The Game Event handler (button)
        Start_btn.setOnAction((e) -> {

                        ///Key board Event Handler of the Main Fish movement ///
Game_scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
    @Override
    public void handle(KeyEvent event) {
        switch(event.getCode()) {

            case DOWN: {
                Original_cm_image.setY(Original_cm_image.getY() + 20);

                Main_fish.setY( Original_cm_image.getY());
                Main_fish.setMouth_y(  Original_cm_image.getY() + original_fish.getMouthoffset_y());
                break;
            }
            case UP: {
                Original_cm_image.setY(Original_cm_image.getY() - 20);
                Main_fish.setY( Original_cm_image.getY() );
                Main_fish.setMouth_y( Original_cm_image.getY() + original_fish.getMouthoffset_y());

                    break;
            }
            case LEFT: {
                if(Main_fish.getDirection()==1) { //right position
                    Original_cm_image.setRotationAxis(Rotate.Y_AXIS);
                    Original_cm_image.setRotate(360);

                }
                    Original_cm_image.setX(Original_cm_image.getX() - 20);
                    Main_fish.setMouth_x( Original_cm_image.getX());
                    Main_fish.setX( Original_cm_image.getX());
                    Main_fish.setDirection(0); //left position
                break;
            }
            case RIGHT: {
                if (Main_fish.getDirection() == 0) {
                    Rotate(Original_cm_image);

                }
                    Original_cm_image.setX(Original_cm_image.getX() + 20);
                    Main_fish.setX(  Original_cm_image.getX());
                    Main_fish.setMouth_x(  Original_cm_image.getX() + original_fish.getMouthoffset_x());
                    Main_fish.setDirection(1); //right position
                     break;
            }
        }
        FishPosition_update(Fish_Array,Images_Array); //Update enemy fish Directions

        for(int i= 0 ; i<12 ; i++)
        {
                             ////Eating Enemy fish conditions///
            if(Fish_Array[i].Is_in_rangeX(Main_fish) && Fish_Array[i].Is_inRangeY_axis(Main_fish) &&
                    Fish_Array[i].compareSize(Main_fish) && Fish_Array[i].isAlive()==true )
            {
                //Removing the fish that the original fish ate
                Game_group.getChildren().remove(Images_Array[i]);
                Fish_Array[i].setAlive(false);

                //Adjusting Original fish details
                Original_om_image.setFitHeight(Original_cm_image.getFitHeight()+ 15);
                Original_om_image.setFitWidth(Original_cm_image.getFitWidth()+ 20);
                Original_om_image.setX(Original_cm_image.getX());
                Original_om_image.setY(Original_cm_image.getY());

                Game_group.getChildren().remove(Original_cm_image);

                if(Main_fish.getDirection()==1 ) //The Main fish is in Right position
                {
                    Rotate(Original_om_image);
                    Game_group.getChildren().add(Original_om_image);
                }
                else  //The Main fish is in Left position
                {
                    Original_om_image.setRotationAxis(Rotate.Y_AXIS);
                    Original_om_image.setRotate(360);
                    Game_group.getChildren().add(Original_om_image);
                }

                delay(90, new Runnable() {
                    @Override
                    public void run() {
                        Game_group.getChildren().remove(Original_om_image);
                        Game_group.getChildren().add(Original_cm_image);
                    }
                });
                Original_cm_image.setFitWidth(Original_cm_image.getFitWidth()+ 20);
                Original_cm_image.setFitHeight(Original_cm_image.getFitHeight()+ 15);
                original_fish.setMouthoffset_x(original_fish.getMouthoffset_x() +20 );
                original_fish.setMouthoffset_y(original_fish.getMouthoffset_y() + 15/2);

                if( Fish_Array[i] instanceof nemo_fish || Fish_Array[i] instanceof yellow_fish || Fish_Array[i] instanceof pink_fish  )
                {
                    Main_fish.setSize(Main_fish.getSize()+2 );
                    orangeBar.setWidth(orangeBar.getWidth()+20);
                }
                else if(  Fish_Array[i] instanceof sword_fish )
                {
                    Main_fish.setSize(Main_fish.getSize()+3 );
                    orangeBar.setWidth(orangeBar.getWidth()+30);
                }
                else
                {
                    Main_fish.setSize(Main_fish.getSize()+5 );
                    orangeBar.setWidth(orangeBar.getWidth()+50);
                }
            }
                                   ///Game over conditions///
            else if(Fish_Array[i].Is_in_rangeX(Main_fish) && Fish_Array[i].Is_inRangeY_axis(Main_fish) &&
                Fish_Array[i].compareSize(Main_fish)==false && Fish_Array[i].isAlive()==true )
            {
                Main_fish.setAlive(false);

                Group GameOver_group= new Group();
                GameOver_group.getChildren().add(GameOver_image);
                GameOver_group.getChildren().add(Exit_btn1);
                GameOver_group.getChildren().add(Restart_btn);
                primaryStage.setScene(new Scene(GameOver_group));
                primaryStage.setFullScreen(true);
                primaryStage.show();
            }
                            ///Winning conditions///
            if(Fish_Array[10].isAlive()==false && Fish_Array[11].isAlive()==false)
            {
                Group  Winner_group= new Group();
                Winner_group.getChildren().add(Winner_image);
                Winner_group.getChildren().add(Exit_btn1);
                Winner_group.getChildren().add(Restart_btn);
                primaryStage.setScene(new Scene(Winner_group));
                primaryStage.setFullScreen(true);
                primaryStage.show();
            }
        }
    }
});
         //Flipping images (y axis)
            Rotate(pink_r1_image);
            Rotate(sword_r2_image);
            Rotate(sword_r3_image);
            Rotate(nemo1_image);
            Rotate(yellow_r1_image);
            Rotate(huge1_image);
                                        //////The Curves Path for each fish /////
            GeneralCurveFish_path(pink_r1_image,2000,800,800,700,100,1100,0,500,10000,500);
            GeneralCurveFish_path(pink_r_image,0,0,300,300,1400,150,2000,0,10000,0);
            GeneralCurveFish_path(yellow_r1_image,2000,350,800,300,0,100,0,300,10000,600);
            GeneralCurveFish_path(yellow_r_image,0,450,300,600,1400,500,2000,450,10000,0);
            GeneralCurveFish_path(nemo_image,0,350,300,500,1400,380,2000,350,10000,800);
            GeneralCurveFish_path(nemo1_image,2000,200,800,500,350,650,0,400,10000,0);
            GeneralCurveFish_path(sword_r2_image,2000,550,800,700,750,500,0,550,11500,700);
            GeneralCurveFish_path(sword_r3_image,2000,100,800,200,750,200,0,600,11500,1700);
            GeneralCurveFish_path(sword_r_image,0,250,300,400,1400,300,2000,150,11500,1000);
            GeneralCurveFish_path(sword_r1_image,0,950,300,950,1400,950,2000,950,11500,0);
            GeneralCurveFish_path(huge_image,0,700,300,850,1400,745,2000,700,12000,100);
            GeneralCurveFish_path(huge1_image,2000,350,1700,100,450,40,0,30,12000,0);

            primaryStage.setScene(Game_scene);
            primaryStage.setFullScreen(true);
            primaryStage.show();
        } );

        ///Start Scene///
        Scene Start_scene = new Scene(Start_group, 200, 100);
        primaryStage.setScene(Start_scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
