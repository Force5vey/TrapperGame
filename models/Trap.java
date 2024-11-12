package models;

public class Trap
{
    private final int DISTANCE_BLACK = 1500, DISTANCE_WHISPERING = 1000, DISTANCE_RAVEN = 600;

    private Player.Location trapLocation;
    private int distanceFromHome;
    public int TrapsIndex;

    //
    // Constructor
    public Trap(Player.Location trapLocation)
    {
        this.trapLocation = trapLocation;
        SetDistanceFromHome(this.trapLocation);
    }

    //
    // Methods
    private void SetDistanceFromHome(Player.Location trapLocation)
    {
        int distance;
        switch (trapLocation) {
        case BlackRiverBend -> distance = DISTANCE_BLACK;
        case WhisperingStone -> distance = DISTANCE_WHISPERING;
        case RavenFelds -> distance = DISTANCE_RAVEN;
        default -> distance = 0;
        }

        this.distanceFromHome = distance;
    }

    public int GetDistanceFromHome()
    {
        return this.distanceFromHome;
    }

    public Player.Location GetTrapLocation()
    {
        return this.trapLocation;
    }

    public String GetTrapName()
    {
        String trapName;
        switch (this.trapLocation) {
        case BlackRiverBend -> trapName = "Black River Bend";
        case RavenFelds -> trapName = "RavenFelds";
        case WhisperingStone -> trapName = "Whispering Stone";
        default -> trapName = "None";
        }

        return trapName;
    }

}
