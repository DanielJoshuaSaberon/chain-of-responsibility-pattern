package ChainOfResponsibilityPattern.Request;

import java.util.HashMap;

public class WasteContainer {
    private String type;
    private static final HashMap<String, String> wasteCategories = new HashMap<>();

    static {
        wasteCategories.put("food", "organic");
        wasteCategories.put("wood", "organic");
        wasteCategories.put("coffee grounds", "organic");
        wasteCategories.put("tea bags", "organic");

        wasteCategories.put("plastic", "recyclable");
        wasteCategories.put("newspapers", "recyclable");
        wasteCategories.put("glass", "recyclable");
        wasteCategories.put("metal", "recyclable");

        wasteCategories.put("chemicals", "hazardous");
        wasteCategories.put("asbestos", "hazardous");
        wasteCategories.put("mercury", "hazardous");
    }

    public WasteContainer(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return wasteCategories.getOrDefault(type, "unknown");
    }
}
