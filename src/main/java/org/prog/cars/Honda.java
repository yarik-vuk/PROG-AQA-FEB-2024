package org.prog.cars;

public class Honda implements ICar {
    @Override
    public void goTo() {
        System.out.println("Honda uses gas");
    }
}
