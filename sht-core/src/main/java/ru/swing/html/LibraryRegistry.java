package ru.swing.html;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Holds tag factories for different namespaces
 */
public class LibraryRegistry {

    public static final String EMPTY_NAMESPACE = ".empty";
    private Map<String, TagFactory> factories = new HashMap<String, TagFactory>();

    private Log logger = LogFactory.getLog(LibraryRegistry.class);
    
    public void registerLibrary(String namespace, TagFactory factory) {
        factories.put(StringUtils.isNotEmpty(namespace) ? namespace : EMPTY_NAMESPACE, factory);
        logger.trace("Registered tag factory '"+factory.getClass().getName()+"' for namespace '"+namespace+"'");

    }

    public TagFactory getTagFactory(String namespace) {
        return factories.get(StringUtils.isNotEmpty(namespace) ? namespace : EMPTY_NAMESPACE);
    }

    /**
     * Notifies all libraries that they are loaded into the model
     * @param model model, holding libraries
     */
    public void libraryLoaded(DomModel model) {
        for (TagFactory factory : factories.values()) {
            factory.libraryLoaded(model);
        }
    }
}
