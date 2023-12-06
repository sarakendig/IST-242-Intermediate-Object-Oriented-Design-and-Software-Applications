import java.time.Year;
import java.util.List;

/**
 * The AutoModel class represents an automobile's model.
 * It stores information about the model name, production status, and production years.
 */
public class AutoModel {

    private String modelName;               // The name of the automobile's model
    private boolean inProduction;           // Indicates whether the model is currently in production.
    private List<Year> productionYears;     // A list of the years the model was in production.


    /**
     * Constructs an AutoModel object with the given parameters.
     *
     * @param modelName      The name of the automobile's model.
     * @param inProduction   Whether the model is currently in production.
     * @param productionYears A list of Year objects denoting the years the model was in production.
     * @throws IllegalArgumentException if the productionYears list is empty.
     */
    public AutoModel(String modelName, boolean inProduction, List<Year> productionYears) {
        if (productionYears.isEmpty()) {
            throw new IllegalArgumentException("Year list cannot be empty.");
        }

        this.modelName = modelName;
        this.inProduction = inProduction;
        this.productionYears = productionYears;
    }

    // gets automobile model name
    public String getModelName() {
        return modelName;
    }

    // checks if in production
    public boolean isInProduction() {
        return inProduction;
    }

    // gets list of production years
    public List<Year> getProductionYears() {
        return productionYears;
    }

    /**
     * @return a string representation of the AutoModel object.
     * The format is: "<modelName>, in production = <inProduction>, release year: <firstYear>"
     */
    @Override
    public String toString() {
        int firstYear = productionYears.get(0).getValue();
        return "<" + modelName +
                ">, in production = <" + inProduction +
                ">, release year: <" + firstYear + ">";
    }
    }

