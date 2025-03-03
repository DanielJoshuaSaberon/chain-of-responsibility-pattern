package ChainOfResponsibilityPattern.ConcreteHandler;

import ChainOfResponsibilityPattern.Handler.WasteCollector;
import ChainOfResponsibilityPattern.Request.WasteContainer;
import java.util.HashMap;

public class OrganicWasteCollector implements WasteCollector {
    private WasteCollector nextCollector;
    private static final HashMap<String, Boolean> organicWasteTypes = new HashMap<>();
    private static final int CAPACITY = 5;
    private int currentLoad = 0;

    static {
        organicWasteTypes.put("food", true);
        organicWasteTypes.put("wood", true);
        organicWasteTypes.put("coffee grounds", true);
        organicWasteTypes.put("tea bags", true);
    }

    @Override
    public void setNextCollector(WasteCollector nextCollector) {
        this.nextCollector = nextCollector;
    }

    @Override
    public void collectWaste(WasteContainer container) {
        if (organicWasteTypes.containsKey(container.getType())) {
            if (currentLoad < CAPACITY) {
                currentLoad++;
                System.out.println("Adding " + container.getType() + " to the organic container. ");
                System.out.println("container capacity: "+currentLoad + " / " + CAPACITY);
            } else {
                System.out.println("Organic container is full. Cannot accept " + container.getType());
            }
        } else if (nextCollector != null) {
            nextCollector.collectWaste(container);
        } else {
            System.out.println("No handler available for: " + container.getType());
        }
    }
}