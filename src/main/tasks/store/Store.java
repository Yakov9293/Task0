package main.tasks.store;

import java.util.List;

public class Store {
    public Host host;
    private Storage storage;
    private List workers;
    private List products;
    private List customers;

    public Store(Host host) {
        this.host = host;
    }
}
