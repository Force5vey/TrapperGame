package models;

public class Player
{
    // Default Values
    private final int INITIAL_HEALTH = 100, INITIAL_FOOD = 2, INITIAL_WATER = 6, INITIAL_AMMO = 5;
    private final int GAME_MAXIMUM_HEALTH = 200, GAME_MAXIMUM_FOOD = 6, GAME_MAXIMUM_WATER = 18, GAME_MAXIMUM_AMMO = 15;

    private final int FOOD_PER_200_METERS = 1, WATER_PER_100_METERS = 1;

    private final Location DEFAULT_LOCATION = Location.Home;

    // Class attributes
    private int currentHealth, maxHealth;
    private int currentFood, maxFood;
    private int currentWater, maxWater;
    private int currentAmmo, maxAmmo;
    private Location currentLocation;
    private Location destination;

    private boolean isAlive = true;

    // Properties
    public int RestDuration = 5;
    public int ProcessDuration = 5;
    public int TrapDestinationIndex = 0;
    public int TraveledDistance = 0;
    public int TotalTravelDistance = 0;

    public static enum Location {
        Home, BlackRiverBend, WhisperingStone, RavenFelds, Traveling
    }

    // Plater Status
    int metersTraveledFromHome;
    private boolean hasAnimal;
    private Animal currentAnimal;

    // Constructor
    public Player()
    {
        this.currentLocation = DEFAULT_LOCATION;
        currentHealth = INITIAL_HEALTH;
        maxHealth = INITIAL_HEALTH;
        currentFood = INITIAL_FOOD;
        maxFood = INITIAL_FOOD;
        currentWater = INITIAL_WATER;
        maxWater = INITIAL_WATER;
        currentAmmo = INITIAL_AMMO;
        maxAmmo = INITIAL_AMMO;

        this.hasAnimal = false;
        this.currentAnimal = new Animal(Animal.AnimalType.None, false);
    }

    /*
     * ============ PLAYER ACTIONS ===============
     */

    public void SetTotalTravelDistance(int distanceFromHome)
    {
        this.TotalTravelDistance = distanceFromHome;
    }

    public Animal GetCurrentAnimal()
    {
        return this.currentAnimal;
    }

    public void SetHasAnimal(boolean hasAnimal)
    {
        this.hasAnimal = hasAnimal;
    }

    public boolean GetHasAnimal()
    {
        return this.hasAnimal;
    }

    public void PickUpAnimal(Animal animal)
    {
        this.currentAnimal = animal;
        this.hasAnimal = true;
    }

    public void DropAnimal()
    {
        this.currentAnimal = null;
        this.hasAnimal = false;
    }

    public void ProcessAnimal()
    {
        IncreaseCapacity(this.currentAnimal);
        this.currentAnimal = null;
        this.hasAnimal = false;
    }

    public void Walk(int meters)
    {
        for (int i = 1; i <= meters; i++)
        {
            if (i % 100 == 0)
            {
                this.SubtractWater(WATER_PER_100_METERS);
            }

            if (i % 200 == 0)
            {
                this.SubtractFood(FOOD_PER_200_METERS);
            }

            this.metersTraveledFromHome += i;
        }
    }

    public void Rest()
    {
        AddHealth(20);
        AddFood(1);
        AddWater(1);
        AddAmmo(1);
    }

    public void Attack(Animal animal)
    {

    }

    public void Flee()
    {

    }

    public void CollectResource(Resource resource)
    {

    }

    public void CheckTrap(Trap trap)
    {

    }

    public void ReturnHome()
    {

    }

    public void IncreaseCapacity(Animal animal)
    {
        int maxIncrease = (int) (animal.GetMaxLife() * .5);
        int newMaxHealth = this.maxHealth + maxIncrease;

        UpdateMaxHealth(newMaxHealth);

    }

    /*
     * ============ LOCATION ===============
     */

    public void SetCurrentLocation(Location currentLocation)
    {
        this.currentLocation = currentLocation;
    }

    public void SetDestination(Location destination)
    {
        this.destination = destination;
    }

    public Location GetCurrentLocation()
    {
        return this.currentLocation;
    }

    public Location GetDestination()
    {
        return this.destination;
    }

    /*
     * ============ PLAYER LIFE ===============
     */

    public void SetPlayerLife(boolean isAlive)
    {
        this.isAlive = isAlive;
    }

    public boolean GetPlayerLife()
    {
        return this.isAlive;
    }

    /*
     * ============ HEALTH ===============
     */

    public void UpdateMaxHealth(int newMaxHealth)
    {
        this.maxHealth = newMaxHealth;

        if (maxHealth > GAME_MAXIMUM_HEALTH)
        {
            this.maxHealth = GAME_MAXIMUM_HEALTH;
        }

    }

    public int GetMaxHealth()
    {
        return this.maxHealth;
    }

    public void AddHealth(int amountToAdd)
    {
        this.currentHealth += amountToAdd;

        if (this.currentHealth > maxHealth)
        {
            this.currentHealth = maxHealth;
        }
    }

    public int SubtractHealth(int amountToSubtract)
    {

        this.currentHealth -= amountToSubtract;

        if (this.currentHealth <= 0)
        {
            this.currentHealth = 0;
            isAlive = false;
        }

        return this.currentHealth;
    }

    public int GetCurrentHealth()
    {
        return this.currentHealth;
    }

    /*
     * ============ FOOD =================
     */

    public void UpdateMaxFood(int newMaxFood)
    {
        this.maxFood = newMaxFood;

        if (this.maxFood > GAME_MAXIMUM_FOOD)
        {
            this.maxFood = GAME_MAXIMUM_FOOD;
        }
    }

    public int GetMaxFood()
    {
        return this.maxFood;
    }

    public void AddFood(int amountToAdd)
    {
        this.currentFood += amountToAdd;

        if (this.currentFood > maxFood)
        {
            this.currentFood = maxFood;
        }
    }

    public void SubtractFood(int amountToSubtract)
    {
        this.currentFood -= amountToSubtract;

        if (this.currentFood < 0)
        {
            this.currentFood = 0;
        }
    }

    public int GetCurrentFood()
    {
        return this.currentFood;
    }

    /*
     * ============ WATER =================
     */

    public void UpdateMaxWater(int newMaxWater)
    {
        if (newMaxWater > GAME_MAXIMUM_WATER)
        {
            this.maxWater = GAME_MAXIMUM_WATER;
        } else
        {
            this.maxWater = newMaxWater;
        }
    }

    public int GetMaxWater()
    {
        return this.maxWater;
    }

    public void AddWater(int amountToAdd)
    {
        this.currentWater += amountToAdd;
        if (this.currentWater > maxWater)
        {
            this.currentWater = maxWater;
        }
    }

    public void SubtractWater(int amountToSubtract)
    {
        this.currentWater -= amountToSubtract;

        if (this.currentWater == 0)
        {
            this.currentWater = 0;
        }
    }

    public int GetCurrentWater()
    {
        return this.currentWater;
    }

    /*
     * ============ AMMO =================
     */

    public void UpdateMaxAmmo(int newMaxAmmo)
    {
        if (newMaxAmmo > GAME_MAXIMUM_AMMO)
        {
            this.maxAmmo = GAME_MAXIMUM_AMMO;
        } else
        {
            this.maxAmmo = newMaxAmmo;
        }
    }

    public int GetMaxAmmo()
    {
        return this.maxAmmo;
    }

    public void AddAmmo(int amountToAdd)
    {
        this.currentAmmo += amountToAdd;
        if (this.currentAmmo > maxAmmo)
        {
            this.currentAmmo = maxAmmo;
        }
    }

    public void SubtractAmmo(int amountToSubtract)
    {
        this.currentAmmo -= amountToSubtract;

        if (this.currentAmmo < 0)
        {
            this.currentAmmo = 0;
        }
    }

    public int GetCurrentAmmo()
    {
        return this.currentAmmo;
    }

}
