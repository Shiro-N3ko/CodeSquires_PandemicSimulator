/**
 * Program Name: Person.java
 * Purpose: This Code is the Base Class that Holds all the information of a single Person
 * @author: Ryan Squire, Noor Alnajar, Eric Edkins, Shayne Ruttan -> Code Squires
 * Date: Jul. 15, 2022
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * @author Ryan
 *
 */
public class Person {
    public Person(int immStatus_)
    {
	//This will need to be validated Elsewhere
	//Constructor To Send User Input To Edit Probability
	this.immunityStatus = immStatus_;
	this.xCord = (int)Math.random() * (SimulationRunner.WIDTH - 1 + 1) + 1;
	this.yCord = (int)Math.random() * (SimulationRunner.HEIGHT - 1 + 1) + 1;
	if(this.immunityStatus == 1)
	{
	    //No Shots
	    this.theColour = Color.BLUE;
	}//end if
	else if (this.immunityStatus == 2) 
	{
	    //1 Shot
	    this.theColour = new Color(0,200,200);
	}//end elseif
	else if (this.immunityStatus == 3) 
	{
	    //twoShot
	   this.theColour = Color.YELLOW;
	}//end elseif
	else if (this.immunityStatus == 4) 
	{
	    //threeShot
	    this.theColour = new Color(255,255,0); 
	}//end elseif
	else if (this.immunityStatus == 5) 
	{
	    //Already Had Infections 
	    this.theColour = Color.GREEN;
	}//end elseif
    }//end constructor
    
    //This Constructed is used to create an Infected Person Manually(Say For the start of a game)
    public Person(Boolean infection_)
    {
	this.xCord = (int)Math.random() * (SimulationRunner.WIDTH - 1 + 1) + 1;
	this.yCord = (int)Math.random() * (SimulationRunner.HEIGHT - 1 + 1) + 1;
	
	this.isInfected = infection_;
	//infectedColour 
	this.theColour = Color.RED;
	
	
    }//end constructor
    private Boolean isAlive = true; //Status Of Life
    private Boolean isInfected = false; //Status Of Infection
    public void SetInfectionStatus(Boolean status_)
    {
	this.isInfected = status_;
    }//end set
    public Boolean GetInfectionStatus()
    {
	return this.isInfected;
    }//end get
    public void SetLifeStatus(Boolean status_)
    {
	this.isAlive = status_;
    }//end set
    public Boolean GetLifeStatus()
    {
	return this.isAlive;
    }//end get
    private int immunityStatus;
    public int GetImmunityStatus()
    {
	return this.immunityStatus;
    }//end get
    public void SetImmunityStatus(int status_)
    {
	this.immunityStatus = status_;
    }//end set
    private Color theColour; //The Colour of the Circle
    /*
     * Blue->Nothing
     * Cyan->1Shot
     * Yellow->2Shot
     * Magenta->3Shot
     * Green->Cured
     * Red->Infected 
     * Black->Dead  
     */
    public void SetColour(Color aColour_)
    {
	this.theColour = aColour_;
    }//end set
    private int xCord, yCord; //Set This Randomly Within Bounds Of the JPanel 
    public int GetXCord()
    {
	return this.xCord;
    }//end get
    public int GetYCord()
    {
	return this.yCord;
    }//end get
    private int xIncValue, yIncValue; //How Much To Move Each Person
    public void SetXIncValue(int xVal_)
    {
	this.xIncValue = xVal_;
    }//set
    public void SetYIncValue(int yVal_)
    {
	this.yIncValue = yVal_;
    }//set
    private int cycleCounter = 0; //Tracks How Many Cycles Something Lived
    public int getCycleCounter()
    {
	return this.cycleCounter;
    }//end get
    public int SetCycleCounter(int cycleCounter_)
    {
	return this.cycleCounter = cycleCounter_;
    }//end get
}//End class
