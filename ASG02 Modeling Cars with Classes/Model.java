package assignments.asg2;

import java.util.ArrayList;
import java.time.Year;
import java.util.List;

public class Model {
    private String modelName;
    private List<Year> productionYears;
    private List<String> trims;
    private boolean inProduction;

    public Model(String modelName, boolean inProduction, ArrayList<Year> productionYears) {
        if (productionYears.isEmpty()) {
            throw new IllegalArgumentException("a car model must have at least one production year");
        }

        this.modelName = modelName;
        this.inProduction = inProduction;
        this.productionYears = productionYears;
        this.trims = new ArrayList<>();
    }

    public void addTrim(String trim) {
        trims.add(trim);
    }

    public String getModelName(){
        return modelName;
    }

    public List<Year> getProductionYears() {
        return productionYears;
    }

    public List<String> getTrim() {
        return trims;
    }

    public boolean getInProduction() {
        return inProduction;
    }

    @Override
    public String toString() {
       String firstYear = productionYears.get(0).toString();
       return modelName + ", in production = " + inProduction + ", " + firstYear;
    }
}
