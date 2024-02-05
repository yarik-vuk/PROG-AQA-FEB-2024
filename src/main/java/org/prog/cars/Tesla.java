package org.prog.cars;

public class Tesla implements ICar {
    @Override
    public void goTo() {
        System.out.println("Tesla uses electricity");
    }
}
