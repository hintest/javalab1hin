
public class Truck extends Vehicle {

	
	
    public void turnRight(int degrees) {
		if (degrees <= 360) {
		  	direction += degrees; 
		  	if (direction > 360) direction -= 360;	
	}
//
    }
	public void turnLeft(int degrees) {
	 	if (degrees <= 360) {
		  	direction -= degrees; 
		  	if (direction < 0) direction += 360;	
		}
	}
	public void drive() {
		System.out.println("Truck drive method");
	}
	public void accelerate(int factor){
		if(speed==0) speed= 0.5 * factor; 
		else speed *= factor;
	}
}
