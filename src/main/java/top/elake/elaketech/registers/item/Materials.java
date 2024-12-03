package top.elake.elaketech.registers.item;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import top.elake.elaketech.registers.ModCreativeModeTab;
import top.elake.elaketech.utils.Registers;

/**
 * @author Erhai-lake
 */
public class Materials {
    /**
     * 草纤维
     */
    public static final DeferredItem<Item> GRASS_FIBER = Registers.registerItem("grass_fiber", new Item.Properties());
    /**
     * 草绳
     */
    public static final DeferredItem<Item> GRASS_STRING = Registers.registerItem("grass_string", new Item.Properties());
    /**
     * 粗石磨
     */
    public static final DeferredItem<Item> RAW_GRAPHITE = Registers.registerItem("raw_graphite", new Item.Properties());
    /**
     * 石墨
     */
    public static final DeferredItem<Item> GRAPHITE_INGOT = Registers.registerItem("graphite_ingot", new Item.Properties());
    /**
     * 石墨板
     */
    public static final DeferredItem<Item> GRAPHITE_PLATE = Registers.registerItem("graphite_plate", new Item.Properties());
    /**
     * 青铜
     */
    public static final DeferredItem<Item> BRONZE_INGOT = Registers.registerItem("bronze_ingot", new Item.Properties());

    /**
     * 注册
     */
    public static void register() {
        // 草纤维
        ModCreativeModeTab.addMaterials(GRASS_FIBER);
        // 草绳
        ModCreativeModeTab.addMaterials(GRASS_STRING);
        // 粗石墨
        ModCreativeModeTab.addMaterials(RAW_GRAPHITE);
        // 石墨
        ModCreativeModeTab.addMaterials(GRAPHITE_INGOT);
        // 石墨板
        ModCreativeModeTab.addMaterials(GRAPHITE_PLATE);
        // 青铜
        ModCreativeModeTab.addMaterials(BRONZE_INGOT);
    }
}