
/**
 * Write a description of class Horse here.
 * 
 * @author Masud Mohamoud
 * @version 1
 */
public class Horse
{
    //Fields of class Horse
    /**
     * Set fields to private for encapsulation
     */

    private final String name;
    private char Symbol;
    private int distanceTravelled;
    private boolean fallStatus;
    private double confidence;
    
      
    //Constructor of class Horse
    /**
     * Constructor for objects of class Horse
     */
    public Horse(char horseSymbol, String horseName, double horseConfidence)
    {
       this.name = horseName;
       this.Symbol = horseSymbol;
       this.confidence = horseConfidence;
    }

    //Other methods of class Horse

    /**
     *  A method that sets the field fallStatus. Mutator method.
     */
    public void fall()
    {
        fallStatus = true;
    }

    /**
     * Returns the horses confidence rating. Accessor method.
     */
    public double getConfidence()
    {
        return confidence;
    }

    /**
     * Returns the distance travelled by the horse. Accessor method.
     */
    public int getDistanceTravelled()
    {
        return distanceTravelled;
    }

    /**
     * Returns the name of the horse name. Accessor method.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the symbol of the horse. Accessor method.
     */
    public char getSymbol()
    {
        return Symbol;
    }

    /**
     * A method that resets the field distance travelled and fallStatus.
     */
    public void goBackToStart()
    {
        distanceTravelled = 0;
        if (fallStatus){
            fallStatus= false;
        }
    }

    /**
     * Returns true if fallStatus is true;
     */
    public boolean hasFallen()
    {
        return fallStatus;
    }

    /**
     *  A method that increments the distanceTravelled field; Mutator method.
     */
    public void moveForward()
    {
        distanceTravelled++;
    }

    /**
     * Sets the horses confidence rating. Mutator method.
     */
    public void setConfidence(double newConfidence)
    {
        if (0<newConfidence && newConfidence<1) {
            confidence = newConfidence;
        }
        else {
            System.out.println("Confidence rating must be between 0 and 1");
        }
    }

    /**
     * Sets the horse's symbol. Mutator method.
     */
    public void setSymbol(char newSymbol)
    {
        Symbol = newSymbol;
    }
    
}
