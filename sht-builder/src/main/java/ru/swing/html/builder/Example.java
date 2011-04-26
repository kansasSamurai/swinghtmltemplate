package ru.swing.html.builder;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Created by IntelliJ IDEA.
 * User: Deady
 * Date: 26.04.11
 * Time: 13:55
 */
public class Example {

    private String name;
    private String source;
    private String[] path;

    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public Example() {
    }

    public Example(String name, String source, String[] path) {
        this.name = name;
        this.source = source;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String old = this.name;
        this.name = name;
        pcs.firePropertyChange("name", old, name);
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        String old = this.source;
        this.source = source;
        pcs.firePropertyChange("source", old, source);
    }

    public String[] getPath() {
        return path;
    }

    public void setPath(String[] path) {
        String[] old = this.path;
        this.path = path;
        pcs.firePropertyChange("path", old, path);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        return name;
    }
}