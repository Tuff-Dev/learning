package uk.co.tuffdev.dp.bridge;

/**
 * Abstraction in bridge pattern
 */
abstract class Vehicle {
    protected Workshop workshop1;
    protected Workshop workshop2;

    public Vehicle(Workshop workshop1, Workshop workshop2) {
        this.workshop1 = workshop1;
        this.workshop2 = workshop2;
    }

    abstract public void manufacture();
}

/**
 * Refine abstraction 1
 */
class Car extends Vehicle {
    public Car(Workshop workshop1, Workshop workshop2) {
        super(workshop1, workshop2);
    }

    @Override
    public void manufacture() {
        System.out.println("Car ");
        workshop1.work();
        workshop2.work();
    }
}

/**
 * Refine abstraction 2
 */
class Bike extends Vehicle {
    public Bike(Workshop workshop1, Workshop workshop2) {
        super(workshop1, workshop2);
    }

    @Override
    public void manufacture() {
        System.out.println("Bike ");
        workshop1.work();
        workshop2.work();
    }
}

/**
 * Implementor for bridge pattern
 */
interface Workshop {
    abstract public void work();
}

/**
 * Concrete implementation 1
 */
class Produce implements Workshop {
    @Override
    public void work() {
        System.out.println("Produced");
    }
}

/**
 * Conrete implementation 2
 */
class Assemble implements Workshop {
    @Override
    public void work() {
        System.out.println("Assembled");
    }
}


public class BridgeExample2 {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Car(new Produce(), new Assemble());
        vehicle1.manufacture();
    }
}
