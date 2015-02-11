

import java.util.Scanner;

/**
 * Barneklasse av Vehicle
 */
public class Bicycle extends Vehicle {
	private int gears;

	// konstruktører
	public Bicycle(){}
	public Bicycle(String name, String color, int price, int model,
			String serialNr, int gears, int direction) {
		super(name, color, price, model, serialNr, direction);
		this.gears = gears;
	}

	// get
	public int getGears() {
		return gears;
	}

	// set
	public void setGears(int gears) {
		this.gears = gears;
	}
	
    public void setAllFields() {
    	super.setAllFields();	
	    System.out.println("Antall gir: ");
	    this.gears = scan.nextInt();
    }
 
     public String toString() {
        String ret = super.toString();
        ret += "\ngir:\t\t" + gears; 
        return ret;
    }
    public void turnRight(int degrees) {
    	System.out.println("Bicycle turning right: ");
    }
    public void turnLeft(int degrees) {
    	System.out.println("Bicycle turning left: ");
    }
	public void drive() {
		System.out.println("Bicycle drive method ");
	}
	public void accelerate(int factor){
		if(speed==0) speed= 0.2 * factor; 
		else speed *= factor*0.5;
	}

}
