package by.naty.graphicseditor.model;

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
        return x1 <= x && x <= x2 && y1 <= y && y <= y2;
    }

    public void moveDelta(double deltaX, double deltaY)
    {
        x1 += deltaX;
        x2 += deltaX;
        y1 += deltaY;
        y2 += deltaY;
    }
}
