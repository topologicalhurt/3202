package au.edu.sydney.brawndo.erp.spfea.products;

import au.edu.sydney.brawndo.erp.ordering.Product;

public class ProductProperties implements Product {
    /*
     This is the concrete impl. of the flyweight (ProductFlyweight) in the flyweight pattern.
    */

    private final String name;
    private final double[] manufacturingData;
    private final double cost;
    private final double[] recipeData;
    private final double[] marketingData;
    private final double[] safetyData;
    private final double[] licensingData;


    public ProductProperties(String name,
                             double cost,
                             double[] manufacturingData,
                             double[] recipeData,
                             double[] marketingData,
                             double[] safetyData,
                             double[] licensingData) {
        this.name = name;
        this.manufacturingData = manufacturingData;
        this.cost = cost;
        this.recipeData = recipeData;
        this.marketingData = marketingData;
        this.safetyData = safetyData;
        this.licensingData = licensingData;
    }

    @Override
    public String getProductName() {
        return name;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public double[] getManufacturingData() {
        return manufacturingData;
    }

    @Override
    public double[] getRecipeData() {
        return recipeData;
    }

    @Override
    public double[] getMarketingData() {
        return marketingData;
    }

    @Override
    public double[] getSafetyData() {
        return safetyData;
    }

    @Override
    public double[] getLicensingData() {
        return licensingData;
    }
}
