package org.abbe.planthotel;

class Cactus extends Plant implements PlantActions {
    final private double nutrition_per_day = 0.2; // Cactus only needs a fixed volume of nutrition

    // initialSize is set by Overloeded constructor in Plant type
    protected Cactus(String name, PlantType type) {
        super(name, type);
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
