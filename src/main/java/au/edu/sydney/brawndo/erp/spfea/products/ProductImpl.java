package au.edu.sydney.brawndo.erp.spfea.products;

import au.edu.sydney.brawndo.erp.ordering.Product;

import java.util.Arrays;

// Made final to conform to value object pattern
public final class ProductImpl implements Product {
    /*
     This is the client part of the flyweight design pattern.

     Assumes a 1-1 correspondence between the tuple/key (name, cost) -> (manufacturingData, recipeData, marketingData,
     safetyData, licensingData). That is, every method here is an intrinsic method because all the data can be shared
     & the (name cost) determines if an instance is unique or not (see: ProductFactory).

     In the value-object pattern note that this class is final and immutable (there are no setters.) Furthermore,
     it implements its own equivalence.
     */

    final Product productProps;

    public ProductImpl(String name,
                       double cost,
                       double[] manufacturingData,
                       double[] recipeData,
                       double[] marketingData,
                       double[] safetyData,
                       double[] licensingData) {

        ProductFactory pFactory = new ProductFactory();
        this.productProps = pFactory.getFlyweight(name,
                cost,
                manufacturingData,
                recipeData,
                marketingData,
                safetyData,
                licensingData);
    }

    // Value object pattern
    @Override
    public boolean equals(Object cmp) {
        /*
         Value object pattern.
         */

        // Cast object to pattern variable & ensure instance is matched
        if(!(cmp instanceof ProductImpl castedCmp)) {
            return false;
        }

        // Equivalence iff all fields are equal
        return getProductName().equals(castedCmp.getProductName()) &&
                getCost() == castedCmp.getCost() &&
                Arrays.equals(getManufacturingData(), castedCmp.getManufacturingData()) &&
                Arrays.equals(getRecipeData(), castedCmp.getRecipeData()) &&
                Arrays.equals(getMarketingData(), castedCmp.getMarketingData()) &&
                Arrays.equals(getSafetyData(), castedCmp.getSafetyData()) &&
                Arrays.equals(getLicensingData(), castedCmp.getLicensingData());
    }

    @Override
    public String getProductName() {
        return productProps.getProductName();
    }

    @Override
    public double getCost() {
        return productProps.getCost();
    }

    @Override
    public double[] getManufacturingData() {
        return productProps.getManufacturingData();
    }

    @Override
    public double[] getRecipeData() {
        return productProps.getRecipeData();
    }

    @Override
    public double[] getMarketingData() {
        return productProps.getMarketingData();
    }

    @Override
    public double[] getSafetyData() {
        return productProps.getSafetyData();
    }

    @Override
    public double[] getLicensingData() {
        return productProps.getLicensingData();
    }

    @Override
    public String toString() {

        return String.format("%s", productProps.getProductName());
    }
}
