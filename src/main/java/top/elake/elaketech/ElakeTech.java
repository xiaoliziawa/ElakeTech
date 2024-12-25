package top.elake.elaketech;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import top.elake.elaketech.datagen.resources.assets.model.ModBlockModel;
import top.elake.elaketech.datagen.resources.assets.model.ModBlockState;
import top.elake.elaketech.datagen.resources.assets.model.ModItemModel;
import top.elake.elaketech.datagen.resources.assets.model.ModToolItemModel;
import top.elake.elaketech.datagen.resources.assets.translation.i18n.Common;
import top.elake.elaketech.event.NoDiggingWood;
import top.elake.elaketech.register.ETCreativeModeTab;
import top.elake.elaketech.register.block.ChemicalAppliancesBlock;
import top.elake.elaketech.register.block.CommonBlock;
import top.elake.elaketech.register.block.Ore;
import top.elake.elaketech.register.item.ChemicalAppliancesItem;
import top.elake.elaketech.register.item.Elements;
import top.elake.elaketech.register.item.Materials;
import top.elake.elaketech.register.item.MetalIngot;
import top.elake.elaketech.register.tool.Bronze;
import top.elake.elaketech.register.tool.Flint;
import top.elake.elaketech.util.Registers;

/**
 * @author Erhai-lake Qi-Month
 */
@Mod(ElakeTech.MODID)
public class ElakeTech {
    /**
     * ModID
     */
    public static final String MODID = "elake_tech";

    /**
     * 构造函数
     *
     * @param event 事件总线
     */
    public ElakeTech(IEventBus event) {
        // 创造模式物品栏
        ETCreativeModeTab.register(event);
        // 元素
        Elements.register();
        // 材料
        Materials.register();
        // 化学用具(方块)
        ChemicalAppliancesBlock.register();
        // 矿物
        Ore.register();
        MetalIngot.register();
        // 方块
        CommonBlock.registers();
        // 化学工具(物品)
        ChemicalAppliancesItem.register();

        // 注册物品
        Registers.registerItems(event);
        // 注册方块
        Registers.registerBlocks(event);

        // 燧石工具
        Flint.register();
        // 青铜工具
        Bronze.register();

        //数据生成器
        // Common
        Common.registers();
        // 物品模型
        ModItemModel.registers();
        // 工具模型
        ModToolItemModel.registers();
        // 方块
        ModBlockModel.registers();
        // 方块状态
        ModBlockState.registers();

        // 非空手掘木
        NoDiggingWood.register(NeoForge.EVENT_BUS);
    }
}