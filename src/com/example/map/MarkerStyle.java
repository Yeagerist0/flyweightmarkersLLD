package com.example.map;

/**
 * Flyweight — intrinsic (shared, immutable) state.
 *
 * All fields are final; there are no setters.
 * Instances are obtained exclusively through MarkerStyleFactory,
 * so identical configurations always reuse the same object.
 */
public class MarkerStyle {

    private final String shape;   // e.g., PIN, CIRCLE, SQUARE
    private final String color;   // e.g., RED, BLUE, GREEN
    private final int    size;    // e.g., 10..16
    private final boolean filled; // filled vs outline

    /** Package-private: only the factory should call this. */
    MarkerStyle(String shape, String color, int size, boolean filled) {
        this.shape  = shape;
        this.color  = color;
        this.size   = size;
        this.filled = filled;
    }

    public String  getShape()  { return shape;  }
    public String  getColor()  { return color;  }
    public int     getSize()   { return size;   }
    public boolean isFilled()  { return filled; }

    @Override
    public String toString() {
        return shape + "|" + color + "|" + size + "|" + (filled ? "F" : "O");
    }
}
