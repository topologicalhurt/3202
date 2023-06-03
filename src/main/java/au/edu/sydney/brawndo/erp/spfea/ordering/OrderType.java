package au.edu.sydney.brawndo.erp.spfea.ordering;

import au.edu.sydney.brawndo.erp.ordering.Order;

public abstract class OrderType {
    protected int id;

    public OrderType(int id) {
        this.id = id;
    }
}
