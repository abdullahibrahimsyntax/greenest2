package org.abbe.planthotel;

class Carnivore extends Plant implements PlantActions {
    final private double nutrition_per_day = 0.1 + (0.2 * getSize());

    protected Carnivore(String name, PlantType type, double initialSize) {
        super(name, type, initialSize);
    }

    @Override
    public double getNutrition() {
        return nutrition_per_day;
    }
    @Override
    public Nutrient getNutrient() {
        return this.nutrient;
    }

    @Override
    public String getName() {
        return this.name;
    }

}

