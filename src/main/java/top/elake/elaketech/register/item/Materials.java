package top.elake.elaketech.register.item;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import top.elake.elaketech.register.ETCreativeModeTab;
import top.elake.elaketech.util.Registers;

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
     * 石墨锭
     */
    public static final DeferredItem<Item> GRAPHITE_INGOT = Registers.registerItem("graphite_ingot", new Item.Properties());
    /**
     * 石墨板
     */
    public static final DeferredItem<Item> GRAPHITE_PLATE = Registers.registerItem("graphite_plate", new Item.Properties());
    /**
     * 青铜锭
     * 粉碎白云岩
     */
    public static final DeferredItem<Item> FRAGMENT_DOLOMITE = Registers.registerItem("fragment_dolomite", new Item.Properties());
    /**
     * 高岭土
     */
    public static final DeferredItem<Item> KAOLINITE = Registers.registerItem("kaolinite", new Item.Properties());
    /**
     * 耐火砖
     */
    public static final DeferredItem<Item> REFRACTORY_BRICK = Registers.registerItem("refractory_brick", new Item.Properties());
    /**
     * 潮湿耐火砖
     */
    public static final DeferredItem<Item> WET_REFRACTORY_BRICK = Registers.registerItem("wet_refractory_brick", new Item.Properties());
    /**
     * 耐火黏土
     */
    public static final DeferredItem<Item> REFRACTORY_CLAY_BALL = Registers.registerItem("refractory_clay_ball", new Item.Properties());
    /**
     * 注册
     */
    public static void register() {
        // 草纤维
        ETCreativeModeTab.addMaterials(GRASS_FIBER);
        // 草绳
        ETCreativeModeTab.addMaterials(GRASS_STRING);
        // 粗石墨
        ETCreativeModeTab.addMaterials(RAW_GRAPHITE);
        // 石墨
        ETCreativeModeTab.addMaterials(GRAPHITE_INGOT);
        // 石墨板
        ETCreativeModeTab.addMaterials(GRAPHITE_PLATE);

        // 粉碎白云岩
        ETCreativeModeTab.addMaterials(FRAGMENT_DOLOMITE);
        // 高岭土
        ETCreativeModeTab.addMaterials(KAOLINITE);
        // 耐火砖
        ETCreativeModeTab.addMaterials(REFRACTORY_BRICK);
        // 潮湿耐火砖
        ETCreativeModeTab.addMaterials(WET_REFRACTORY_BRICK);
        // 耐火黏土
        ETCreativeModeTab.addMaterials(REFRACTORY_CLAY_BALL);
    }
}