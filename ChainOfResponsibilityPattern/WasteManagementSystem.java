package ChainOfResponsibilityPattern;

import ChainOfResponsibilityPattern.Chain.WasteCollectionChain;
import ChainOfResponsibilityPattern.Request.WasteContainer;

public class WasteManagementSystem {
    public static void main(String[] args) {
        WasteCollectionChain wasteCollectionChain = new WasteCollectionChain();

        String[] wastes = {
                "food", "plastic", "chemicals", "newspapers", "coffee grounds",
                "tea bags", "asbestos", "mercury", "rubber", "glass",
                "metal", "wood", "plastic", "food", "food"};

        System.out.println("Processing waste items:");
        for (String waste : wastes) {
            WasteContainer container = new WasteContainer(waste);
            wasteCollectionChain.getFirstCollector().collectWaste(container);
            System.out.println();
        }
    }
}
