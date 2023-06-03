package au.edu.sydney.brawndo.erp.spfea;

import au.edu.sydney.brawndo.erp.auth.AuthToken;
import au.edu.sydney.brawndo.erp.database.TestDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomerValueHolder {
    /*
     Lazy load value-holder impl. for part 4.

     A singleton class which maintains an aggregate of customers & customer id's.
     Each customer & all ids are cached after being loaded dynamically once.
     */
    private static final HashMap<Integer, CustomerImpl> customers = new HashMap<>();
    private static List<Integer> ids;
    private static CustomerValueHolder instance;

    private CustomerValueHolder() {}

    public static CustomerValueHolder getInstance() {
        if(instance == null) {
            instance = new CustomerValueHolder();
        }
        return instance;
    }

    public CustomerImpl getCachedCustomers(int id, AuthToken token) {
        if(customers.isEmpty()) {
            customers.put(id, new CustomerImpl(token, id));
        }
        return customers.get(id);
    }

    public List<Integer> getCachedIds(AuthToken token) {
        if(ids == null) {
            ids = TestDatabase.getInstance().getCustomerIDs(token);
        }
        return ids;
    }
}
