package top.elake.elaketech.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.apache.logging.log4j.core.tools.Generate;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.datagen.resources.assets.model.main.ModBlockModelGen;
import top.elake.elaketech.datagen.resources.assets.model.main.ModBlockStateGen;
import top.elake.elaketech.datagen.resources.assets.model.main.ModItemModelGen;
import top.elake.elaketech.datagen.resources.assets.translation.i18n.language.ZH;
import top.elake.elaketech.datagen.resources.assets.translation.i18n.language.EN;
import top.elake.elaketech.datagen.resources.data.tags.ETBlockTags;
import top.elake.elaketech.datagen.resources.data.worldgen.ore.ModWorldGen;

import java.util.concurrent.CompletableFuture;

/**
 * @author Erhai-lake Qi-Month
 */
@EventBusSubscriber(modid = ElakeTech.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DataGenerators {
    @SubscribeEvent

    public static void gatherData(GatherDataEvent event) {
        // 语言文件
        event.getGenerator().addProvider(event.includeClient(), (DataProvider.Factory<EN>) EN::new);
        event.getGenerator().addProvider(event.includeClient(), (DataProvider.Factory<ZH>) ZH::new);
        // 物品模型
        event.getGenerator().addProvider(event.includeClient(), (DataProvider.Factory<ModItemModelGen>)
                output -> new ModItemModelGen(output, event.getExistingFileHelper()));
        // 方块模型
        event.getGenerator().addProvider(event.includeClient(), (DataProvider.Factory<ModBlockModelGen>)
                output -> new ModBlockModelGen(output, event.getExistingFileHelper()));
        // 方块状态
        event.getGenerator().addProvider(event.includeClient(), (DataProvider.Factory<ModBlockStateGen>)
                output -> new ModBlockStateGen(output, event.getExistingFileHelper()));
        // 矿物生成
        event.getGenerator().addProvider(event.includeServer(), (DataProvider.Factory<ModWorldGen>)
                output -> new ModWorldGen(output, event.getLookupProvider()));
        // 方块标签
        event.getGenerator().addProvider(event.includeServer(), (DataProvider.Factory<ETBlockTags>)
                output -> new ETBlockTags(output, lp, ElakeTech.MODID, efh)
        );
    }
}