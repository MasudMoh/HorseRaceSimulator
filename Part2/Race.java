import java.util.concurrent.TimeUnit;
import java.lang.Math;

/**
 * A three-horse race, each horse running in its own lane
 * for a given distance
 * 
 * @author McRaceface , Masud Mohamoud
 * @version 3.0
 */
public class Race
{
    private int raceLength;
    private int numberOfLanes;
    private int numberOfHorses = 3;
    private String trackShape;
    private String weatherCondition;

    private Horse lane1Horse;
    private Horse lane2Horse;
    private Horse lane3Horse;

    /**
     * Constructor for objects of class Race
     * Initially there are no horses in the lanes
     * 
     * @param distance the length of the racetrack (in metres/yards...)
     */
    public Race(int distance, int lanes, String selectedShape, String selectedWeather)
    {
        // initialise instance variables
        raceLength = distance;
        numberOfLanes = lanes;

        trackShape = selectedShape;
        weatherCondition = selectedWeather;

        //for (int i=0; i< lanes; i++){
         Horse Horse1 = new Horse('♘',"PIPPI LONGSTOCKING",0.4);
         Horse Horse2 = new Horse('♞',"KOKOMO",0.5);
         Horse Horse3 = new Horse('♘',"EL JEFE",0.5);
        //}

         lane1Horse = Horse1;
         lane2Horse = Horse2;
         lane3Horse = Horse3;

         if (weatherCondition.equals("Icy")){
            lane1Horse.setConfidence(lane1Horse.getConfidence()+0.2);
            lane2Horse.setConfidence(lane2Horse.getConfidence()+0.2);
            lane3Horse.setConfidence(lane3Horse.getConfidence()+0.2);
         }
         else if (weatherCondition.equals("Muddy")){
             lane1Horse.setConfidence(lane1Horse.getConfidence()-0.2);
             lane2Horse.setConfidence(lane2Horse.getConfidence()-0.2);
             lane3Horse.setConfidence(lane3Horse.getConfidence()-0.2);
         }
    }

    /**
     * Adds a horse to the race in a given lane
     * 
     * @param theHorse the horse to be added to the race
     * @param laneNumber the lane that the horse will be added to
     */
    public void addHorse(Horse theHorse, int laneNumber)
    {
        if (laneNumber == 1)
        {
            lane1Horse = theHorse;
        }
        else if (laneNumber == 2)
        {
            lane2Horse = theHorse;
        }
        else if (laneNumber == 3)
        {
            lane3Horse = theHorse;
        }
        else
        {
            System.out.println("Cannot add horse to lane " + laneNumber + " because there is no such lane");
        }
    }
    
    /**
     * Start the race
     * The horse are brought to the start and
     * then repeatedly moved forward until the 
     * race is finished
     */
    public void startRace()
    {
        //declare a local variable to tell us when the race is finished
        boolean finished = false;
        
        //reset all the lanes (all horses not fallen and back to 0). 
        lane1Horse.goBackToStart();
        lane2Horse.goBackToStart();
        lane3Horse.goBackToStart();
                      
        while (!finished)
        {
            //move each horse
            moveHorse(lane1Horse);
            moveHorse(lane2Horse);
            moveHorse(lane3Horse);
                        
            //print the race positions
            printRace();
            
            //if any of the three horses has won, the race is finished.
            if ( raceWonBy(lane1Horse) || raceWonBy(lane2Horse) || raceWonBy(lane3Horse) )
            {
                finished = true;
            }
            //if all horses have fallen than the race will end.
            if (lane1Horse.hasFallen() && lane2Horse.hasFallen() && lane3Horse.hasFallen() ){
                finished = true;
                System.out.println("All Horses have fallen so, no one wins!!");

            }
           
            //wait for 100 milliseconds
            try{ 
                TimeUnit.MILLISECONDS.sleep(100);
            }catch(Exception e){}
        }
    }
    
    /**
     * Randomly make a horse move forward or fall depending
     * on its confidence rating
     * A fallen horse cannot move
     * 
     * @param theHorse the horse to be moved
     */
    private void moveHorse(Horse theHorse)
    {
        //if the horse has fallen it cannot move, 
        //so only run if it has not fallen
        if  (!theHorse.hasFallen())
        {
            //the probability that the horse will move forward depends on the confidence;
            if (Math.random() < theHorse.getConfidence())
            {
               theHorse.moveForward();
            }
            
            //the probability that the horse will fall is very small (max is 0.1)
            //but will also will depends exponentially on confidence,
            //so if you double the confidence, the probability that it will fall is *. 2
            if (Math.random() < (0.1*theHorse.getConfidence()*theHorse.getConfidence()))
            {
                theHorse.fall();
                theHorse.setConfidence(theHorse.getConfidence()-0.1);
            }
        }
    }
        
    /** 
     * Determines if a horse has won the race
     *
     * @param theHorse The horse we are testing
     * @return true if the horse has won, false otherwise.
     */
    private boolean raceWonBy(Horse theHorse)
    {
        if (theHorse.getDistanceTravelled() == raceLength)
        {
            System.out.println("And the winner is... "+ theHorse.getName() + "!");
            theHorse.setConfidence(theHorse.getConfidence()+0.1);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /***
     * Print the race on the terminal
     */
    private void printRace()
    {
        System.out.print('\u000C');  //clear the terminal window
        
        multiplePrint('=',raceLength+3); //top edge of track
        System.out.println();

        // Contains all the horses to be printed in their lanes.
        //Horse[] horseArray = new Horse[numberOfHorses];
        Horse[] horseArray = {lane1Horse,lane2Horse,lane3Horse};


        //for (int i=0; i< horseArray.length; i++){

        //}

        for (int i=0; i<numberOfLanes; i++) {
            if (i<horseArray.length) {
                printLane(horseArray[i]);
                System.out.println();
            }
            else{
                printLane();
                System.out.println();
            }
        }
        multiplePrint('=', raceLength + 3); //bottom edge of track

        System.out.println();
    }
    
    /**
     * print a horse's lane during the race,
     * for example
     * |           X                      |
     * to show how far the horse has run
     */
    private void printLane(Horse theHorse)
    {
        //calculate how many spaces are needed before
        //and after the horse
        int spacesBefore = theHorse.getDistanceTravelled();
        int spacesAfter = raceLength - theHorse.getDistanceTravelled();

        //print a | for the beginning of the lane
        System.out.print('|');
        
        //print the spaces before the horse
        multiplePrint(' ',spacesBefore);
        
        /*
        if the horse has fallen, then print dead.
        else print the horse's symbol
        */
        if(theHorse.hasFallen())
        {
            System.out.print('❌');
        }
        else
        {
            System.out.print(theHorse.getSymbol());
        }
        if (theHorse.hasFallen()){
            multiplePrint(' ',spacesAfter-1);
        }
        else {//print the spaces after the horse
            multiplePrint(' ', spacesAfter);
        }
        
        //print the | for the end of the track
        System.out.print('|');
    }

    private void printLane()
    {
        //calculate how many spaces are needed before
        //and after the horse
        int spacesBefore = raceLength+1;

        //print a | for the beginning of the lane
        System.out.print('|');

        //print the spaces before the horse
        multiplePrint(' ',spacesBefore);


        //print the | for the end of the track
        System.out.print('|');
    }

        
    
    /***
     * print a character a given number of times.
     * e.g. printmany('x',5) will print: xxxxx
     * 
     * @param aChar the character to Print
     */
    private void multiplePrint(char aChar, int times)
    {
        int i = 0;
        while (i < times)
        {
            System.out.print(aChar);
            i = i + 1;
        }
    }
}
