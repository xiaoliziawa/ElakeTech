package top.elake.elaketech.register.item.custom.function;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.NotNull;
import top.elake.elaketech.ElakeTech;

/**
 * 一级矿物探测器 - 只显示粒子效果
 * @author Qi-Month
 */
public class MetalDetector extends Item {
    public MetalDetector(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        ItemStack itemInHand = context.getItemInHand();
        Player player = context.getPlayer();
        boolean isClientSide = context.getLevel().isClientSide();
        
        if (!isClientSide) {
            BlockPos positionClicked = context.getClickedPos();
            boolean foundBlock = false;
            
            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState state = context.getLevel().getBlockState(positionClicked.below(i));

                if (isValuableBlock(state)) {
                    foundBlock = true;
                    spawnFoundParticles(context, player);
                    break;
                }
            }

            if (!foundBlock) {
                player.sendSystemMessage(Component.translatable("info." + ElakeTech.MODID + ".metal_detector"));
            }
        }

        // 损坏Item
        if (itemInHand.getMaxDamage() > itemInHand.getDamageValue()) {
            EquipmentSlot slot = context.getHand() ==
                    InteractionHand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
            itemInHand.hurtAndBreak(1, context.getPlayer(), slot);
        }

        return InteractionResult.SUCCESS;
    }

    private void spawnFoundParticles(UseOnContext context, Player player) {
        BlockPos playerPos = player.blockPosition();
        // 玩家腰部高度约为1.0格
        for(int j = 0; j < 5; j++) {
            double offsetX = context.getLevel().getRandom().nextDouble() * 0.5D - 0.25D;
            double offsetZ = context.getLevel().getRandom().nextDouble() * 0.5D - 0.25D;
            double offsetY = context.getLevel().getRandom().nextDouble() * 0.2D - 0.1D;
            ((ServerLevel)context.getLevel()).sendParticles(
                ParticleTypes.GLOW,
                playerPos.getX() + 0.5D + offsetX,
                playerPos.getY() + 1.0D + offsetY,
                playerPos.getZ() + 0.5D + offsetZ,
                1,
                0.0D, 0.0D, 0.0D,
                0.0D
            );
        }
    }

    /**
     * @param state 方块的状态
     */
    private boolean isValuableBlock(BlockState state) {
        return state.is(Tags.Blocks.ORES);
    }
}