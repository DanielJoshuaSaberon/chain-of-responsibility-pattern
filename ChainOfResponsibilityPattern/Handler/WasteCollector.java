package ChainOfResponsibilityPattern.Handler;

import ChainOfResponsibilityPattern.Request.WasteContainer;

public interface WasteCollector {
    void setNextCollector(WasteCollector nextCollector);
    void collectWaste(WasteContainer wasteContainer);
}
