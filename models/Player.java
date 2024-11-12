package models;

public class Player {

    private final int INITIAL_HEALTH = 100, INITIAL_FOOD = 2, INITIAL_WATER = 6, INITIAL_AMMO = 5;
    private final int GAME_MAXIMUM_HEALTH = 200, GAME_MAXIMUM_FOOD = 6, GAME_MAXIMUM_WATER = 18, GAME_MAXIMUM_AMMO = 15;

    private int currentHealth, maxHealth;
    private int currentFood, maxFood;
    private int currentWater, maxWater;
    private int currentAmmo, maxAmmo;

    private boolean isAlive = true;
    private boolean hasAnimal = false;
    private int processDuration = 5;

    private Location currentLocation = Location.Home;  // Player starts at Home

    public Player() {
        this.currentHealth = INITIAL_HEALTH;
        this.maxHealth = INITIAL_HEALTH;
        this.currentFood = INITIAL_FOOD;
        this.maxFood = GAME_MAXIMUM_FOOD;
        this.currentWater = INITIAL_WATER;
        this.maxWater = GAME_MAXIMUM_WATER;
        this.currentAmmo = INITIAL_AMMO;
        this.maxAmmo = GAME_MAXIMUM_AMMO;
    }

    // Getter and Setter Methods
    public boolean getHasAnimal() {
        return hasAnimal;
    }

    public int getProcessDuration() {
        return processDuration;
    }

    public void setHasAnimal(boolean hasAnimal) {
        this.hasAnimal = hasAnimal;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location location) {
        this.currentLocation = location;
    }

    public void rest() {
        currentHealth = Math.min(maxHealth, currentHealth + 20);
        currentFood = Math.min(maxFood, currentFood + 1);
        currentWater = Math.min(maxWater, currentWater + 2);
        System.out.println("Player rested. Health, food, and water replenished.");
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentFood() {
        return currentFood;
    }

    public int getMaxFood() {
        return maxFood;
    }

    public int getCurrentWater() {
        return currentWater;
    }

    public int getMaxWater() {
        return maxWater;
    }

    public int getCurrentAmmo() {
        return currentAmmo;
    }

    public int getMaxAmmo() {
        return maxAmmo;
    }
}

