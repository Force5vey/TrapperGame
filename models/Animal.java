package models;

import utils.*;
import controllers.*;

public class Animal
{
    private final int RABBIT_LIFE = 10, BEAVER_LIFE = 15, DEER_LIFE = 20;
    private final int BADGER_LIFE = 40, COUGAR_LIFE = 60, BEAR_LIFE = 80;

    private final int RABBIT_MAX_ATTACK = 1, BEAVER_MAX_ATTACK = 2, DEER_MAX_ATTACK = 5;
    private final int BADGER_MAX_ATTACK = 10, COUGAR_MAX_ATTACK = 20, BEAR_MAX_ATTACK = 40;

    public enum AnimalType {
        Rabbit, Beaver, Deer, Badger, Cougar, Bear, None
    }

    private AnimalType animalType;
    private int currentLife, maxLife;
    private int maxAttackDamage;

    boolean isHostile;
    boolean isAlive;

    public Animal(AnimalType animalType, boolean isAlive)
    {
        this.animalType = animalType;
        this.isAlive = isAlive;

        isHostile = IsAnimalHostile(this.animalType);

        this.maxLife = SetInitialLife(this.animalType);
        this.currentLife = SetInitialLife(this.animalType);

        maxAttackDamage = SetAttackDamage(this.animalType);
    }

    public int GetMaxAttackDamage()
    {
        return this.maxAttackDamage;
    }

    public Animal.AnimalType GetAnimalType()
    {
        return this.animalType;
    }

    private int SetAttackDamage(AnimalType animalType)
    {
        int attackDamage = 0;

        switch (animalType) {
        case Rabbit -> attackDamage = RABBIT_MAX_ATTACK;
        case Beaver -> attackDamage = BEAVER_MAX_ATTACK;
        case Deer -> attackDamage = DEER_MAX_ATTACK;
        case Badger -> attackDamage = BADGER_MAX_ATTACK;
        case Cougar -> attackDamage = COUGAR_MAX_ATTACK;
        case Bear -> attackDamage = BEAR_MAX_ATTACK;
        case None -> attackDamage = 0;
        }

        return attackDamage;

    }

    private int SetInitialLife(AnimalType animalType)
    {
        int totalLife;
        switch (animalType) {
        case Rabbit -> totalLife = RABBIT_LIFE;
        case Beaver -> totalLife = BEAVER_LIFE;
        case Deer -> totalLife = DEER_LIFE;
        case Badger -> totalLife = BADGER_LIFE;
        case Cougar -> totalLife = COUGAR_LIFE;
        case Bear -> totalLife = BEAR_LIFE;
        default -> totalLife = 50;
        }

        return totalLife;
    }

    public boolean IsAnimalHostile(AnimalType animalType)
    {
        boolean isAnimalHostile;
        switch (animalType) {
        case Rabbit:
        case Beaver:
        case Deer:
            isAnimalHostile = false;
        case Badger:
        case Cougar:
        case Bear:
            isAnimalHostile = true;
        default:
            isAnimalHostile = false;
        }

        return isAnimalHostile;
    }

    public String GetAnimalImage()
    {
        String animalImage;

        switch (this.animalType) {
        case Rabbit -> animalImage = GetRabbitImage();
        case Beaver -> animalImage = GetBeaverImage();
        case Deer -> animalImage = GetDeerImage();
        case Badger -> animalImage = GetBadgerImage();
        case Cougar -> animalImage = GetCougarImage();
        case Bear -> animalImage = GetBearImage();
        default -> animalImage = "&&&";
        }

        return animalImage;
    }

    public boolean ReceiveDamage(int damageAmount)
    {
        currentLife -= damageAmount;

        if (currentLife <= 0)
        {
            this.isAlive = false;
        }

        return isAlive;
    }

    public int GetDamageLevel()
    {
        return this.maxAttackDamage;
    }

    public int GetMaxLife()
    {
        return this.maxLife;
    }

    public int GetCurrentLife()
    {
        return this.currentLife;
    }

    public String GetAnimalName()
    {
        String name;

        switch (this.animalType) {
        case Rabbit -> name = "Jack Rabbit";
        case Beaver -> name = "Beaver";
        case Deer -> name = "White Tail Deer";
        case Badger -> name = "Honey Badger";
        case Cougar -> name = "Couagar";
        case Bear -> name = "Grizzly Bear";
        default -> name = "Unknown";
        }

        return name;
    }

    public String GetRabbitImage()
    {
        String image = """
                 ^   ^
                / - - \\
                 """;

        return image;
    }

    public String GetBeaverImage()
    {
        String image = """
                Beaver
                """;
        return image;
    }

    public String GetDeerImage()
    {
        String image = """
                White Tail Deer
                 """;
        return image;
    }

    public String GetBadgerImage()
    {
        String image = """
                Honey Badger
                """;

        return image;
    }

    public String GetCougarImage()
    {
        String image = """
                Cougar
                """;
        return image;
    }

    public String GetBearImage()
    {
        String image = """
                Grizzly Bear
                """;
        return image;
    }

}
