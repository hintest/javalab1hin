

/**
 * VehicleTest oppretter Bicycle og Car objekter, legger disse i et ArrayList
 * Lar bruker manipulere data i arrayet på forskjellige måter
 * 
 *
 */

import java.util.*;
import java.io.*;

public class VehicleTest
{

  public static void main(String[] args)
  {
    VehicleTest vtest = new VehicleTest();
    try {
      vtest.menuLoop();
    }
    catch(java.io.IOException e) {
      System.out.println("IO Exception!");
      System.exit(1);
    }
    catch(CloneNotSupportedException e) {
        System.out.println("CloneNotSupportedException");
        System.exit(1);
      }
  }

  private void menuLoop()
       throws java.io.IOException, CloneNotSupportedException
  {
    Scanner scan = new Scanner(System.in);
    ArrayList<Vehicle> arr=new ArrayList<Vehicle>();
    Vehicle vehicle;

    arr.add(new Car("Volvo","Black",85000,2010,"1010-11",163,0));
    arr.add(new Bicycle("Diamant","yellow",4000,1993,"BC100",10,0));
    arr.add(new Car("Ferrari Testarossa","red",1200000,1996,"A112",350,0));
    arr.add(new Bicycle("DBS","pink",5000,1994,"42",10,0));
    Vehicle veh1 = new Car("BMW","Red",85000,2014,"1010-1101",220,180);
    //Clone method test
    Vehicle veh2 = (Vehicle)veh1.clone();
    veh2.setName("Audi");
	// Interface Driveable test
	veh1.accelerate(10);
	veh2.accelerate(10);
	veh2.accelerate(5);
	veh2.turnLeft(45);
	Vehicle veh3 = new Bicycle("Trak","Violet",8000,2015,"A1010-1101",22,0);
	veh3.accelerate(10);
	arr.add(veh1);
	arr.add(veh2);
	arr.add(veh3);

    while(true)
      {

        System.out.println("1....................................Ny bil");
        System.out.println("2.................................Ny sykkel");
        System.out.println("3........Finn og vis kjøretøy med gitt navn");
        System.out.println("4.................Vis data om alle kjøretøy");
        System.out.println("5...Endre retning på kjøretøy med gitt navn");
	    System.out.println("6...................................Avslutt");
	    System.out.println("Valg:");

    System.out.println("Hva ønsker du?");
    int choice = scan.nextInt();

    switch (choice) {

    case 1:
        //legg til en ny bil
    	vehicle = new Car();
        vehicle.setAllFields();
        arr.add(vehicle);
        break;
    case 2:
        //legg til en ny sykkel
        vehicle=new Bicycle();
        vehicle.setAllFields();
        arr.add(vehicle);
        break;
    case 3:
        //vis info om gitt kjøretøy
        System.out.println("Skriv inn navn på kjøretøy du ønsker info om: ");  
        String navn = scan.next();
        for (int i=0; i<arr.size(); i++) {
        	Vehicle veh = (Vehicle)arr.get(i);
            if(veh.getName().equals(navn))
                System.out.println(veh);
            }
            
      break;
    case 4:
        // Vis alle modellnavn, sorter først
    	// All vehicles are Comparable
    	java.util.Collections.sort(arr);
        for (int i=0; i<arr.size(); i++) { 
        	Vehicle veh = (Vehicle)arr.get(i);
            System.out.println(veh + "\n");
        }
    
        break;
    case 5:
        // Finn kjøretøy med gitt navn, sett ny pris
        System.out.println("Skriv in navn på kjøretøy: ");
        navn = scan.next();
        System.out.println("Skriv in ny retning [H/V]: ");
        String leftRight = scan.next();
        System.out.println("Antall grader [0-360]: ");
        int degrees = scan.nextInt();
        for (int i=0; i<arr.size(); i++) {
        	Vehicle veh = (Vehicle)arr.get(i);
            if (veh.getName().equalsIgnoreCase(navn)){
            	if(leftRight.charAt(0) == 'H') veh.turnRight(degrees);
            	else veh.turnLeft(degrees);
                System.out.println("Ny retning for " + veh.getName() + " er: " + veh.direction);
            }
       }
             
        break;
    case 6:
    	scan.close();
        System.exit(0);
    default:
      System.out.println("Feil inntasting!");
    }
      }
  }

}
