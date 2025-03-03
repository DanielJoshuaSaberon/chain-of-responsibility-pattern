package ChainOfResponsibilityPattern.Chain;

import ChainOfResponsibilityPattern.ConcreteHandler.*;
import ChainOfResponsibilityPattern.Handler.WasteCollector;
import ChainOfResponsibilityPattern.Request.WasteContainer;


public class WasteCollectionChain implements WasteCollector{
    private WasteCollector firstCollector;

    public WasteCollectionChain() {
        firstCollector = new OrganicWasteCollector();
        WasteCollector recyclableCollector = new RecyclableWasteCollector();
        WasteCollector hazardousCollector = new HazardousWasteCollector();

        firstCollector.setNextCollector(recyclableCollector);
        recyclableCollector.setNextCollector(hazardousCollector);
    }

    public WasteCollector getFirstCollector() {
        return firstCollector;
    }

    @Override
    public void setNextCollector(WasteCollector nextCollector) {
        this.firstCollector = nextCollector;
    }

    @Override
    public void collectWaste(WasteContainer wasteContainer) {
        firstCollector.collectWaste(wasteContainer);
    }
}