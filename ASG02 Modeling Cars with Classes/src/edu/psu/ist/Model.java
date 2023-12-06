package edu.psu.ist;

import java.util.ArrayList;
import java.time.Year;
import java.util.List;

/**
 * The Model class represents a car model with its name, production years, trims, and production status.
 */
public class Model {
    private final String modelName; // The name of the car model
    private final List<Year> productionYears; // List of production years for the model
    private final List<String> trims; // List of available trims for the model
    private final boolean inProduction; // Indicates whether the model is currently in production

    /**
     * Constructs a Model object with the specified parameters.
     *
     * @param modelName       The name of the car model.
     * @param inProduction    Indicates whether the model is in production (true) or not (false).
     * @param productionYears List of production years for the model.
     */
    public Model(String modelName, boolean inProduction, List<Year> productionYears) {
        if (productionYears.isEmpty()) {
            throw new IllegalArgumentException("A car model must have at least one production year");
        }

        this.modelName = modelName;
        this.inProduction = inProduction;
        this.productionYears = productionYears;
        this.trims = new ArrayList<>();
    }

    /**
     * Adds a trim option to the model.
     *
     * @param trim The trim option to add.
     */
    public void addTrim(String trim) {
        trims.add(trim);
    }

    /**
     * Gets the name of the car model.
     *
     * @return The name of the car model.
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Gets the list of production years for the model.
     *
     * @return The list of production years.
     */
    public List<Year> getProductionYears() {
        return productionYears;
    }

    /**
     * Gets the list of available trim options for the model.
     *
     * @return The list of trim options.
     */
    public List<String> getTrim() {
        return trims;
    }

    /**
     * Gets the production status of the model.
     *
     * @return True if the model is in production, false otherwise.
     */
    public boolean getInProduction() {
        return inProduction;
    }

    /**
     * Returns a string representation of the model, including its name, production status,
     * and the first production year.
     *
     * @return A formatted string representing the model.
     */
    @Override
    public String toString() {
        String firstYear = productionYears.get(0).toString();
        return modelName + ", in production = " + inProduction + ", " + firstYear;
    }
}
