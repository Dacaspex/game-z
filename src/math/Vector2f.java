package math;

public class Vector2f {

    public float x;
    public float y;

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2f sub(Vector2f vector) {
        return new Vector2f(
                x - vector.x,
                y - vector.y
        );
    }

    public Vector2f add(Vector2f vector) {
        return new Vector2f(
                x + vector.x,
                y + vector.y
        );
    }

    public Vector2f multiply(float value) {
        return new Vector2f(
                x * value,
                y * value
        );
    }

    public double getLength() {
        return Math.sqrt(x * x + y * y);
    }

    public Vector2f normalize() {
        float length = (float) getLength();

        return new Vector2f(
                x / length,
                y / length
        );
    }

    @Override
    public String toString() {
        return "Vector2f: " + x + ", " + y;
    }
}