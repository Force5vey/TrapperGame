package models;

public class Trap {

    private Location trapLocation;
    private int distanceFromHome;
    private boolean isSet = false;

    public Trap(Location trapLocation) {
        this.trapLocation = trapLocation;
        this.distanceFromHome = setDistanceFromHome(trapLocation);
    }

    private int setDistanceFromHome(Location trapLocation) {
        return switch (trapLocation) {
            case BlackRiverBend -> 1500;
            case WhisperingStone -> 1000;
            case RavenFelds -> 600;
            default -> 0;
        };
    }

    public int getDistanceFromHome() {
        return distanceFromHome;
    }

    public Location getTrapLocation() {
        return trapLocation;
    }

    public String getTrapName() {
        return switch (trapLocation) {
            case BlackRiverBend -> "Black River Bend";
            case RavenFelds -> "Raven Felds";
            case WhisperingStone -> "Whispering Stone";
            default -> "Unknown Location";
        };
    }

    public boolean isSet() {
        return isSet;
    }

    public void setTrap(boolean set) {
        this.isSet = set;
    }
}

