package uk.co.tuffdev.dp.bridge;

interface Colour {
    String fill();
}

class Blue implements Colour {
    @Override
    public String fill() {
        return "Colour is blue";
    }
}

abstract class Shape {
    protected Colour colour;

    public Shape(Colour colour) {
        this.colour = colour;
    }

    abstract String draw();
}

class Square extends Shape {
    public Square(Colour colour) {
        super(colour);
    }

    @Override
    String draw() {
        return "Square drawn. " + colour.fill();
    }
}

public class BridgePattern {
    public static void main(String[] args) {
        Shape blueSquare =
                new Square(new Blue());
        System.out.println(blueSquare.draw());
    }
}
