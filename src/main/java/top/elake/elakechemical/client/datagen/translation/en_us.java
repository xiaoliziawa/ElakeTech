package top.elake.elakechemical.client.datagen.translation;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import top.elake.elakechemical.ElakeChemical;

/**
 * @author Erhai-lake
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public class en_us extends LanguageProvider {
    public en_us(PackOutput output) {
        super(output, ElakeChemical.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
//        add(Sundries.TEST.get(), "test");
    }
}
