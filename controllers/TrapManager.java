package controllers;

import models.Trap;
import models.Location;

public class TrapManager
{

    private Trap[] traps;

    public TrapManager()
    {
        initializeTraps();
    }

    private void initializeTraps()
    {
        traps = new Trap[3];
        traps[0] = new Trap(Location.BlackRiverBend);
        traps[1] = new Trap(Location.RavenFelds);
        traps[2] = new Trap(Location.WhisperingStone);
    }

    public Trap[] getAllTraps()
    {
        return traps;
    }

    public Trap getTrapByIndex(int index)
    {
        return index >= 0 && index < traps.length ? traps[index] : null;
    }

    public Trap getTrapByLocation(Location location)
    {
        for (Trap trap : traps)
        {
            if (trap.getTrapLocation() == location)
            {
                return trap;
            }
        }
        return null;
    }
}
