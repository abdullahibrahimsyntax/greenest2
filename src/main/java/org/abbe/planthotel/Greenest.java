package org.abbe.planthotel;
        

import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;


// 0 Interface

public class Greenest {
    private final HashMap<String, PlantActions> myPlants = new HashMap<>();

    

    public Greenest() {
        // create list of Plant objects
        var plants = createPlantObjects();
        // By creating a list of plants first, we can use the getName method of each plant
        // So instead of the syntax HashMap<String, Plant> myPlants = Map.of("name", instance)
        // we can use HashMap<String, PlantActions> myPlants = Map.of(instance.getName(), instance)
        // thus, we don't have to hardcode name of plants in the HashMap
        for (var plant : plants) {
            myPlants.put(plant.getName(), plant);
        }
    }

    // Method to construct and return HashMap of plants
    private List<PlantActions> createPlantObjects() {
        // Create list of plants, will be used in HashMap
        return List.of(
            new Cactus("igge", PlantType.CACTUS),   // Cactus constructor is overloaded, and does not need a size since it's not needed for calculating nutrition needs
            new Palm("laura", PlantType.PALM, 5),
            new Carnivore("meatloaf", PlantType.CARNIVORE, 0.7),
            new Palm("olof", PlantType.PALM, 1)
        );
    }

    protected void run() {
        // Create a list of the names of the plants currently available in myPlants
        // So we can present the list to the hotel owner so he don't need to write
        // which plant to water, insted he can choose from available plants currently
        // at the hotel:
        Object[] current_guests = myPlants.keySet().toArray();

        // Show dialog box for the hotel owner so he can choose a plant to water
        String msg = "Choose which plant to water?";    // Shown as message on the dialog box
        String err = "No such plant at the hotel!";     // Error message to show if no plant found
        String title = "Greenest Plant Hotel";          // Shown on the title bar of dialog box
        // Create a JOptionPane tho present current guests and let him choose one
        // (we need to cast the return value from JOptionPane.showInputDialog() to String)
        String plant_name = (String) JOptionPane.showInputDialog(
            null,                               // Parent component
            msg,                                // message to show
            title,                              // Title of the dialog window
            JOptionPane.QUESTION_MESSAGE,       // Type of message to show
            null,                               // Icon
            current_guests,                     // List of guests currently at hotel
            current_guests[0]                   // Guest chosen by default
        );

        try {
            PlantActions plantToWater = myPlants.get(plant_name);
            // Build the string with instructions on how to water the chosen plant
            String nutrition = String.format(
                "%s needs %.1f litre %s per day",
                plantToWater.getName(), plantToWater.getNutrition(), plantToWater.getNutrient().toString()
            );
            // Show the string as instruction to the hotel owner
            JOptionPane.showMessageDialog(null, nutrition, "Instructions", JOptionPane.INFORMATION_MESSAGE);
        } catch (java.lang.NullPointerException e) {
            JOptionPane.showMessageDialog(null, err, title, JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String[] args) {
        Greenest hotell = new Greenest();
        hotell.run();
    }

}


