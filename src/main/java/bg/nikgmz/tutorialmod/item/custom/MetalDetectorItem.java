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
            BlockPos posClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            ArrayList<BlockPos> threeByThree = new ArrayList<>(9);
            for(int counter = 0; counter<9; ++counter){
                fillList(threeByThree, posClicked);
                for(int i = -64; i<threeByThree.get(counter).getY(); ++i){

                    BlockState state = context.getWorld().getBlockState(posClicked.down(i));
                    if(isValuableBlock(state)){
                        player.sendMessage(Text.literal("Valuable ore has been found nearby!"), false);
                        foundBlock = true;
                        break;
                    }
                }
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

    private void fillList(ArrayList<BlockPos> tbt, BlockPos start){
        tbt.add(start);

        BlockPos.Mutable temp = (BlockPos.Mutable) start;// CHECK THIS LINE MAY NOT TRANSFORM CORRECTLY

        temp.setX(temp.getX()+1);
        tbt.add(temp);
        temp.setZ(temp.getZ()+1);
        tbt.add(temp);
        temp.setZ(temp.getZ()-2);
        temp = (BlockPos.Mutable) start;

        temp.setX(temp.getX()-1);
        tbt.add(temp);
        temp.setZ(temp.getZ()+1);
        tbt.add(temp);
        temp.setZ(temp.getZ()-2);
        temp = (BlockPos.Mutable) start;

        temp.setZ(temp.getZ()+1);
        tbt.add(temp);
        temp.setZ(temp.getZ()-2);
        temp = (BlockPos.Mutable) start;//check these too

    }
}
