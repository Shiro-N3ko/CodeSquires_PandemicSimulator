/**
 * Program Name: SimulationRunner.java
 * Purpose: Runs The Code, that does the calculations of the Simulation
 * @author: Ryan Squire, Noor Alnajar, Eric Edkins, Shayne Ruttan-> Code Squires
 * Date: Jul. 15, 2022
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 * @author Ryan
 *
 */
public class SimulationRunner extends JPanel{
    //Size Of Play Area
    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;
    //Gameplay Settings
    public static final int amountOfPeopleToCreate = 10; //This Should be User Input
    public static final int amountOfInfectedToCreate = 1; // This Should Be User Input
    
    //This Needs to All Be User Data --> Also Validate That All Of These Combine Are Not Greater Than 100%
    public static int amountOneShotToCreate = 0, amountTwoShotToCreate = 0, amountThreeShotToCreate = 0, amountRecoveredToCreate = 0, amountOfBasicToCreate = 0;
    //Master Container For Sim
   ArrayList<Person> simulationContainer = new ArrayList<Person>();

   //Total Stats that track the amount of each circle
public static int infectedCount = 0;
public static int infectedNoShotCount = 0, infectedOneShotCount = 0, infectedTwoShotCount = 0, infectedThreeShotCount = 0, reinfectedCount = 0, recoveredCount = 0, deathCount = 0;
public static int amountOneShot = 0, amountTwoShot = 0, amountThreeShot = 0, amountRecovered = 0, amountOfBasic = 0, amountOfInfected = 0;
//Constructor
public SimulationRunner(){
    this.setLayout(null);
	this.setBackground(Color.BLACK);
	this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
	this.setFocusable(true);
//This Loop Runs through the data that the user enters in order to create the correct amount of each type of players
	for (int i = 0; i < amountOfPeopleToCreate; i++) {
	    for (int ii = 0; ii < amountOfBasicToCreate; ii++) {
	    simulationContainer.add(new Person(1));
	    SimulationRunner.amountOfBasic++;
	    }//end for
	    for (int ii = 0; ii < amountOneShotToCreate; ii++) {
	    simulationContainer.add(new Person(2));
	    SimulationRunner.amountOneShot++;
	    }//end for
	    for (int ii = 0; ii < amountTwoShotToCreate; ii++) {
	    simulationContainer.add(new Person(3));
	    SimulationRunner.amountTwoShot++;
	    }//end for
	    for (int ii = 0; ii < amountThreeShotToCreate; ii++) {
	    simulationContainer.add(new Person(4));
	    SimulationRunner.amountThreeShot++;
	    }//end for
	    for (int ii = 0; ii < amountRecoveredToCreate; ii++) {
	    simulationContainer.add(new Person(5));
	    SimulationRunner.reinfectedCount++;
	    }//end for
	    for (int ii = 0; ii < amountOfInfectedToCreate; ii++) {
	    simulationContainer.add(new Person(true));
	    SimulationRunner.amountOfInfected++;
	    }//end for
	}//end for
}//end constructor
//Kills the player if they are infected and unlucky
public void KillPlayer(int i)
{
    	simulationContainer.get(i).SetLifeStatus(false);
	//deadColour 
	simulationContainer.get(i).SetColour(Color.BLACK); 
	simulationContainer.get(i).SetXIncValue(0);
	simulationContainer.get(i).SetYIncValue(0);
	SimulationRunner.deathCount++;
	//Case Checks The Immunity Status of the Now dead, and removes a count for each type that died
	switch (simulationContainer.get(i).GetImmunityStatus()) {
	case 1: 
	    amountOfBasic--; 
	    break;
	case 2:
	    amountOneShot--;
	    break;
	case 3:
	    amountTwoShot--;
	    break;
	case 4:
	    amountThreeShot--;
	    break;
	case 5:
	    reinfectedCount--;
	default:
	    throw new IllegalArgumentException("Unexpected value: " + simulationContainer.get(i).GetImmunityStatus());
	}//end switch
}//end Kill
//Run Simulation
public void Run()
{
    //This 4 Checks Whether A Player Should Live Or Die Based Off Their Immunity Status (Amount of shots ect)
    for (int i = 0; i < simulationContainer.size(); i++) {
	 if (simulationContainer.get(i).getCycleCounter() == 150 && simulationContainer.get(i).GetInfectionStatus() == true) {
		    //Runs Check On Infected Person to determine their fate
	     		int simRNG = (int)(Math.random() * 100 + 1) - 1;
		    if (simRNG == 1 || simRNG == 4 || simRNG == 3 && simulationContainer.get(i).GetImmunityStatus() == 5 || simulationContainer.get(i).GetImmunityStatus() == 3 )
		    {
			KillPlayer(i);
		    }//end if
		    else if (simRNG == 42 && simulationContainer.get(i).GetImmunityStatus() == 4)
		    {
			KillPlayer(i);
		    }//end else if
		    else if (simRNG >= 3 && simRNG <= 9 && simulationContainer.get(i).GetImmunityStatus() == 2)
		    {
			KillPlayer(i);
		    }//end else if
		    else if (simRNG >= 10 && simRNG <= 20 && simulationContainer.get(i).GetImmunityStatus() == 1)
		    {
			KillPlayer(i);
		    }//end else if
		    else //The Person Survived - So Remove Their Status Counter and Set it Cured 
		    {
			switch (simulationContainer.get(i).GetImmunityStatus()) {
			case 1: 
			    amountOfBasic--;
			    break;
			case 2:
			    amountOneShot--;
			    break;
			case 3:
			    amountTwoShot--;
			    break;
			case 4:
			    amountThreeShot--;
			    break;
			case 5:
			    reinfectedCount++; //Aka Cured
			default:
			    throw new IllegalArgumentException("Unexpected value: " + simulationContainer.get(i).GetImmunityStatus());
			}//end switch
			//Recovers
			simulationContainer.get(i).SetColour(Color.GREEN);//The Bit That Acually Does The Change Mentioned Above
			simulationContainer.get(i).SetImmunityStatus(5);
			SimulationRunner.amountRecovered++;
		    }//end else  
	 }//end if
    }//end for
for (int i = 0; i < simulationContainer.size(); i++) {
    if(simulationContainer.get(i).GetLifeStatus() == false)
    {
	simulationContainer.remove(i); //Checks if player is dead and deletes them from remaining calculations if so
    }//end if
}//end for
   
}//end run
}//End class
