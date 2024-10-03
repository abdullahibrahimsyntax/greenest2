package org.abbe.planthotel;


enum PlantType {
    PALM("palm", Nutrient.TAP_WATER), CARNIVORE("carnivore", Nutrient.PROTEIN_SHAKE), CACTUS("cactus", Nutrient.MINERAL_WATER);
    private final String type;
    private final Nutrient nutrient;    // By setting the nutrient in PlantType, we can decrease
                                        // the number of parameters needed by Plant constructor.
                                        // When the PlantType is given as argument to the Plant constructor,
                                        // the nutrient for the particular PlantType can be extracted with
                                        // the getNutrient() method in this enum Type

    PlantType(String type, Nutrient nutrient) {
        this.type = type;
        this.nutrient = nutrient;
    }

    @Override
    public String toString() {
        return this.type;
    }

    protected Nutrient getNutrient() { return this.nutrient; }

}


enum Nutrient {
    TAP_WATER("tap water"), MINERAL_WATER("mineral water"), PROTEIN_SHAKE("protein shake");
    private final String type;

    Nutrient(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}


abstract class Plant {
    final protected String name;
    final protected PlantType type;
    final protected Nutrient nutrient;
    final protected double initialSize;

    // Overloaded class constructors
    // This constructor is to be used with Cactus type, since
    // Cactus type does not need initialSize to calculate its need
    // of nutritient volume
    protected Plant(String name, PlantType type) {
        this.name = name;
        this.type = type;
        this.nutrient = type.getNutrient();
        this.initialSize = 1;
    }
    // This constructor takes initialSize when the type is initialized
    // initialSize is used to calculate its need of nutrient volume.
    protected Plant(String name, PlantType type, double initialSize) {
        this.name = name;
        this.type = type;
        this.nutrient = type.getNutrient();
        this.initialSize = initialSize;
    }

    // Polymorphism (overridden method in child classes)
    //abstract public PlantType getType();
    abstract public double getNutrition();

    protected String getName() { return this.name; }
    protected double getSize() { return this.initialSize; }
    protected Nutrient getNutrient() { return this.nutrient; }
}

// Encapsulation: private fields, only public interface have access.

