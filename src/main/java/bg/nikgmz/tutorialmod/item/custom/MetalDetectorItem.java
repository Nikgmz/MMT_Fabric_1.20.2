package bg.nikgmz.tutorialmod.item.custom;

import bg.nikgmz.tutorialmod.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;


public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient()){
            BlockPos posClicked;
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            ArrayList<BlockPos.Mutable> threeByThree = new ArrayList<>();
            posClicked = context.getBlockPos();
            fillList(threeByThree, posClicked);

            for (BlockPos.Mutable mutable : threeByThree) {
                for (int i = -64; i < mutable.getY(); ++i) {
                    BlockState state = context.getWorld().getBlockState(mutable.down(i));
                    if (isValuableBlock(state)) {
                        player.sendMessage(Text.literal("Valuable ore has been found nearby!"), false);
                        foundBlock = true;
                        break;
                    }
                }
                player.sendMessage(Text.literal(mutable.getX() + " " + mutable.getZ()), false);
                if (foundBlock) break;
            }
            if(!foundBlock){
                player.sendMessage(Text.literal("Nothing valuable here!"), false);
            }

        }

        return ActionResult.SUCCESS;
    }

    private boolean isValuableBlock(BlockState state) {
        return state.isOf(ModBlocks.THORIUM_ORE) || state.isOf(ModBlocks.URANIUM_ORE);
    }

    private void fillList(ArrayList<BlockPos.Mutable> tbt, BlockPos start){

        BlockPos.Mutable temp = start.mutableCopy();
        temp.set(start.getX(), start.getY(), start.getZ());
        tbt.add( temp);
        BlockPos.Mutable temp1 = start.mutableCopy();
        temp1.setX(start.getX()+1);
        tbt.add(temp1);
        BlockPos.Mutable temp2 = start.mutableCopy();
        temp2.setX(start.getX()+1);
        temp2.setZ(start.getZ()+1);
        tbt.add(temp2);
        BlockPos.Mutable temp3 = start.mutableCopy();
        temp3.setX(start.getX()+1);
        temp3.setZ(start.getZ()-1);
        tbt.add(temp3);
        BlockPos.Mutable temp4 = start.mutableCopy();
        temp4.setX(start.getX()-1);
        tbt.add(temp4);
        BlockPos.Mutable temp5 = start.mutableCopy();
        temp5.setX(start.getX()-1);
        temp5.setZ(start.getZ()+1);
        tbt.add(temp5);
        BlockPos.Mutable temp6 = start.mutableCopy();
        temp6.setX(start.getX()-1);
        temp6.setZ(start.getZ()-1);
        tbt.add(temp6);
        BlockPos.Mutable temp7 = start.mutableCopy();
        temp7.setZ(start.getZ()+1);
        tbt.add(temp7);
        BlockPos.Mutable temp8 = start.mutableCopy();
        temp8.setZ(start.getZ()-1);
        tbt.add(temp8);

    }
}
