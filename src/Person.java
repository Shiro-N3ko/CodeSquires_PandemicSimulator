/**
 * Program Name: Person.java
 * Purpose: This Code is the Base Class that Holds all the information of a single Person
 * @author: Ryan Squire. -> Code Squires
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
    public Person(Boolean infection_)
    {
	this.xCord = (int)Math.random() * (SimulationRunner.WIDTH - 1 + 1) + 1;
	this.yCord = (int)Math.random() * (SimulationRunner.HEIGHT - 1 + 1) + 1;
	
	this.isInfected = infection_;
	//infectedColour 
	this.theColour = Color.RED;
	
	
    }//end constructor
    private Boolean isAlive = true;
    private Boolean isInfected = false;
    public void setInfectionStatus(Boolean status_)
    {
	this.isInfected = status_;
    }//end set
    public Boolean getInfectionStatus()
    {
	return this.isInfected;
    }//end get
    public void setLifeStatus(Boolean status_)
    {
	this.isAlive = status_;
    }//end set
    public Boolean getLifeStatus()
    {
	return this.isAlive;
    }//end get
    private int immunityStatus;
    public int getImmunityStatus()
    {
	return this.immunityStatus;
    }//end get
    public void setImmunityStatus(int status_)
    {
	this.immunityStatus = status_;
    }//end set
    private Color theColour;
    /*
     * Blue->Nothing
     * Cyan->1Shot
     * Yellow->2Shot
     * Magenta->3Shot
     * Green->Cured
     * Red->Infected 
     * Black->Dead  
     */
    public void setColour(Color aColour_)
    {
	this.theColour = aColour_;
    }//end set
    private int xCord, yCord; //Set This Randomly Within Bounds Of the JPanel
    public int getXCord()
    {
	return this.xCord;
    }//end get
    public int getYCord()
    {
	return this.yCord;
    }//end get
    private int xIncValue, yIncValue;
    public void setXIncValue(int xVal_)
    {
	this.xIncValue = xVal_;
    }//set
    public void setYIncValue(int yVal_)
    {
	this.yIncValue = yVal_;
    }//set
    private int cycleCounter = 0;
    public int getCycleCounter()
    {
	return this.cycleCounter;
    }//end get
}//End class
