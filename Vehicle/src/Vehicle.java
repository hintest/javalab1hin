

import java.util.Scanner;

/**
 * Farklasse til bil og sykkel
 */
public abstract class Vehicle implements Comparable<Vehicle>, Cloneable, Driveable  {
    private String color, name, serialNr;
    private int model, price;
    protected int direction;
    protected double speed;
    
    protected Scanner scan = new Scanner(System.in);
    
    //konstruktører
    public Vehicle() {}
    public Vehicle (String name, String color, int price, int model, String serialNr, int direction) {
        this.color = color;
        this.name = name;
        this.model = model;
        this.price = price;
        this.serialNr = serialNr;
        this.direction = direction;
    }
    
   public void setAllFields() {

      System.out.println("Navn:");
      this.name = scan.next();
      System.out.println("Farge:");
      this.color = scan.next();
      System.out.println("pris:");
      this.price = scan.nextInt();
      System.out.println("model:");
      this.model = scan.nextInt();
      System.out.println("serie nr:");
      this.serialNr = scan.next();
      this.direction=0;
    }
    
    //Get metoder
    public String getName() { return name; }
    
    //Set metoder
    public void setName(String name) { this.name = name; }
    
    @Override
    public String toString() {
        return "Navn:\t\t" + name + "\nModel:\t\t" + model + "\nSerie nummer:\t" + serialNr + "\nFarge:\t\t" + color + "\nPris:\t\t" + price 
        		+"\nHastighet:\t" + speed +"\nRetning:\t" + direction;
    }
    // compareTo based on price
    public int compareTo(Vehicle v){
    	if(price > v.price) return 1;
    	else if(price < v.price) return -1;
    	else return 0;
    }
    
    public Object clone() throws CloneNotSupportedException {
    	Vehicle vehClone = (Vehicle)super.clone();
    	vehClone.color = new String(this.color);
    	vehClone.name = new String(this.name);
    	vehClone.serialNr = new String(this.serialNr);
    	return vehClone;
    	
    }
	public void stop(){
		System.out.println( "Method stop");
		speed = 0;
	}
	public void breaks(int factor){
		System.out.println("Method breaks with factor = " + factor);
	}    
    public abstract void turnLeft(int degrees);
    public abstract void turnRight(int degrees);
    public abstract  void drive();
    public abstract  void accelerate(int factor);

}
    
