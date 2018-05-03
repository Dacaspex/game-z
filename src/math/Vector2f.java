package math;

public class Vector2f {

    public float x;
    public float y;

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2f(double angle) {
        this.x = (float) Math.cos(angle);
        this.y = (float) Math.sin(angle);
    }

    public Vector2f sub(Vector2f vector) {
        return new Vector2f(
                x - vector.x,
                y - vector.y
        );
    }

    public Vector2f subi(Vector2f vector) {
        this.x -= vector.x;
        this.y -= vector.y;

        return this;
    }

    public Vector2f add(Vector2f vector) {
        return new Vector2f(
                x + vector.x,
                y + vector.y
        );
    }

    public Vector2f addi(Vector2f vector) {
        this.x += vector.x;
        this.y += vector.y;

        return this;
    }

    public Vector2f multiply(float value) {
        return new Vector2f(
                x * value,
                y * value
        );
    }

    public Vector2f multiply(double value) {
        return multiply((float) value);
    }

    public Vector2f multiplyi(float value) {
        this.x *= value;
        this.y *= value;

        return this;
    }

    public double getLength() {
        return Math.sqrt(x * x + y * y);
    }

    public double getDistanceTo(Vector2f vector) {
        return this.sub(vector).getLength();
    }

    public Vector2f normalize() {
        float length = (float) getLength();

        return new Vector2f(
                x / length,
                y / length
        );
    }

    public Vector2f normalizei() {
        float length = (float) getLength();
        x /= length;
        y /= length;

        return this;
    }

    public float dot(Vector2f vector) {
        return this.x * vector.x + this.y * vector.y;
    }

    public double getAngle() {
        Vector2f xAxis = new Vector2f(1, 0);

        return Math.acos((this.dot(xAxis)) / (this.getLength()));
    }

    public Vector2f copy() {
        return new Vector2f(x, y);
    }

    @Override
    public String toString() {
        return "Vector2f: " + x + ", " + y;
    }
}
