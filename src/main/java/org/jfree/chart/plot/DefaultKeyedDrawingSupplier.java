package org.jfree.chart.plot;

import java.awt.Paint;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.Stroke;

import java.util.Map;
import java.util.HashMap;

public class DefaultKeyedDrawingSupplier implements KeyedDrawingSupplier, Cloneable {
    private DrawingSupplier seq_supplier;

    private Map<Comparable<?>, Paint> paintOverride = new HashMap<>();
    private Map<Comparable<?>, Paint> outlinePaintOverride = new HashMap<>();
    private Map<Comparable<?>, Paint> fillPaintOverride = new HashMap<>();
    private Map<Comparable<?>, Stroke> strokeOverride = new HashMap<>();
    private Map<Comparable<?>, Stroke> outlineStrokeOverride = new HashMap<>();
    private Map<Comparable<?>, Shape> shapeOverride = new HashMap<>();

    public DefaultKeyedDrawingSupplier() {
        seq_supplier = new DefaultDrawingSupplier();
    }

    public DefaultKeyedDrawingSupplier(final DrawingSupplier base) {
        seq_supplier = base;
    }

    /**
     * Returns the next paint in a sequence maintained by the supplier.
     *
     * @return The paint.
     */
    @Override
    public Paint getNextPaint() {
        return seq_supplier.getNextPaint();
    }

    /**
     * Returns the next outline paint in a sequence maintained by the supplier.
     *
     * @return The paint.
     */
    @Override
    public Paint getNextOutlinePaint() {
        return seq_supplier.getNextOutlinePaint();
    }

    /**
     * Returns the next fill paint in a sequence maintained by the supplier.
     *
     * @return The paint.
     *
     * @since 1.0.6
     */
    @Override
    public Paint getNextFillPaint() {
        return seq_supplier.getNextFillPaint();
    }

    /**
     * Returns the next <code>Stroke</code> object in a sequence maintained by
     * the supplier.
     *
     * @return The stroke.
     */
    @Override
    public Stroke getNextStroke() {
        return seq_supplier.getNextStroke();
    }

    /**
     * Returns the next <code>Stroke</code> object in a sequence maintained by
     * the supplier.
     *
     * @return The stroke.
     */
    @Override
    public Stroke getNextOutlineStroke() {
        return seq_supplier.getNextOutlineStroke();
    }

    /**
     * Returns the next <code>Shape</code> object in a sequence maintained by
     * the supplier.
     *
     * @return The shape.
     */
    @Override
    public Shape getNextShape() {
        return seq_supplier.getNextShape();
    }

    public void setPaintForKey(Comparable<?> key, Paint paint) {
        paintOverride.put(key, paint);
    }

    public void setOutlinePaintForKey(Comparable<?> key, Paint paint) {
        outlinePaintOverride.put(key, paint);
    }

    public void setFillPaintForKey(Comparable<?> key, Paint paint) {
        fillPaintOverride.put(key, paint);
    }

    public void setStrokeForKey(Comparable<?> key, Stroke stroke) {
        strokeOverride.put(key, stroke);
    }

    public void setOutlineStrokeForKey(Comparable<?> key, Stroke stroke) {
        outlineStrokeOverride.put(key, stroke);
    }

    public void setShapeForKey(Comparable<?> key, Shape shape) {
        shapeOverride.put(key, shape);
    }

    /**
     * Returns the next paint in a sequence maintained by the supplier,
     * contengent on a key
     *
     * @param key A series key.
     * @return The paint.
     */
    @Override
    public Paint getNextPaint(Comparable<?> key) {
        if (paintOverride.containsKey(key)) {
            return paintOverride.get(key);
        }
        return seq_supplier.getNextPaint();
    }

    /**
     * Returns the next outline paint in a sequence maintained by the supplier,
     * contengent on a key.
     *
     * @param key A series key.
     * @return The paint.
     */
    @Override
    public Paint getNextOutlinePaint(Comparable<?> key) {
        if (outlinePaintOverride.containsKey(key)) {
            return outlinePaintOverride.get(key);
        }
        return seq_supplier.getNextOutlinePaint();
    }

    /**
     * Returns the next fill paint in a sequence maintained by the supplier,
     * contengent on a key.
     *
     * @param key A series key.
     * @return The paint.
     *
     * @since 1.0.6
     */
    @Override
    public Paint getNextFillPaint(Comparable<?> key) {
        if (fillPaintOverride.containsKey(key)) {
            return fillPaintOverride.get(key);
        }
        return seq_supplier.getNextFillPaint();
    }

    /**
     * Returns the next <code>Stroke</code> object in a sequence maintained by
     * the supplier, contengent on a key.
     *
     * @param key A series key.
     * @return The stroke.
     */
    @Override
    public Stroke getNextStroke(Comparable<?> key) {
        if (strokeOverride.containsKey(key)) {
            return strokeOverride.get(key);
        }
        return seq_supplier.getNextStroke();
    }

    /**
     * Returns the next <code>Stroke</code> object in a sequence maintained by
     * the supplier, contengent on a key.
     *
     * @param key A series key.
     * @return The stroke.
     */
    @Override
    public Stroke getNextOutlineStroke(Comparable<?> key) {
        if (outlineStrokeOverride.containsKey(key)) {
            return outlineStrokeOverride.get(key);
        }
        return seq_supplier.getNextOutlineStroke();
    }

    /**
     * Returns the next <code>Shape</code> object in a sequence maintained by
     * the supplier, contengent on a key.
     *
     * @param key A series key.
     * @return The shape.
     */
    @Override
    public Shape getNextShape(Comparable<?> key) {
        if (shapeOverride.containsKey(key)) {
            return shapeOverride.get(key);
        }
        return seq_supplier.getNextShape();
    }

    /**
     * Tests this object for equality with another object.
     *
     * @param obj  the object (<code>null</code> permitted).
     *
     * @return A boolean.
     */
    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }

        if (!(obj instanceof DefaultKeyedDrawingSupplier)) {
            return false;
        }

        DefaultKeyedDrawingSupplier that = (DefaultKeyedDrawingSupplier) obj;
        if (!seq_supplier.equals(that.seq_supplier)) {
            return false;
        }

        return true;
    }


    /**
     * Returns a clone.
     *
     * @return A clone.
     *
     * @throws CloneNotSupportedException if a component of the supplier does
     *                                    not support cloning.
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        DefaultKeyedDrawingSupplier clone = (DefaultKeyedDrawingSupplier)super.clone();
        return clone;
    }
}
