package by.naty.graphicseditor.model;

import by.naty.graphicseditor.model.backSide.FigurePart;
import by.naty.graphicseditor.model.backSide.IEditable;
import by.naty.graphicseditor.model.serialization.SerializationReader;
import by.naty.graphicseditor.model.serialization.SerializationWriter;
import javafx.scene.canvas.GraphicsContext;


public abstract class AbstractFigure
{
    private double x1;
    private double y1;
    private double x2;
    private double y2;

    private String fillColor;
    private String penColor;

    public AbstractFigure(double x1, double y1, double x2, double y2)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        penColor = "#000";
        fillColor = "#ff0000";
    }


    public String getFillColor() {
        return fillColor;
    }

    public String getPenColor() {
        return penColor;
    }

    public void setPenColor(String penColor) {
        this.penColor = penColor;
    }

    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    public abstract void draw(GraphicsContext context);

    public abstract FigureType getType();

    private void setSizes(double x1, double y1, double x2, double y2)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public final void resize(double deltaX, double deltaY)
    {
        x2 += deltaX;
        y2 += deltaY;
    }

    public double getX1()
    {
        return x1;
    }

    public double getY1()
    {
        return y1;
    }

    public double getX2()
    {
        return x2;
    }

    public double getY2()
    {
        return y2;
    }

    public double getWidth()
    {
        return x2 - x1;
    }

    public double getHeight()
    {
        return y2 - y1;
    }

    public boolean contains(double x, double y)
    {
        return x1 <= x + NEAR_TOLERANCE && x - NEAR_TOLERANCE <= x2 && y1 <= y + NEAR_TOLERANCE && y - NEAR_TOLERANCE <= y2;
    }

    public void moveDelta(double deltaX, double deltaY)
    {
        x1 += deltaX;
        x2 += deltaX;
        y1 += deltaY;
        y2 += deltaY;
    }

    private boolean editable()
    {
        return this instanceof IEditable;
    }

    public void resizeMove(FigurePart part, double deltaX, double deltaY) {
        switch (part) {
            case LEFT_TOP:
                if (editable()) {
                    x1 += deltaX;
                    y1 += deltaY;
                }
                break;
            case RIGHT_BOTTOM:
                if (editable()) {
                    x2 += deltaX;
                    y2 += deltaY;
                }
                break;
            case INSIDE:
                moveDelta(deltaX, deltaY);
                break;
            case OUTSIDE:
                break;
        }
    }

    public FigurePart getFigurePart(double x, double y)
    {
        if (near(x1, x) && near(y1, y)) {
            return FigurePart.LEFT_TOP;
        }
        if (near(x2, x) && near(y2, y)) {
            return FigurePart.RIGHT_BOTTOM;
        }
        if (x1 <= x && x <= x2 && y1 <= y && y <= y2) {
            return FigurePart.INSIDE;
        }
        return FigurePart.OUTSIDE;
    }

    private static final int NEAR_TOLERANCE = 20;

    private static boolean near(double a, double b)
    {
        return Math.abs(a - b) < NEAR_TOLERANCE;
    }

    public void serialize(SerializationWriter writer) {
        writer.writeDouble(x1);
        writer.writeDouble(y1);
        writer.writeDouble(x2);
        writer.writeDouble(y2);
        writer.writeString(fillColor);
        writer.writeString(penColor);
    }

    public void deserialize(SerializationReader reader) {
        setSizes(reader.readDouble(), reader.readDouble(), reader.readDouble(), reader.readDouble());
        setFillColor(reader.readString());
        setPenColor(reader.readString());
    }
}
