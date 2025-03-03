package ChainOfResponsibilityPattern.ConcreteHandler;

import ChainOfResponsibilityPattern.Handler.WasteCollector;
import ChainOfResponsibilityPattern.Request.WasteContainer;
import java.util.HashMap;

public class HazardousWasteCollector implements WasteCollector {
    private WasteCollector nextCollector;
    private static final HashMap<String, Boolean> hazardousWasteTypes = new HashMap<>();
    private static final int CAPACITY = 5;
    private int currentLoad = 0;

    static {
        hazardousWasteTypes.put("chemicals", true);
        hazardousWasteTypes.put("asbestos", true);
        hazardousWasteTypes.put("mercury", true);
    }

    @Override
    public void setNextCollector(WasteCollector nextCollector) {
        this.nextCollector = nextCollector;
    }

    @Override
    public void collectWaste(WasteContainer container) {
        if (hazardousWasteTypes.containsKey(container.getType())) {
            if (currentLoad < CAPACITY) {
                currentLoad++;
                System.out.println("Adding " + container.getType() + " to the hazardous container. ");
                System.out.println("container capacity: "+currentLoad + " / " + CAPACITY);
            } else {
                System.out.println("Hazardous container is full. Cannot accept " + container.getType());
            }
        } else if (nextCollector != null) {
            nextCollector.collectWaste(container);
        } else {
            System.out.println("No handler available for: " + container.getType());
        }
    }
}
