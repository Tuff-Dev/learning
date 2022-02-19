package uk.co.tuffdev.dp.adapter;

interface Movable {
    // Get speed in MPH
    double getSpeed();
}

class AstonMartin implements Movable {
    @Override
    public double getSpeed() {
        return 225;
    }
}

interface MovableAdapter {
    double getSpeed();
}

class MovableAdapterImpl implements MovableAdapter {
    private Movable car;

    public MovableAdapterImpl(Movable car) {
        this.car = car;
    }

    @Override
    public double getSpeed() {
        return convertMPHtiKPH(car.getSpeed());
    }

    private double convertMPHtiKPH(double mph) {
        return mph * 1.60934;
    }
}

public class AdapterExample {

    public static void main(String[] args) {
        Movable aston = new AstonMartin();
        MovableAdapter astonAdapter = new MovableAdapterImpl(aston);

        System.out.println(astonAdapter.getSpeed());
    }
}
