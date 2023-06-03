package au.edu.sydney.brawndo.erp.spfea.products;

import au.edu.sydney.brawndo.erp.ordering.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ProductFactory {
    /*
     This is the factory part of the flyweight pattern.

     The factory hashes the name and cost & tries to find
     it in the pool. If it already exists, return a reference to the added object. O.T.W, add it to the pool
     & return its reference. This way, if there are k unique items in the instantiations (k unique (name, cost) tuples)
     & n items in total then we need to only store k instances and n pointers to instances.
     */

    private final Map<Integer, Product> flyweights = new HashMap<>();

    public Product getFlyweight(String name,
                                double cost,
                                double[] manufacturingData,
                                double[] recipeData,
                                double[] marketingData,
                                double[] safetyData,
                                double[] licensingData) {

        int key = Objects.hash(name, cost);
        Product flyweight = flyweights.get(key);

        if (flyweight == null) {
            flyweight = new ProductProperties(name,
                    cost,
                    manufacturingData,
                    recipeData,
                    marketingData,
                    safetyData,
                    licensingData);
            flyweights.put(key, flyweight);
        }
        return flyweight;
    }
}

