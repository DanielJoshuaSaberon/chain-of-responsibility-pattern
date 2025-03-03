package ChainOfResponsibilityPattern.ConcreteHandler;

import ChainOfResponsibilityPattern.Handler.WasteCollector;
import ChainOfResponsibilityPattern.Request.WasteContainer;
import java.util.HashMap;

public class RecyclableWasteCollector implements WasteCollector {
    private WasteCollector nextCollector;
    private static final HashMap<String, Boolean> recyclableWasteTypes = new HashMap<>();
    private static final int CAPACITY = 5;
    private int currentLoad = 0;

    static {
        recyclableWasteTypes.put("plastic", true);
        recyclableWasteTypes.put("newspapers", true);
        recyclableWasteTypes.put("glass", true);
        recyclableWasteTypes.put("metal", true);
    }

    @Override
    public void setNextCollector(WasteCollector nextCollector) {
        this.nextCollector = nextCollector;
    }

    @Override
    public void collectWaste(WasteContainer container) {
        if (recyclableWasteTypes.containsKey(container.getType())) {
            if (currentLoad < CAPACITY) {
                currentLoad++;
                System.out.println("Adding " + container.getType() + " to the recyclable container. ");
                System.out.println("container capacity: "+currentLoad + " / " + CAPACITY);
            } else {
                System.out.println("Recyclable container is full. Cannot accept " + container.getType());
            }
        } else if (nextCollector != null) {
            nextCollector.collectWaste(container);
        } else {
            System.out.println("No handler available for: " + container.getType());
        }
    }
}