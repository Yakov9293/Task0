package main.tasks.store;

import java.util.List;

public class Store {
    //public String id;
    public Host host;
    private Storage storage;
    private List workers;
    private List products;
    private List customers;

    public Store(/*String id, */Host host) {
        //this.id = id;
        this.host = host;
    }
    public void snapStorage(Storage storage){
        this.storage = storage;
    }
}
