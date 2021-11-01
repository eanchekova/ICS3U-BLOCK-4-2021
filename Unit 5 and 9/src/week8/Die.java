package week8; 

public class Die {
    //attributes define the state of an instance of the class at any particular time
    //private means they are only accessible (visible inside the class) 
    private int numSides;       
    private int topSide;

/**
 * consturctor
 * has the same name as the class
 * initializes the state of the class (attributes) 
 * and returns the object (although we do not say return)
 */

 /**
  * If we do not EXPLICITY create our own constructor JAVA will supply a NO 
  ARGUMENT consturcot that DOES NOT initializes the state of the class (attributes)
  */
    public Die () {
        numSides = 6; 
        topSide = (int)(Math.random() * numSides) + 1; 
    }

    public Die(int numSides) {
        this.numSides = numSides; 
        topSide = (int)(Math.random() * numSides) + 1; 
    }

    public int getTopSide() {
        return topSide;
    }

    public void roll() {
        topSide = (int)(Math.random() * numSides) + 1; 
    }

    public boolean equals(Object obj) {

        if (obj == this)
            return true; 
            
        if (obj instanceof Die){
            return this.topSide == ((Die) obj).topSide;
        } else {
            return false; 
        }

    }


}